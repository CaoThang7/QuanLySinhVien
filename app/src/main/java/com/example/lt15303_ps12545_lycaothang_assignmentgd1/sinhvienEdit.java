package com.example.lt15303_ps12545_lycaothang_assignmentgd1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lt15303_ps12545_lycaothang_assignmentgd1.adapter.SinhVienAdapter;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.dao.LopDAO;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.dao.SinhVienDAO;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.model.LopHoc;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.model.SinhVien;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class sinhvienEdit extends AppCompatActivity {

    ArrayList<SinhVien> data=new ArrayList<>();
    SinhVienAdapter adapter;
    SinhVienDAO dao;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinhvien_edit);


        dao = new SinhVienDAO(sinhvienEdit.this);
        // Get data
        data = dao.readAll();
        adapter = new SinhVienAdapter(sinhvienEdit.this, data);




        showDialogUpdate();

    }


    private void showDialogUpdate(){
        AlertDialog.Builder builder = new AlertDialog.Builder(sinhvienEdit.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_sinhvien_insert, null);
        builder.setView(view);
        final EditText etTen = view.findViewById(R.id.txtTenSv);
        final EditText etNs = view.findViewById(R.id.txtNgaySinh);
        final EditText etHinh = view.findViewById(R.id.txtAvatar);
        final Spinner spnLop = view.findViewById(R.id.spnLopHoc);
        Button btThem = view.findViewById(R.id.btnThemSv);
        Button btnNhapLai = view.findViewById(R.id.btnNhapLaiSv);

        LopDAO daoLH = new LopDAO(sinhvienEdit.this);
        ArrayList<LopHoc> dsLop = new ArrayList<>();
        dsLop = daoLH.readAll();
        ArrayAdapter adapterLop = new ArrayAdapter(sinhvienEdit.this,
                android.R.layout.simple_spinner_item, dsLop);
        spnLop.setAdapter(adapterLop);
        final AlertDialog dialog = builder.create();
        btThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = etTen.getText().toString();
                String ns = etNs.getText().toString();
                String hinh = etHinh.getText().toString();
                LopHoc lop = (LopHoc) spnLop.getSelectedItem();
                String maLop = lop.getMaLop();
                try {
                    SinhVien sv = new SinhVien(ten, sdf.parse(ns), hinh, maLop);
                    if(dao.create(sv)){
                        Toast.makeText(sinhvienEdit.this,
                                "Thêm thành công!!!!!!", Toast.LENGTH_LONG).show();
                        data.clear();
                        data.addAll(dao.readAll());
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }else{
                        Toast.makeText(sinhvienEdit.this,
                                "Thất bại!!!!!!", Toast.LENGTH_LONG).show();
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });


        btnNhapLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ten = etTen.getText().toString();
                String ns = etNs.getText().toString();
                String hinh = etHinh.getText().toString();
                LopHoc lop = (LopHoc) spnLop.getSelectedItem();
                String maLop = lop.getMaLop();


                if(dao.update(ten,ns,maLop,hinh)){
                    Toast.makeText(sinhvienEdit.this,"Sửa thành công!!!",
                            Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(sinhvienEdit.this,"Sửa thất bại!!!",
                            Toast.LENGTH_LONG).show();
                }




            }

        });
        dialog.show();

    }




    @Override
    protected void onResume() {
        super.onResume();
        data.clear();
        data.addAll(dao.readAll());
        adapter.notifyDataSetChanged();
    }




}
