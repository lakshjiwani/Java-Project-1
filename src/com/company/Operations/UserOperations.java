package com.company.Operations;

import com.company.database.Db_Operations;

import java.sql.ResultSet;

public class UserOperations extends Operations {

    public void bookFlight(int userId , int flightId , int quantity, int price, int available_seats,int plane_id){
        String query1 = "insert into booking(user_detail,flight_detail,ticket_qty,ticket_amount)" +
                "values (" + "'" + userId + "'" + "," + "'" + flightId + "'" +
                "," + "'" + quantity + "'" + "," + "'" + (quantity*price) + "'" + ");";

        String query2 = "update airplanes set plane_available_seats = "+(available_seats-quantity)+ " where " +
                "plane_id = "+plane_id+";";

        Db_Operations.insert(query1);
        Db_Operations.insert(query2);

    }

    // public void updateInfo(){}

}
