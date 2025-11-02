package com.example.task01;

import com.sun.xml.internal.ws.wsdl.writer.document.Import;

import java.util.HashMap;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private final String name;
    private static final HashMap<String, Logger> loggers = new HashMap<>();
    private ImportantLevels level;

    public Logger(String name) {
        this.name = name;
        loggers.put(name, this);
    }

    public Logger(String name, ImportantLevels level) {
        this.name = name;
        this.level = level;
        loggers.put(name, this);
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
            System.out.println(formattedMessage);
        }
    }

    public void log(ImportantLevels level, String pattern, Object... args) {
        if (this.level.ordinal() <= level.ordinal()) {
            System.out.println(MessageFormat.format(pattern, args));
        }
    }

    public void debug(String message) {
        log(ImportantLevels.DEBUG, message);
    }

    public void debug(String pattern, Object... args) {
        log(ImportantLevels.DEBUG, pattern, args);
    }

    public void info(String message) {
        log(ImportantLevels.DEBUG, message);
    }

    public void info(String pattern, Object... args) {
        log(ImportantLevels.DEBUG, pattern, args);
    }

    public void warning(String message) {
        log(ImportantLevels.DEBUG, message);
    }

    public void warning(String pattern, Object... args) {
        log(ImportantLevels.DEBUG, pattern, args);
    }

    public void error(String message) {
        log(ImportantLevels.DEBUG, message);
    }

    public void error(String pattern, Object... args) {
        log(ImportantLevels.DEBUG, pattern, args);
    }
}