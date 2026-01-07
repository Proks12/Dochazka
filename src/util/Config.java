package util;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {

    private static Properties props = new Properties();

    static {
        try {
            props.load(new FileInputStream("config.properties"));
        } catch (Exception e) {
            throw new RuntimeException("Chyba konfigurace", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
