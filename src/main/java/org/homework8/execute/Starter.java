package org.homework8.execute;

import org.flywaydb.core.Flyway;
import org.homework8.connection.ConnectConstants;
import org.homework8.connection.Connector;
import org.homework8.file_writing.CreateFileWithData;
import org.homework8.flyway.FlywayConfigurator;
import org.homework8.pojo.ResidentPOJO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Starter {

    private final Flyway flyway;
    private final Connection connection;
    private final String sql = "SELECT\n" +
            "r.id, \n"+
            "    r.name,\n" +
            "    r.email,\n" +
            "    b.num_of_flat,\n" +
            "    b.adress,\n" +
            "    f.apartment_number,\n" +
            "    f.area\n" +
            "FROM\n" +
            "    resident r\n" +
            "JOIN\n" +
            "    flat_owner fo ON r.id = fo.resident_id\n" +
            "JOIN\n" +
            "    flat f ON r.flat_id = f.id\n" +
            "JOIN\n" +
            "    building b ON r.building_id = b.id\n" +
            "WHERE\n" +
            "    r.parking_right = 0\n" +
            "    AND r.ownership = 1\n" +
            "    AND (SELECT COUNT(*) FROM flat_owner fo2 WHERE fo2.resident_id = r.id) < 2;";

    private List<ResidentPOJO> residents;


    public Starter (ConnectConstants pathDB, ConnectConstants url, ConnectConstants user, ConnectConstants password){
        flyway = new FlywayConfigurator(pathDB,user, password, url).getFlyway();
        connection = new Connector().getConnection(url, user, password);
    }



    public void fillResidents(){
        residents = new ArrayList<>();
        try(ResultSet resultSet = new StatementExecutor().executeQuery(connection, sql)) {
            while (resultSet.next()){
                ResidentPOJO resident= new ResidentPOJO();

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int flatNumber = resultSet.getInt("apartment_number");
                String address = resultSet.getString("adress");
                int area = resultSet.getInt("area");

                resident.setId(id);
                resident.setEmail(email);
                resident.setName(name);
                resident.setAddress(address);
                resident.setFlatNumber(flatNumber);
                resident.setFlatArea(area);
                residents.add(resident);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void printToConsole(){
        fillResidents();
        for (ResidentPOJO resident : residents) {
            System.out.println(resident);
        }
    }

    private void writeToFile(){
        fillResidents();
        CreateFileWithData.writeData("src/main/java/org/homework8/output_files/data_from_db.txt", residents);
    }

    public void startApp(){
        new DBMigrationExecutor().startMigration(flyway);
        writeToFile();
        printToConsole();


    }

}
