package com.company.Operations;

import com.company.database.*;
import com.company.planes.*;

import java.sql.*;
import java.util.*;

public abstract class Operations {


    private static LinkedList<Plane> planes = new LinkedList<Plane>();

    public void viewPlanes() throws SQLException {
        updateData();
        for (Plane plane: planes){
            System.out.println(plane.toString());
        }
    }

    public void updateData() throws SQLException {

        String query = "select * from airplanes";
        ResultSet read = Db_Operations.read(query);

        while (read.next()) {
            Plane plane = new Plane();
            plane.setName(read.getString("plane_name"));
            plane.setSeating_capacity(read.getInt("plane_seating_capacity"));
            plane.setAvailable_seats(read.getInt("plane_available_seats"));
            planes.add(plane);
        }
    }


}
