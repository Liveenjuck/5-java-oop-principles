package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger1 = new Logger("name");
        Logger logger2 = Logger.getLogger("name1");
        Logger logger3 = Logger.getLogger("name1");
        System.out.println(logger1 == logger2);
        System.out.println(logger2 == logger3);
    }
}
