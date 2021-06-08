package com.example.lt15303_ps12545_lycaothang_assignmentgd1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lt15303_ps12545_lycaothang_assignmentgd1.adapter.SinhVienAdapter;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.dao.LopDAO;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.dao.SinhVienDAO;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.model.LopHoc;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.model.SinhVien;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SinhVienActivity extends AppCompatActivity {
    ListView lv;


    FloatingActionButton btnInsert;
    ArrayList<SinhVien> data=new ArrayList<>();
    SinhVienAdapter adapter;
    SinhVienDAO dao;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinh_vien);
        lv = findViewById(R.id.lvSinhVien);

        btnInsert = findViewById(R.id.fbInsertLop);


        dao = new SinhVienDAO(SinhVienActivity.this);
        // Get data
        data = dao.readAll();
        adapter = new SinhVienAdapter(SinhVienActivity.this, data);
        lv.setAdapter(adapter);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialogInsert();
            }
        });





    }
        private void showDialogInsert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(SinhVienActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_sinhvien_insert, null);
        builder.setView(view);
        final EditText etTen = view.findViewById(R.id.txtTenSv);
        final EditText etNs = view.findViewById(R.id.txtNgaySinh);
        final EditText etHinh = view.findViewById(R.id.txtAvatar);
        final Spinner spnLop = view.findViewById(R.id.spnLopHoc);
        Button btThem = view.findViewById(R.id.btnThemSv);
        Button btnNhapLai = view.findViewById(R.id.btnNhapLaiSv);

        LopDAO daoLH = new LopDAO(SinhVienActivity.this);
        ArrayList<LopHoc> dsLop = new ArrayList<>();
        dsLop = daoLH.readAll();
        ArrayAdapter adapterLop = new ArrayAdapter(SinhVienActivity.this,
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
                        Toast.makeText(SinhVienActivity.this,
                                "Thêm thành công!!!!!!", Toast.LENGTH_LONG).show();
                        data.clear();
                        data.addAll(dao.readAll());
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }else{
                        Toast.makeText(SinhVienActivity.this,
                                "Thất bại!!!!!!", Toast.LENGTH_LONG).show();
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
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
