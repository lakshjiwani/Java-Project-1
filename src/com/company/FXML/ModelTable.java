package com.company.FXML;

public class ModelTable {
//    String id,departure_date,departure_time,departure_airport,arrival_airport,arrival_time;
//
//    public ModelTable(String id, String departure_date, String departure_time,
//                      String departure_airport, String arrival_airport, String arrival_time) {
//        this.id = id;
//        this.departure_date = departure_date;
//        this.departure_time = departure_time;
//        this.departure_airport = departure_airport;
//        this.arrival_airport = arrival_airport;
//        this.arrival_time = arrival_time;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getDeparture_date() {
//        return departure_date;
//    }
//
//    public void setDeparture_date(String departure_date) {
//        this.departure_date = departure_date;
//    }
//
//    public String getDeparture_time() {
//        return departure_time;
//    }
//
//    public void setDeparture_time(String departure_time) {
//        this.departure_time = departure_time;
//    }
//
//    public String getDeparture_airport() {
//        return departure_airport;
//    }
//
//    public void setDeparture_airport(String departure_airport) {
//        this.departure_airport = departure_airport;
//    }
//
//    public String getArrival_airport() {
//        return arrival_airport;
//    }
//
//    public void setArrival_airport(String arrival_airport) {
//        this.arrival_airport = arrival_airport;
//    }
//
//    public String getArrival_time() {
//        return arrival_time;
//    }
//
//    public void setArrival_time(String arrival_time) {
//        this.arrival_time = arrival_time;
//    }
    int id,flightType,price,availableSeats;
    String departure_date,departure_time,departure_airport,arrival_airport,arrival_time,planeName;

    public ModelTable(int id,int flightType,int price,int availableSeats,String planeName, String departure_date,
                      String departure_time,
                      String departure_airport, String arrival_airport, String arrival_time) {
        this.planeName = planeName;
        this.price = price;
        this.availableSeats = availableSeats;
        this.flightType = flightType;
        this.departure_date = departure_date;
        this.departure_time = departure_time;
        this.departure_airport = departure_airport;
        this.arrival_airport = arrival_airport;
        this.arrival_time = arrival_time;
        this.id = id;
    }

    public ModelTable (){

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    public int getFlightType() {
        return flightType;
    }

    public void setFlightType(int flightType) {
        this.flightType = flightType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getDeparture_airport() {
        return departure_airport;
    }

    public void setDeparture_airport(String departure_airport) {
        this.departure_airport = departure_airport;
    }

    public String getArrival_airport() {
        return arrival_airport;
    }

    public void setArrival_airport(String arrival_airport) {
        this.arrival_airport = arrival_airport;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    @Override
    public String toString() {
        return "\n ModelTable{" +
                "id=" + getId() +
                "FlightType=" + getFlightType() +
                ", departure_date='" + getDeparture_date() + '\'' +
                ", departure_time='" + getDeparture_time() + '\'' +
                ", departure_airport='" + getDeparture_airport() + '\'' +
                ", arrival_airport='" + getArrival_airport() + '\'' +
                ", arrival_time='" + getArrival_time() + '\'' +
                '}';
    }
}
