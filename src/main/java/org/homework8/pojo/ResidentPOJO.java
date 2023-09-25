package org.homework8.pojo;

import lombok.Data;

@Data
public class ResidentPOJO {
    private int id;
    private  String name;
    private String email;
    private String address;
    private int flatNumber;
    private int flatArea;

    @Override
    public String toString() {
        return
                id +
                ", " + name +
                ", " + email +
                ", " + address +
                ", " + flatNumber +
                ", " + flatArea;
    }
}
