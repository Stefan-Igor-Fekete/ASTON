package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {

    public static String getProperty(String property) {
        Properties properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("data.properties")) {
            properties.load(inputStream);
        } catch (IOException | IllegalArgumentException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return properties.getProperty(property);
    }
}