package org.homework8;

import org.homework8.execute.QueryExecutor;
import org.homework8.flyway.MigrationStarter;

public class App {
    public static void main(String[] args) {
        QueryExecutor executor = new QueryExecutor();

        MigrationStarter.startMigration();
        executor.executeQuery();
    }

}
