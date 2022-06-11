package com.example.muvkintours.models;

public class User {

    private String username;
    private String phone;
    private String ticket;
    private String seat;
    private String coach;

    public User(String username, String phone, String ticket, String seat, String coach) {
        this.username = username;
        this.phone = phone;
        this.ticket = ticket;
        this.seat = seat;
        this.coach = coach;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }
}
