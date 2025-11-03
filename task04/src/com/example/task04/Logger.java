package com.example.task04;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Logger {
    private final String name;
    private static final HashMap<String, Logger> loggers = new HashMap<>();
    private ImportantLevels level;
    private static ArrayList<MessageHandler> handlers = new ArrayList<>();

    public Logger(String name) {
        this.name = name;
        this.level = ImportantLevels.INFO;
        loggers.put(name, this);
        handlers.add(new ConsoleHandler());
    }
    
    public Logger(String name, ArrayList<MessageHandler> handlers) {
        this.name = name;
        this.level = ImportantLevels.INFO;
        loggers.put(name, this);
        this.handlers = handlers;
    }

    public Logger(String name, ImportantLevels level, ArrayList<MessageHandler> handlers) {
        this.name = name;
        this.level = level;
        loggers.put(name, this);
        this.handlers = handlers;
    }

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name) {
        if (loggers.containsKey(name)) {
            return loggers.get(name);
        }
        return new Logger(name);
    }

    public ImportantLevels getLevel() {
        return level;
    }

    public void setLevel(ImportantLevels level) {
        this.level = level;
    }

    public void log(ImportantLevels level, String message) {
        if (this.level.ordinal() <= level.ordinal()) {
            String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
            String formattedMessage = MessageFormat.format("[{0}] {1} {2} - {3}", level, dateTime, name, message);
            for (MessageHandler handler: handlers) {
                handler.log(formattedMessage);
            }
        }
    }

    public void log(ImportantLevels level, String pattern, Object... args) {
        if (this.level.ordinal() <= level.ordinal()) {
            for (MessageHandler handler: handlers) {
                handler.log(MessageFormat.format(pattern, args));
            }
        }
    }

    public void debug(String message) {
        log(ImportantLevels.DEBUG, message);
    }

    public void debug(String pattern, Object... args) {
        log(ImportantLevels.DEBUG, pattern, args);
    }

    public void info(String message) {
        log(ImportantLevels.INFO, message);
    }

    public void info(String pattern, Object... args) {
        log(ImportantLevels.INFO, pattern, args);
    }

    public void warning(String message) {
        log(ImportantLevels.WARNING, message);
    }

    public void warning(String pattern, Object... args) {
        log(ImportantLevels.WARNING, pattern, args);
    }

    public void error(String message) {
        log(ImportantLevels.ERROR, message);
    }

    public void error(String pattern, Object... args) {
        log(ImportantLevels.ERROR, pattern, args);
    }
}