package org.homework8.connection;

public enum ConnectConstants {
    USER("root"),
    PASSWORD("myPassword123"),
    URL("jdbc:mysql://localhost:3306/residential_complex"),
    MIGRATION_SCRIPTS_PATH ("classpath:db/scripts");
    private final String value;
    public String getValue(){
        return value;
    }


    ConnectConstants(String value){
        this.value = value;
    }
}
