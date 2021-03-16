package com.example.mobilevision;

public class Object {
    String name;
    String picture;
    String price;
    String country;
    String company;
    String phone;
    String place;
    String code;
    String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object(String name, String picture, String price, String country, String company, String phone, String place, String code, String description) {
        this.name = name;
        this.picture = picture;
        this.price = price;
        this.country = country;
        this.company = company;
        this.phone = phone;
        this.place = place;
        this.code = code;
        this.description = description;
    }
}
