package codechallenge.perfectnumbers.init;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

/**
 * @author kolin
 *
 */
public class ConfigUtility {

    private static final Logger logger = LogManager.getLogger(ConfigUtility.class);

    private static ConfigUtility instance = new ConfigUtility();
    private static Properties properties;

    public static ConfigUtility getInstance() {
        synchronized (ConfigUtility.class) {
            return instance;
        }
    }

    public String getProperty(final String key) {
        return properties.getProperty(key);
    }

    private ConfigUtility() {
        logger.info(" Property loading started");

        properties = new Properties();
        try {
            properties.load(ConfigUtility.class.getClassLoader().getResourceAsStream("conf.properties"));
        } catch (IOException e) {
            logger.fatal("Failed property loading ", e);
        }

        logger.info(" Property loading done");
        
    }
}