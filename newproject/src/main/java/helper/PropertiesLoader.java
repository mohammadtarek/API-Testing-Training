package helper;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    public static String readProperties(String key) {
        Properties properties = new Properties();
        try {
        properties.load(new BufferedReader(new FileReader("src/main/resources/config.properties")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  properties.getProperty(key);
    }

}
