package com.example.hotel;

public class meDfData {
    String mail, phone, password;

    public meDfData(String mail, String phone, String password) {
        this.mail = mail;
        this.phone = phone;
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
