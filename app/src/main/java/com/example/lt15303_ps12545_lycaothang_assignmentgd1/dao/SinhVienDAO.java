package com.example.lt15303_ps12545_lycaothang_assignmentgd1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lt15303_ps12545_lycaothang_assignmentgd1.databse.DbHelper;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.model.SinhVien;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SinhVienDAO {
    DbHelper helper;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    public SinhVienDAO(Context context) {
        helper =new DbHelper(context);
    }
    public ArrayList<SinhVien> readAll(){

        ArrayList<SinhVien> data=new ArrayList<>();


        //Tao databse
        SQLiteDatabase db=helper.getReadableDatabase();
        // Tao con tro = pointer( cursor) de lay du lieu
        Cursor cs=db.rawQuery("select *from SINHVIEN",null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){

            int masv=cs.getInt(0);
            String tensv=cs.getString(1);
            String ngaysinh=cs.getString(2);
            String hinh=cs.getString(3);
            String lop=cs.getString(4);
            try {
                data.add(new SinhVien( tensv, sdf.parse(ngaysinh),masv, hinh, lop));
            }catch (Exception ex){
                ex.printStackTrace();
            }
            cs.moveToNext();

        }
        cs.close();
        return data;
    }

    public boolean create(SinhVien sv){
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("TenSv",sv.getTenSv());
        values.put("NgaySinh",sdf.format(sv.getNgaySinh()));
        values.put("Hinh",sv.getHinh());
        values.put("MaLop",sv.getMaLopHoc());
        long row=db.insert("SINHVIEN",null,values);

        return (row >0);

    }

    public boolean update(String tensv,String ngaysinh,String hinh,String maLop){
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("TenSv",tensv);
        values.put("NgaySinh",ngaysinh);
        values.put("Hinh",hinh);
        values.put("MaLop",maLop);
        int result=db.update("SINHVIEN",values,"TenSv=?",new String[]{tensv});
//        if(result >0){
//            return true;
//        }else {
//            return false;
//        }
        return  result>0;
    }

    //delete
    public boolean delete(String tensv){
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("TenSv",tensv);
        int row=db.delete("SINHVIEN","TenSv=?",new String[]{tensv});
        return row > 0;
    }


}
