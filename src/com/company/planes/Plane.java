package com.company.planes;

import com.company.database.Db_Operations;
import com.mysql.cj.conf.StringProperty;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Plane {
    private StringProperty plane;
    private String name;
    private int seating_capacity;
    private int available_seats;

    //pilot id

    public Plane(){}

    public Plane(String name, int seating_capacity,StringProperty plane) {
        setName(name);
        setSeating_capacity(seating_capacity);
        this.plane = plane;
    }

    public StringProperty getPlane() {
        return plane;
    }
//    public static void Getnames(ObservableList<String>Names){
//        try{
//            String query = "select plane_name from airplanes;";
//            ResultSet rs = Db_Operations.read(query);
//            while (rs.next()){
//                new String(rs.getString("plane_name"));
//            }
//
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//
//    }

    public void setPlane(StringProperty plane) {
        this.plane = plane;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeating_capacity(int seating_capacity) {
        this.seating_capacity = seating_capacity;
    }

    public void setAvailable_seats(int available_seats) {
        this.available_seats = available_seats;
    }

    public String getName() {
        return name;
    }

    public int getSeating_capacity() {
        return seating_capacity;
    }

    public  int getAvailable_seats() {
        return available_seats;
    }

    @Override
    public String toString(){
        return "\nName: "+getName() + "\n"
                + "Seating Capacity: "+getSeating_capacity() + "\n"
                + "Available Seats: "+getAvailable_seats();
    }

}
