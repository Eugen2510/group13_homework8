package org.homework8.execute;

import org.flywaydb.core.Flyway;


public class DBMigrationExecutor {
    public void startMigration(Flyway flyway){
        flyway.migrate();
    }

}
