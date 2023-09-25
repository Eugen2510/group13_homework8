package org.homework8.file_writing;


import org.homework8.pojo.ResidentPOJO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CreateFileWithData {
    public static void writeData(String filePath, List<ResidentPOJO> residents){
        try(FileWriter writer = new FileWriter(filePath)) {
            for (ResidentPOJO resident : residents) {
                writer.write(resident.toString() + "\n");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
