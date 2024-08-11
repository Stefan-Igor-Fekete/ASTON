package utils;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
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

    public static String readJsonFromFile(String filePath, String key) throws IOException, JSONException {
        InputStream is = LoadProperties.class.getClassLoader().getResourceAsStream(filePath);
        if (is == null) {
            throw new IOException("File not found: " + filePath);
        }
        String jsonTxt = IOUtils.toString(is, StandardCharsets.UTF_8);
        JSONObject jsonObject = new JSONObject(jsonTxt);
        return jsonObject.getJSONObject(key).toString();
    }
}