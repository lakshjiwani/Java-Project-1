package com.company.FXML;

import com.company.database.Db_Operations;
import com.company.planes.Plane;
import com.mysql.cj.conf.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddFlight implements Initializable
{
    @FXML
    private TextField ADD_FL_type;
    @FXML
    private TextField ADD_FL_dep_time;
    @FXML
    private TextField ADD_FL_Dep;
    @FXML
    private TextField ADD_FL_price;
    @FXML
    private TextField ADD_FL_arr_time;
    @FXML
    private TextField ADD_FL_arr;
    @FXML
    private TextField ADD_FL_dep_date;
    @FXML
    private ComboBox<String> combo_plane_name;





    @FXML
    public void AddFlightButton(ActionEvent actionEvent) throws IOException {
        System.out.println(combo_plane_name.getValue());
        System.out.println(ADD_FL_dep_time.getText());
        System.out.println(ADD_FL_Dep.getText());
        System.out.println(ADD_FL_price.getText());
        System.out.println(ADD_FL_arr_time.getText());
        System.out.println(ADD_FL_arr.getText());
        System.out.println(ADD_FL_dep_date.getText());
    }


    ObservableList<Plane> list = FXCollections.observableArrayList();

    public void ComboFill() throws SQLException {
        String query = "select plane_name from airplanes;";
        ResultSet rs = Db_Operations.read(query);

        ObservableList des = FXCollections.observableArrayList();
        while (rs.next()) {
            des.add(new String(rs.getString("plane_name")));
        }
        combo_plane_name.setItems(des);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        try {
            ComboFill();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
