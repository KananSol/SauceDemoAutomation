import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class ConfigReader {

    private Properties properties;

    public ConfigReader() {
        InputStream input = getClass()
                .getClassLoader()
                .getResourceAsStream("config.properties");

        if (input == null) {
            throw new RuntimeException("config.properties file not found");
        }

        properties = new Properties();

        try {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Config file could not be loaded", e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}