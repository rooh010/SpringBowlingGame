package com.example.bowling.helpers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GetProperties {
    Map<String, String> result = new HashMap<String, String>();
    InputStream inputStream;

    public Map<String, String> getPropValues() throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "application.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value
            String db_hostname = prop.getProperty("db_hostname");
            String db_username = prop.getProperty("db_username");
            String db_database = prop.getProperty("db_database");

            result.put("db_hostname", db_hostname);
            result.put("db_username", db_username);
            result.put("db_database", db_database);


            Properties secrets = new Properties();
            String secretsFileName = "secrets.properties";

            inputStream.close();
            inputStream = getClass().getClassLoader().getResourceAsStream(secretsFileName);

            if (inputStream != null) {
                secrets.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + secretsFileName + "' not found in the classpath");
            }

            // get the secret value
            String db_password = secrets.getProperty("db_password");

            result.put("db_password", db_password);

            result.put("jdbc_url", "jdbc:mysql://" + db_hostname + "/" + db_database);

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return result;
    }
}
