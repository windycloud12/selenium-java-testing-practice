package common.utils;

import common.listeners.LogListener;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerManager {

    private static Logger logger;

    public static Logger getLogger() {
        if (logger == null) {
            logger = Logger.getLogger(LogListener.class);
            PropertyConfigurator.configure("./src/main/resources/log4j.properties");
        }

        return logger;
    }

}
