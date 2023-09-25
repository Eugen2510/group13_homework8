package org.homework8;

import org.homework8.connection.ConnectConstants;
import org.homework8.execute.Starter;

public class App {
    public static void main(String[] args) {
        Starter starter = new Starter(ConnectConstants.MIGRATION_SCRIPTS_PATH,
                ConnectConstants.URL,
                ConnectConstants.USER,
                ConnectConstants.PASSWORD);
        starter.startApp();
    }

}
