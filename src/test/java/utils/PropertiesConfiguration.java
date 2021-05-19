package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfiguration {

    public static Properties properties;

    public static final String EXECUTION_ENVIRONMENT = getPropertyFile().getProperty("environment");
    public static final String BROWSER_DRIVER = getPropertyFile().getProperty("chrome.driver.location");
    public static final Long DEFAULT_WAIT_TIME = Long.valueOf(getPropertyFile().getProperty("default.wait.time"));


    private static Properties getPropertyFile(){
        if(properties == null){
            try{
                FileInputStream propFile = new FileInputStream("./src/main/resources/system.properties");
                properties = new Properties(System.getProperties());
                properties.load(propFile);

                return properties;
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            return properties;
        }
        return null;
    }

}
