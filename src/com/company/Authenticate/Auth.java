package com.company.Authenticate;

import com.company.Operations.*;
import com.company.Session.*;
import com.company.database.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.sql.*;
import java.util.*;

public class Auth {

    private String name;
    private String password;
    private int type;
    @FXML
    private RadioButton user_radio;
    @FXML
    private RadioButton staff_radio;
    @FXML
    private Label wrongpassword;


    public Auth(String name, String password) throws Exception {
        setName(name);
        setPassword(password);
//        setType(type);
//        getStaff(name, password);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getType() {
        return type;
    }
    public Session getStaff(String email,String password) throws SQLException{
        ResultSet read = null;
        Session activeSession = new Session();
        String query1 = "SELECT * from staff where email = '" + email + "' and password = '" + password + "'";
        read = Db_Operations.read(query1);
        while (read.next()) {
            activeSession.setEmail(read.getString("email"));
            activeSession.setPassword(read.getString("password"));
            activeSession.setRole(read.getInt("role"));
            Session.setSessionId(read.getInt("staff_id"));
        }
        if(activeSession.getEmail() == null && activeSession.getPassword() == null){
            return null;
        }
        return activeSession;
    }
    public Session getUser(String email,String password) throws SQLException{
        ResultSet read = null;
        Session activeSession = new Session();
        String query2 = "SELECT * FROM users where email = '" + email + "' and password = '" + password + "'";
        read = Db_Operations.read(query2);
        while (read.next()) {
            activeSession.setEmail(read.getString("email"));
            activeSession.setPassword(read.getString("password"));
            Session.setSessionId(read.getInt("user_id"));
        }
        if(activeSession.getEmail() == null && activeSession.getPassword() == null){
            return null;
        }
        return activeSession;
    }

//    public Session getUser(String name, String password) throws SQLException {
//
//        ResultSet read = null;
//        int role = 0;
//        Session activeSession = new Session();
//
//        switch (type) {
//            case 1:
//                String query1 = "SELECT * from staff where name = '" + name + "' and password = '" + password + "'";
//                read = Db_Operations.read(query1);
//                while (read.next()) {
//                    activeSession.setUsername(read.getString("name"));
//                    activeSession.setPassword(read.getString("password"));
//                    activeSession.setRole(read.getInt("role"));
//                }
//                break;
//
//            case 2:
//                String query2 = "SELECT * FROM user where name = '" + name + "' and password = '" + password + "'";
//                read = Db_Operations.read(query2);
//                while (read.next()) {
//                    activeSession.setUsername(read.getString("name"));
//                    activeSession.setPassword(read.getString("password"));
//                    break;
//                }
//                break;
//
//            default:
//                System.out.println("Invalid type entered");
//                break;
//        }


//
//        if (activeSession.getUsername().length() <= 0 && activeSession.getPassword().length() <= 0) {
//            System.out.println("No record found");
//            return null;
//        }

//        if(type == 1){
//            Scanner scanner = new Scanner(System.in);
//
//            AdminOperations AO = new AdminOperations();
//
//            if(activeSession.getRole() == 1){
//                return activeSession;
//
//                System.out.print("\n-----ADMIN OPERATIONS-----");
//                System.out.print("\n1) View airplanes");
//                System.out.print("\n2) Add an airplane");
//                System.out.print("\n3) Delete an airplane");
//                System.out.print("\n4) Update an airplane");
//
//                System.out.print("\nPlease enter choice: ");
//                int input = scanner.nextInt();
//
//                switch(input){
//
//                    case 1:
//                        AO.viewPlanes();
//                        break;
//
//                    case 2:
//                        System.out.println("\nEnter plane name: ");
//                        scanner.nextLine();
//                        String plane_name = scanner.nextLine();
//                        System.out.print("\nEnter plane seating capacity: ");
//                        int capacity = scanner.nextInt();
//                        AO.addPlane(plane_name,capacity);
//                        break;
//                }
//            } else if (activeSession.getRole() == 0){
//                System.out.println("basic staff doesnt have permission to view this");
//            }
//
//        }
//
//        if(type == 2){
//            Scanner scanner = new Scanner(System.in);
//
//            UserOperations UO = new UserOperations();
//
//            System.out.print("\n-----USER OPERATIONS-----");
//            System.out.print("\n1) View airplanes");
//
//            System.out.print("\nPlease enter choice: ");
//            int input = scanner.nextInt();
//
//            switch(input) {
//
//                case 1:
//                    UO.viewPlanes();
//                    break;
//
}
//        }
//        return activeSession;
//    }
//}
