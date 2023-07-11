package com.company.FXML;

import com.company.Operations.UserOperations;
import com.company.Session.Session;
import com.company.Users.User;
import com.company.database.Db_Operations;
import com.company.planes.Plane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TableControler implements Initializable{
    @FXML
    private TableView<ModelTable> flight_table;
    @FXML
    private TableColumn<ModelTable, Integer> FT_ID_col;
    @FXML
    private TableColumn<ModelTable,Integer> FT_flight_type;
    @FXML
    private TableColumn<ModelTable, String> FT_depDate_col;
    @FXML
    private TableColumn<ModelTable, String> FT_DepTime_col;
    @FXML
    private TableColumn<ModelTable, String> FT_DepAir_col;
    @FXML
    private TableColumn<ModelTable, String> FT_ArivAir_col;
    @FXML
    private TableColumn<ModelTable, String> FT_ArivTime_col;
    @FXML
    private TableColumn<ModelTable, Integer> FT_Price;
    @FXML
    private TableColumn<ModelTable, String> FT_PlaneName;
    @FXML
    private TableColumn<ModelTable, Integer> FT_AvalSeats;

    @FXML
    private TextField BK_flight_id;
    @FXML
    private TextField BK_quantity;

    @FXML
    private Label book_label;

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
    private ComboBox<String> combo_plane_name;

    @FXML
    private TextField FL_delete_ID;
    @FXML
    private Label deleteLabel;
//    private static LinkedList<ModelTable> flightList = new LinkedList<ModelTable>();
    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {

//        try {
//            String query = "select * from airplanes";
//            ResultSet read = Db_Operations.read(query);
//            while (read.next()){
//                oblist.add(new ModelTable(read.getString("flight_Id"),read.getString("departure_date"),
//                        read.getString("departure_time"),read.getString("departure"),
//                        read.getString("arrival"),read.getString("arrival_time")));
//
//            }
//        }catch (SQLException ex){
//
//        }
//        FT_ID_col.setCellValueFactory(new PropertyValueFactory("id"));
//        FT_depDate_col.setCellValueFactory(new PropertyValueFactory<>("departure_date"));
//        FT_DepTime_col.setCellValueFactory(new PropertyValueFactory<>("departure_time"));
//        FT_DepAir_col.setCellValueFactory(new PropertyValueFactory<>("departure"));
//        FT_ArivAir_col.setCellValueFactory(new PropertyValueFactory<>("arrival"));
//        FT_ArivTime_col.setCellValueFactory(new PropertyValueFactory<>("arrival_time"));
//        flight_table.setItems(oblist);

//        String query = "select * from airplanes";
//        ResultSet read = Db_Operations.read(query);
//
//        while (read.next()) {
//            Plane plane = new Plane();
//            plane.setName(read.getString("plane_name"));
//            plane.setSeating_capacity(read.getInt("plane_seating_capacity"));
//            plane.setAvailable_seats(read.getInt("plane_available_seats"));
//            planes.add(plane);
//        }



        try {
            String query = "SELECT flight_type,departure_date,departure_time,departure,arrival,arrival_time,price, " +
                    "plane_name,plane_available_Seats \n" +
                    "FROM flights F left JOIN airplanes A ON F.flight_type = A.plane_id order by flight_type;";

            ResultSet rs = Db_Operations.read(query);
            while (rs.next()) {
                ModelTable flight = new ModelTable();
                flight.setId(rs.getInt("flight_type"));
                flight.setDeparture_date(rs.getString("departure_date"));
                flight.setDeparture_time(rs.getString("departure_time"));
                flight.setDeparture_airport(rs.getString("departure"));
                flight.setArrival_airport(rs.getString("arrival"));
                flight.setArrival_time(rs.getString("arrival_time"));
                flight.setPrice(rs.getInt("price"));
                flight.setPlaneName(rs.getString("plane_name"));
                flight.setAvailableSeats(rs.getInt("plane_available_Seats"));
                oblist.add(flight);
            }

                FT_ID_col.setCellValueFactory(new PropertyValueFactory<ModelTable,Integer>("id"));
                FT_depDate_col.setCellValueFactory(new PropertyValueFactory<>("departure_date"));
                FT_DepTime_col.setCellValueFactory(new PropertyValueFactory<>("departure_time"));
                FT_DepAir_col.setCellValueFactory(new PropertyValueFactory<ModelTable,String>("departure_airport"));
                FT_ArivAir_col.setCellValueFactory(new PropertyValueFactory<ModelTable,String>("arrival_airport"));
                FT_ArivTime_col.setCellValueFactory(new PropertyValueFactory<>("arrival_time"));
                FT_Price.setCellValueFactory(new PropertyValueFactory<ModelTable,Integer>("price"));
                FT_PlaneName.setCellValueFactory(new PropertyValueFactory<>("planeName"));
                FT_AvalSeats.setCellValueFactory(new PropertyValueFactory<ModelTable,Integer>("availableSeats"));
                //button creating
                flight_table.setItems(oblist);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    @FXML
    private void BookNow(ActionEvent event) throws IOException, SQLException {

        int available_seats = -1;
        int seating_capacity = -1;
        int plane_id = -1;
        int flight_id = -1;
        int price = 0;
        UserOperations uo = new UserOperations();

        if (BK_flight_id.getText().length() == 0 || BK_quantity.getText().length() == 0) {
            book_label.setText("Flight Booking failed");
            return;
        }

        String query = "SELECT flight_id,price,flight_type,plane_seating_capacity,plane_available_Seats " +
                "FROM " +
                "flights " +
                "F left JOIN airplanes A" +
                " " +
                "ON F.flight_type = A.plane_id where flight_type = " + BK_flight_id.getText() + ";";
        ResultSet read = Db_Operations.read(query);

        while (read.next()) {
            available_seats = read.getInt("plane_available_Seats");
            price = read.getInt("price");
            plane_id = read.getInt("flight_type");
            flight_id = read.getInt("flight_id");
            break;
        }

        if (Integer.parseInt(BK_quantity.getText()) <= available_seats && Integer.parseInt(BK_quantity.getText()) > 0) {
            uo.bookFlight(Session.getSessionId(), flight_id, Integer.parseInt(BK_quantity.getText()), price,
                    available_seats, plane_id);
            book_label.setText("Flight Booked Successfully" + Session.getSessionId());
        } else {
            book_label.setText("Flight Booking failed" + Session.getSessionId());
        }

    }
        @FXML
    private void deleteflight(ActionEvent actionEvent) throws IOException{
        System.out.println(FL_delete_ID.getText());
        deleteLabel.setText("Successfully Deleted");

    }
//    User user = new User(book_label.getText(),);
}
