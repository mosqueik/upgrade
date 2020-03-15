package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {

    public static Properties prop = null;

    public static void loadProperties(String filename) {
        try (InputStream input = LoadProperties.class.getClassLoader().getResourceAsStream(filename)) {
            prop = new Properties();

            if (input == null) {
                prop = null;
            } else {
                prop.load(input);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
