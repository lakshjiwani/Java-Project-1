package com.company.Users;

import com.company.FXML.*;
import com.company.database.*;
import com.mysql.cj.protocol.*;

import java.sql.*;

public class User extends Person{

    public User(){}

    public User(String name, String password, int age, String email, int phoneNumber, String details) {
        super(name, password, age, email, phoneNumber, details);
        insert(name, password, age, email, phoneNumber, details);
    }

    public void insert(String name, String password, int age, String email, int phoneNumber, String details) {

        if(details == null || details.length() == 0){
            Db_Operations.insert("INSERT INTO users (full_name , password, age, email, number) VALUES " +
                    "(" + "'" + name + "'," + "'" + password + "'," + "'" + age + "'," + "'" + email + "'," + "'" + phoneNumber + "')");
        } else {
            Db_Operations.insert("INSERT INTO users (full_name , password, age, email, number, details) VALUES " +
                    "(" + "'" + name + "'," + "'" + password + "'," + "'" + age + "'," + "'" + email + "'," + "'" + phoneNumber + "'," + "'" + details + "'"+ ")");
        }
    }

    public boolean checkEmail(String email) throws SQLException {

        String check_email = null;
        ResultSet read = Db_Operations.read("select * from users where email like '" +email+"' ;");

        while (read.next()) {
            check_email = read.getString("email");
        }

        if(check_email == null) {
            return false;   // email doesn't exist
        }
        return true;        // email exist
    }

}
