package utils;

import java.util.Properties;

public class ConfigLoader {

    private  final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader() {

        String env = System.getProperty("env", "STAGE");
        switch (env) {
            case "PROD":
                properties= PropertyUtils.propertyLoader("src/test/resources/prod_config.properties");
                 break;
            case "STAGE":
                properties=PropertyUtils.propertyLoader("src/test/resources/stage_config.properties");
                break;
            default:
                throw new IllegalStateException("Invalid environment: "+env);
        }

    }
    public static ConfigLoader getInstance(){
        if(configLoader==null){
            configLoader= new ConfigLoader();

        }
        return  configLoader;
    }

    public String getURL(){
     return properties.getProperty("baseURL") ;
    }
    public String getUsername(){
        return properties.getProperty("username");
    }

}
