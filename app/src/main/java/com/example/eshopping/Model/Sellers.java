package com.example.eshopping.Model;

public class Sellers {


    private String email,password,address,phone,name;

    public Sellers(){

    }

    public Sellers(String email, String password, String address, String phone, String name) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }
}
