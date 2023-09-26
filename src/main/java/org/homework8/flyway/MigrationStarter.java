package org.homework8.flyway;

import org.flywaydb.core.Flyway;
import org.homework8.connection.ConnectionConstantsLoader;
import org.homework8.connection.PathConstants;

import java.util.Properties;

public class MigrationStarter {

    public static void startMigration(){
        Properties properties = ConnectionConstantsLoader.loadConnectionConstants(PathConstants.DB_CONNECTION_PROPERTIES);
        String path = PathConstants.FLYWAY_SCRIPTS_PATH;
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");

        Flyway flyway =  Flyway.configure()
                .dataSource(url, user, password)
                .locations(path)
                .load();
        flyway.migrate();
    }
}
