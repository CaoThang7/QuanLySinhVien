package com.example.lt15303_ps12545_lycaothang_assignmentgd1.model;

import java.io.Serializable;
import java.util.Date;

public class SinhVien implements Serializable {
    private String tenSv;
    private Date ngaySinh;
    private int maSv;
    private String maLopHoc;
    private  String hinh;

    public SinhVien() {
    }

    public SinhVien(String tenSv, Date ngaySinh, int maSv, String maLopHoc, String hinh) {
        this.tenSv = tenSv;
        this.ngaySinh = ngaySinh;
        this.maSv = maSv;
        this.maLopHoc = maLopHoc;
        this.hinh = hinh;
    }

    public SinhVien(String tenSv, Date ngaySinh, String maLopHoc, String hinh) {
        this.tenSv = tenSv;
        this.ngaySinh = ngaySinh;
        this.maLopHoc = maLopHoc;
        this.hinh = hinh;
    }

    public String getTenSv() {
        return tenSv;
    }

    public void setTenSv(String tenSv) {
        this.tenSv = tenSv;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getMaSv() {
        return maSv;
    }

    public void setMaSv(int maSv) {
        this.maSv = maSv;
    }

    public String getMaLopHoc() {
        return maLopHoc;
    }

    public void setMaLopHoc(String maLopHoc) {
        this.maLopHoc = maLopHoc;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
}