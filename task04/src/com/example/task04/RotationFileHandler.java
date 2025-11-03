package com.example.task04;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {
    private final ChronoUnit rotation;
    private final String path;

    public RotationFileHandler(ChronoUnit rotation, String path) {
        this.rotation = rotation;
        this.path = path;
    }

    @Override
    public void log(String message) {
        LocalDateTime date = LocalDateTime.now().truncatedTo(rotation);
        File file = new File(path + date.toString().replace('T', '_') + ".txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(message.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
