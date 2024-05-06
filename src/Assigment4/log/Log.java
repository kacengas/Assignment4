package Assigment4.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    private static final Log instance = new Log();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Log() {
    }

    public static Log getInstance() {
        return instance;
    }

    public void logAction(String actor, String action) {
        LocalDateTime now = LocalDateTime.now();
        String formattedTime = now.format(formatter);

        System.out.println(formattedTime + " - " + actor + ": " + action);
    }
}
