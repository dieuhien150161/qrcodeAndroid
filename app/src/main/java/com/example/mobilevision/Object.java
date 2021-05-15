package com.example.mobilevision;

public class Object {
    String Name;
    String Country;
    String Price;
    String Picture;
    String Name_company;
    String Phone;
    String Place;
    String Code;
    String Description;
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public String getName_company() {
        return Name_company;
    }

    public void setName_company(String name_company) {
        Name_company = name_company;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Object(String name, String country, String price, String picture, String name_company, String phone, String place, String code, String description) {
        Name = name;
        Country = country;
        Price = price;
        Picture = picture;
        Name_company = name_company;
        Phone = phone;
        Place = place;
        Code = code;
        Description = description;
    }

    public Object(String name, String price, String picture, String description) {
        Name = name;
        Price = price;
        Picture = picture;
        Description = description;
    }
}

