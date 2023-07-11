package com.company.Operations;

import com.company.database.*;

public class AdminOperations extends Operations {

    public void addPlane(String name, int seating_capacity) {
        Db_Operations.insert("INSERT INTO airplanes (plane_name,plane_seating_capacity,plane_available_seats) " +
                "VALUES (" + "'" + name + "'" + "," + "'" + seating_capacity + "'" + "," + "'" + seating_capacity + "'" + ")");
    }

    public void updatePlane(String name,int seating_capacity,int available_seats,int plane_id){

        Db_Operations.insert("update airplanes set plane_name = '" + name + "'"  +
                "," +  "plane_seating_capacity = " +  seating_capacity +
                "," +  "plane_available_seats = " +  available_seats  +
                " where plane_id = " + plane_id + ";");

    }

    public void deletePlane(int plane_id) {
        Db_Operations.insert("Delete from airplanes where plane_id = " + plane_id + ";");
    }

}
