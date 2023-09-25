package org.homework8.flyway;

import org.flywaydb.core.Flyway;
import org.homework8.connection.ConnectConstants;

public class FlywayConfigurator {
    private final String path;
    private final String user;
    private final String password;
    private final String url;

    public FlywayConfigurator(ConnectConstants path, ConnectConstants user,
                              ConnectConstants password, ConnectConstants url){
        this.path = path.getValue();
        this.user = user.getValue();
        this.password = password.getValue();
        this.url = url.getValue();
    }

    public Flyway getFlyway(){
        return Flyway.configure()
                .dataSource(url, user, password)
                .locations(path)
                .load();
    }
}
