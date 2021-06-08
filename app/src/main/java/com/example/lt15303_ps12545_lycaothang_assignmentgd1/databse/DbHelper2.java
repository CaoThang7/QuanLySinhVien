package com.example.lt15303_ps12545_lycaothang_assignmentgd1.databse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper2 extends SQLiteOpenHelper {
    public DbHelper2(Context context){
        // tao CSDL
        super(context,"LT15303Demo",null,1);
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


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
