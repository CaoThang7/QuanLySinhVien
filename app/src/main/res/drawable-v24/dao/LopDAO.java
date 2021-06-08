package com.example.lab5b3activity.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lab5b3activity.databse.DbHelper;
import com.example.lab5b3activity.model.LopHoc;

import java.util.ArrayList;


public class LopDAO {
    DbHelper helper;

    public LopDAO(Context context) {
        helper =new DbHelper(context);
    }

    public ArrayList<LopHoc> readAll(){

      ArrayList<LopHoc> data=new ArrayList<>();

      //Tao databse
        SQLiteDatabase db=helper.getReadableDatabase();
      // Tao con tro = pointer( cursor) de lay du lieu
        Cursor cs=db.rawQuery("select *from LOP",null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            String malop=cs.getString(0);
            String tenlop=cs.getString(1);
            data.add(new LopHoc(malop,tenlop));
            cs.moveToNext();

        }
        cs.close();
      return data;
    }
    /**
     * Insert du lieu
     * */

    public boolean create(LopHoc lop){
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("MaLop",lop.getMaLop());
        values.put("TenLop",lop.getTenLop());
        long row=db.insert("LOP",null,values);
//        if(row >0){
//            return true;
//        }else {
//            return false;
//        }
        return (row >0);

    }


    //update
    public boolean update(String ma,String tenLop){
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put("TenLop",tenLop);
        int result=db.update("LOP",values,"MaLop=?",new String[]{ma});
//        if(result >0){
//            return true;
//        }else {
//            return false;
//        }
        return  result>0;
    }


    //delete
    public boolean delete(String ma){
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put("MaLop",ma);
        int result=db.delete("LOP","maLop=?",new String[]{ma});
//        if(result >0){
//            return true;
//        }else {
//            return false;
//        }
        return  result>0;
    }


//    // delete
//    public boolean delete(String tenLop){
//        SQLiteDatabase db=helper.getWritableDatabase();
//        ContentValues values=new ContentValues();
//        values.put("TenLop",tenLop);
//        int row=db.delete("LOP","tenLop=?",new String[]{tenLop});
//        if(row >0){
//            return true;
//        }else {
//            return false;
//        }
//    }


//    public int deletee(String tenLop){
//        SQLiteDatabase db=helper.getWritableDatabase();
//        return db.delete("LOP","tenLop=?",new String[]{tenLop});
//    }


}
