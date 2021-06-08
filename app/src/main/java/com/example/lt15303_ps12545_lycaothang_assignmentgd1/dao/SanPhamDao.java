package com.example.lt15303_ps12545_lycaothang_assignmentgd1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lt15303_ps12545_lycaothang_assignmentgd1.databse.DbHelper;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.model.SanPham;

import java.util.ArrayList;

//import com.example.lt15303_ps12545_lycaothang_assignmentgd1.model.LopHoc;

public class SanPhamDao {
    DbHelper helper;

    public SanPhamDao(Context context) {
        helper =new DbHelper(context);
    }

    public ArrayList<SanPham> readAll(){

        ArrayList<SanPham> data=new ArrayList<>();


        //Tao databse
        SQLiteDatabase db=helper.getReadableDatabase();
        // Tao con tro = pointer( cursor) de lay du lieu
        Cursor cs=db.rawQuery("select * from SANPHAM",null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){

            int ID=cs.getInt(0);
            String Name=cs.getString(1);
            String Image=cs.getString(2);
            Double Price=cs.getDouble(3);

            data.add(new SanPham(ID,Name,Image,Price));
            cs.moveToNext();

        }
        cs.close();
        return data;
    }

    public boolean create(SanPham sp){
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("ID",sp.getID());
        values.put("Name",sp.getName());
        values.put("Image",sp.getImage());
        values.put("Price",sp.getPrice());


        long row=db.insert("SANPHAM",null,values);
        return (row >0);

    }


    public boolean update(Integer ID,String Name,String hinh,Double Price){
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
//        values.put("ID",ID);
        values.put("Name",Name);
        values.put("Image",hinh);
        values.put("Price",Price);
        int result=db.update("SANPHAM",values,"ID=?",new String[]{String.valueOf(ID)});
//        if(result >0){
//            return true;
//        }else {
//            return false;
//        }
        return  result>0;
    }


    //delete
    public boolean delete(Integer ID){
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("Id",ID);
        int row=db.delete("SANPHAM","Id=?",new String[]{String.valueOf(ID)});
        return row > 0;
    }

}
