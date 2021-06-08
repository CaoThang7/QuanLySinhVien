package com.example.lab5b3activity.model;

import java.io.Serializable;

public class LopHoc implements Serializable {
    private String maLop;
    private String tenLop;

    public LopHoc() {
    }

    public LopHoc(String tenLop) {
        this.tenLop=tenLop;
    }



    public LopHoc(String maLop, String tenLop) {
        this.maLop = maLop;
        this.tenLop = tenLop;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }




}
