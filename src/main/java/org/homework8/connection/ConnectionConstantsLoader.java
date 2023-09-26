package org.homework8.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConnectionConstantsLoader {

    public static Properties loadConnectionConstants(String propertiesFilePath){

        Properties properties = new Properties();
        try(FileInputStream fis = new FileInputStream(propertiesFilePath);) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
