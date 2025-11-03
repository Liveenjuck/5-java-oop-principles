package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHandler implements MessageHandler {
    private final PrintWriter writer;

    public FileHandler(String file_path, boolean appendable) throws IOException {
        writer = new PrintWriter(new FileWriter(file_path, appendable));
    }

    @Override
    public void log(String message) {
        writer.println(message);
        writer.close();
    }
}
