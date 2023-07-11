package com.company.FXML;

import com.company.Authenticate.Auth;
import com.company.Session.Session;
import com.company.Users.User;
import com.company.database.Db_Operations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {
    @FXML
    private Label wrongpassword;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private RadioButton user_radio;
    @FXML
    private RadioButton staff_radio;
    @FXML
    private Button dash_book_flight;
    @FXML
    private Button btnlogout;
    @FXML
    private Label welcomeLabel;

    @FXML
    private TextField SU_Full_Name;
    @FXML
    private TextField SU_Email;
    @FXML
    private TextField SU_Pass;
    @FXML
    private TextField SU_Age;
    @FXML
    private TextField SU_No;
    @FXML
    private TextField SU_Detail;
    @FXML
    private BorderPane mainPane;
    @FXML
    private Label invalid_data;

    @FXML
    private TextField UP_FL_ID;
    @FXML
    private TextField UP_FL_Dep_Date;
    @FXML
    private TextField UP_FL_Dep_Time;
    @FXML
    private TextField UP_FL_Dep;
    @FXML
    private TextField UP_FL_Arr;
    @FXML
    private TextField UP_FL_Arr_Time;
    @FXML
    private TextField UP_FL_price;
    @FXML
    private Label UP_Label;




    public void userLogin(ActionEvent event) throws Exception {
        try {
            checkLogin();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void checkLogin() throws Exception {
        com.company.Main m = new com.company.Main();
        Auth auth = new Auth(username.getText(),password.getText());

        if(staff_radio.isSelected() && user_radio.isSelected()){
            wrongpassword.setText("Please select one type");
            return;
        }

        if (username.getText().isEmpty()&&password.getText().isEmpty()){
            wrongpassword.setText("Please enter data");
            return;
        }

        if (staff_radio.isSelected()){
            //checks staff
            Session session=auth.getStaff(username.getText(),password.getText());
            if (session==null){
                wrongpassword.setText("Staff Not Found");
            }else {
                wrongpassword.setText("Success");
                m.changeScene("/com/company/FXML/Admin.fxml");
            }
        }
        else if (user_radio.isSelected()){
            //checks staff
            Session session=auth.getUser(username.getText(),password.getText());
            if (session==null){
                wrongpassword.setText("User Not Found");
            }else {
                wrongpassword.setText("Success");
                m.changeScene("/com/company/FXML/afterlogin.fxml");
            }
        } else {
            wrongpassword.setText("Wrong Username or Password");
        }
    }


//    public void checkLogin() throws Exception {
//        Session session = new Session();
//        Auth auth=new Auth("user","pass");
//        com.company.Main m = new com.company.Main();
//        redirectbeforelogin();
//        if (username.getText().toString().equals(session.getUsername()) && password.getText().toString().equals(session.getPassword())){
//            if (staff_radio.isSelected()){
//                //checks in staff
//                auth.getUser(username.getText(), password.getText(),1);
//                wrongpassword.setText("Success");
//                m.changeScene("/com/company/FXML/afterlogin.fxml");
//            }
//            else if (user_radio.isSelected()){
//                //checks in user
//                auth.getUser(auth.getName(), auth.getPassword(), 2);
//                wrongpassword.setText("Success");
//                m.changeScene("/com/company/FXML/afterlogin.fxml");
//            }


//        else if (username.getText().isEmpty()&&password.getText().isEmpty()){
//            wrongpassword.setText("Please enter data");
//        }
//        else {
//            wrongpassword.setText("Wrong Username or Password");
//        }

    @FXML
    private void BookFlight(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/company/FXML/booking.fxml"));
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setTitle("Book Flight");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 950, 700));
        primaryStage.show();
    }

    @FXML
    public void SignUp(ActionEvent actionEvent) throws IOException{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/company/FXML/SignUp.fxml"));
//        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setTitle("Sign-Up");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 950, 745));
        primaryStage.show();

    }

    @FXML
    public void SignUpInfo(ActionEvent actionEvent) throws IOException, SQLException {
        com.company.Main m = new com.company.Main();
        User user = new User();

        if(SU_Full_Name.getText() == null || SU_Pass.getText() == null || SU_Age.getText() == null || SU_Email.getText() == null ||  SU_No.getText() == null){
            invalid_data.setText("Please fill all data");
            return;
        }

        if(SU_Full_Name.getText().length() >= 3 && SU_Pass.getText().length() >= 3 && Integer.parseInt(SU_Age.getText()) >= 18 &&
                SU_Email.getText().contains("@gmail.com") || SU_Email.getText().contains("@yahoo.com") || SU_Email.getText().contains("@hotmail.com")
                && SU_No.getText().length() == 6) {

            if(user.checkEmail(SU_Email.getText())){
                invalid_data.setText("Email already exist");
            } else {
                new User(SU_Full_Name.getText(),SU_Pass.getText(),Integer.parseInt(SU_Age.getText()),SU_Email.getText(),
                        Integer.parseInt(SU_No.getText()),SU_Detail.getText());
                invalid_data.setText("User successfully registered");


            }
            resetCredentials();
        } else {
            resetCredentials();
            invalid_data.setText("Invalid Credentials");
        }

    }

    @FXML
    private void AdminFlightButton() {
        SidebarLoader object = new SidebarLoader();
        Pane view = object.getPage("/com/company/FXML/AdminFlight1");
        mainPane.setCenter(view);
    }

    @FXML
    private void AddFlight(ActionEvent actionEvent) throws IOException{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/company/FXML/AddFlight1.fxml"));
//        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setTitle("View Teacher");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    private void UpdateFlightButton(ActionEvent actionEvent) throws IOException{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/company/FXML/UpdateFlight.fxml"));
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setTitle("Update Flight");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    @FXML
    private void ViewFlightAdmin(ActionEvent actionEvent) throws IOException{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/company/FXML/ViewFlightAdmin.fxml"));
//        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setTitle("View Teacher");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public void userLogOut() throws IOException {
//        com.company.Main m = new com.company.Main();
//        m.changeScene("/com/company/FXML/Login.fxml");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setContentText("Are you sure want to logout?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            btnlogout.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/com/company/FXML/Login.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("").toExternalForm());
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }

    @FXML
    public void UpdateFlight(ActionEvent actionEvent) throws IOException{
        System.out.println(UP_FL_ID.getText());
        System.out.println(UP_FL_Dep_Date.getText());
        System.out.println(UP_FL_Dep_Time.getText());
        System.out.println(UP_FL_Dep.getText());
        System.out.println(UP_FL_Arr.getText());
        System.out.println(UP_FL_Arr_Time.getText());
        System.out.println(UP_FL_price.getText());
        UP_Label.setText("Information Updated Successfully");
    }

    public void resetCredentials(){
        SU_Full_Name.setText(null);
        SU_Pass.setText(null);
        SU_Age.setText(null);
        SU_Email.setText(null);
        SU_No.setText(null);
        SU_Detail.setText(null);
    }

}
