package framework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperty {

    public static String getProperty(String property) {
        Properties properties = new Properties();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("data.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(property);
    }
}
