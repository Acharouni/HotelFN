package com.example.hotel;

public class nameRooM {
   private static String nameRoom;

    public nameRooM(String nameRoom){
        this.nameRoom=nameRoom;
    }

    public static String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }
}
