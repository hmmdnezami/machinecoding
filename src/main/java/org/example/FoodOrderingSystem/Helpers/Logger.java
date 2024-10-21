package org.example.FoodOrderingSystem.Helpers;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    // Static method to log the message
    public static void log(String message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String timestamp = LocalDateTime.now().format(formatter);
        String logMessage = timestamp + " : " + message;

        try (FileWriter writer = new FileWriter("./log.txt", true)) {
            writer.write(logMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
