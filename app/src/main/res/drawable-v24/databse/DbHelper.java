package com.example.lab5b3activity.databse;

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
                "TenSv text,NgaySinh date, Hinh text,"+
                "MaLop text references LOP(MaLop))";
        db.execSQL(sql);

        sql="INSERT INTO SINHVIEN (TenSv,NgaySinh,Hinh,MaLop)"+
                "VALUES ('Au Binh','2001-1-20','hinh.jpg','LT15303')";
        db.execSQL(sql);

        sql="INSERT INTO SINHVIEN (TenSv,NgaySinh,Hinh,MaLop)"+
                "VALUES ('Cao Thang','2001-5-7','hinh.jpg','LT15303')";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          db.execSQL("Drop table if exists SINHVIEN");
        db.execSQL("Drop table if exists LOP");
        onCreate(db);
    }
}

