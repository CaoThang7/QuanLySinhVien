package com.example.lt15303_ps12545_lycaothang_assignmentgd1.databse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context){

        super(context,"LT15303",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE LOP(MaLop text primary key, TenLop text)";
        db.execSQL(sql);
        sql="INSERT INTO LOP VALUES('LT15303','Lớp mobile 15.3')";
        db.execSQL(sql);
        sql="INSERT INTO LOP VALUES('LT15304 ','Lớp mobile 15.4')";
        db.execSQL(sql);
        sql="INSERT INTO LOP VALUES('LT15305','Lớp mobile 15.5')";
        db.execSQL(sql);
        sql="INSERT INTO LOP VALUES('LT15306','Lớp mobile 15.6')";
        db.execSQL(sql);


        sql="CREATE TABLE SINHVIEN(MaSv integer primary key autoincrement,"+
                "TenSv text,NgaySinh date,Hinh text,"+
                "MaLop text references LOP(MaLop))";
        db.execSQL(sql);

        sql="INSERT INTO SINHVIEN (TenSv,NgaySinh,Hinh,MaLop)"+
                "VALUES ('Au Binh','2001-1-20','hinh.jpg','LT15303')";
        db.execSQL(sql);

        sql="INSERT INTO SINHVIEN (TenSv,NgaySinh,Hinh,MaLop)"+
                "VALUES ('Cao Thang','2001-5-7','hinh.jpg','LT15303')";
        db.execSQL(sql);


        sql="CREATE TABLE QUANTRI(username text primary key, password text)";
        db.execSQL(sql);
        sql="INSERT INTO QUANTRI VALUES('admin','admin')";
        db.execSQL(sql);
        sql="INSERT INTO QUANTRI VALUES('admin2','123')";
        db.execSQL(sql);


        sql="CREATE TABLE SANPHAM(ID integer primary key autoincrement,"+
                "Name text,Image text,Price double)";
        db.execSQL(sql);

        sql="INSERT INTO SANPHAM (ID,Name,Image,Price)"+
                "VALUES ('1','TTT','hinh.jpg','50')";
        db.execSQL(sql);

        sql="INSERT INTO SANPHAM (ID,Name,Image,Price)"+
                "VALUES ('2','TTT','hinh.jpg','70.5')";
        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          db.execSQL("Drop table if exists SINHVIEN");
        db.execSQL("Drop table if exists LOP");
        db.execSQL("Drop table if exists SANPHAM");
        onCreate(db);
    }
}

