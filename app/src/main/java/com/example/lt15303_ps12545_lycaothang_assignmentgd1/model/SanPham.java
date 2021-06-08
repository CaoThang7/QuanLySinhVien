package com.example.lt15303_ps12545_lycaothang_assignmentgd1.model;

import java.io.Serializable;

public class SanPham implements Serializable {
    private int ID;
    private String Name;
    private String Image;
    private Double Price;

    public SanPham() {
    }

    public SanPham(int ID, String name, String image, Double price) {
        this.ID = ID;
        Name = name;
        Image = image;
        Price = price;
    }

    public SanPham(String name, String image, Double price) {
        Name = name;
        Image = image;
        Price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }
}
