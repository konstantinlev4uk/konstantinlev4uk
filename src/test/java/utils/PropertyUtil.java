package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertyUtil {

    static Logger log = Logger.getLogger(PropertyUtil.class.getName());

    public static Properties getProperties(String fileName) {
        Properties propertiesDriver;
        InputStream inputStreamDriver = PropertyUtil.class.getClassLoader().getResourceAsStream(fileName);
        propertiesDriver = new Properties();
        try {
            propertiesDriver.load(inputStreamDriver);
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        return propertiesDriver;
    }
}
