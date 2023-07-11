package com.company;

import com.company.Authenticate.*;
import com.company.FXML.Controller;
import com.company.FXML.TableControler;
import com.company.Users.*;
import com.mysql.cj.xdevapi.Table;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class Main extends Application {
    private static Stage stg;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stg = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("/com/company/FXML/Login.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("/com/company/FXML/AdminFlight1.fxml"));
        primaryStage.setTitle("Login Form");
        primaryStage.setScene(new Scene(root,950,700));
        primaryStage.show();
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch(args);

//        try {
//
//            System.out.print("\n1) Register");
//            System.out.print("\n2) Login");
//            System.out.print("\nPlease enter choice: ");
//            Scanner scanner = new Scanner(System.in);
//            int input = scanner.nextInt();
//
//            switch (input) {
//                case 1:
//                    System.out.print("\nRegister as new user");
//
//                    System.out.print("\n1) Register as USER");
//                    System.out.print("\n2) Register as Staff");
//
//                    System.out.print("\nPlease enter choice: ");
//                    int input2 = scanner.nextInt();
//
//                    switch (input2) {
//                        case 1:
//                            System.out.print("\n\nEnter name: ");
//                            scanner.nextLine();
//                            String name = scanner.nextLine();
//                            System.out.print("Enter password: ");
//                            String password = scanner.nextLine();
//                            new User(name, password);
//                            System.out.print("Successfully Registered");
//                            break;
//
//                        case 2:
//                            System.out.print("\n\nEnter name: ");
//                            scanner.nextLine();
//                            String name1 = scanner.nextLine();
//                            System.out.print("Enter password: ");
//                            String password1 = scanner.nextLine();
//                            System.out.print("Enter salary: ");
//                            int salary = scanner.nextInt();
//                            System.out.print("Enter designation (1-4): ");
//                            int designation = scanner.nextInt();
//                            new Staff(name1, password1, salary,designation);
//                            System.out.print("Successfully Registered");
//                            break;
//
//                        default:
//                            System.out.print("\nIncorrect input");
//                    }
//                    break;
//
//                case 2:
//                    System.out.print("\nLogin as existing user");
//
//                    System.out.print("\n\nEnter name: ");
//                    scanner.nextLine();
//                    String name = scanner.nextLine();
//                    System.out.print("Enter password: ");
//                    String password = scanner.nextLine();
//                    System.out.print("Type \n1 for Staff \n2 for User\nEnter: ");
//                    int type = scanner.nextInt();
//                    new Auth(name, password, type);
//                    break;
//
//                default:
//                    System.out.print("\nIncorrect input");
//            }
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
    }
}
