package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Utility  {

    private static final String DATA_CONFIG = "./Config/config.properties";
    private static Properties properties;

    public static String fetchvalue(String value) {
        try {
            if (properties == null) {
                Utility.properties = new Properties();
                Utility.properties.load(new FileInputStream(DATA_CONFIG));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return Utility.properties.getProperty(value);
    }

    public static String generateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}

