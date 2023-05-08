package com.example.hotel;

public class EnregResV {
    private String name, subname, room, adult, child, Date_E, Date_D;

    public EnregResV(String name, String subname, String room, String adult, String child, String date_E, String date_D) {
        this.name = name;
        this.subname = subname;
        this.room = room;
        this.adult = adult;
        this.child = child;
        this.Date_E = date_E;
        this.Date_D = date_D;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public String getDate_E() {
        return Date_E;
    }

    public void setDate_E(String date_E) {
        Date_E = date_E;
    }

    public String getDate_D() {
        return Date_D;
    }

    public void setDate_D(String date_D) {
        Date_D = date_D;
    }
}
