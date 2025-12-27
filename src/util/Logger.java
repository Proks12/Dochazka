package util;

public class Logger {
    public void error(String message, Exception e) {
        System.err.println(message);
        e.printStackTrace();
    }
}
