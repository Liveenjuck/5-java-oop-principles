package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {
    private final int maxSize;
    private final ArrayList<String> messages = new ArrayList<>();
    private final MessageHandler proxy;

    public MemoryHandler(int maxSize, MessageHandler proxy) {
        this.maxSize = maxSize;
        this.proxy = proxy;
    }

    public void clear() {
        for (String message: messages) {
            proxy.log(message);
        }
        messages.clear();
    }

    @Override
    public void log(String message) {
        messages.add(message);
        if (messages.size() > maxSize) {
            clear();
        }
    }
}