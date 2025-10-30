package com.example.task01;

public class Logger {
    private final String name;
    
    public Logger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name) {
        return new Logger(name);
    }

}
