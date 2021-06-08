package com.example.lt15303_ps12545_lycaothang_assignmentgd1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lt15303_ps12545_lycaothang_assignmentgd1.adapter.LopHocAdapter;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.dao.LopDAO;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.model.LopHoc;

import java.util.ArrayList;

public class QLthemsuasvActivity extends AppCompatActivity {
    LinearLayout manhinhh;

    EditText etMaa,etTenn;
    Button btInsertt;



    ListView lv;
    ArrayList<LopHoc> data = new ArrayList<>();
    LopHocAdapter adapter;
    LopDAO dao;

    //    ListView lv;
//    ArrayList<SinhVien> data=new ArrayList<>();
//    SinhVienAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_lthemsuasv);
        manhinhh = (LinearLayout) findViewById(R.id.AnhManHinh2);
        manhinhh.setBackgroundResource(R.drawable.anh6);


        etMaa=findViewById(R.id.txtMaLop);
        etTenn=findViewById(R.id.txtTenLop);
        btInsertt=findViewById(R.id.btnInsert);
//        btSuaa=findViewById(R.id.btnHuy);
        dao=new LopDAO(QLthemsuasvActivity.this);

        btInsertt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ma=etMaa.getText().toString();
                String ten=etTenn.getText().toString();
                LopHoc lop=new LopHoc(ma,ten);
                if(dao.create(lop)){
                    Toast.makeText(QLthemsuasvActivity.this,"Insert thành công!!!",
                            Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(QLthemsuasvActivity.this,"Insert thất bại!!!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

//        btSuaa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String ma=etMaa.getText().toString();
//                String ten=etTenn.getText().toString();
//                LopHoc lop=new LopHoc(ma,ten);
//                if(dao.update(lop.getTenLop(),lop.getMaLop())){
//                    Toast.makeText(QLthemsuasvActivity.this,"Update thành công!!!",
//                            Toast.LENGTH_LONG).show();
//                    finish();
//                }else {
//                    Toast.makeText(QLthemsuasvActivity.this,"Update thất bại!!!",
//                            Toast.LENGTH_LONG).show();
//                }
//
//
//            }
//        });




        lv = findViewById(R.id.lvLopHoc);
//        btnInsert=findViewById(R.id.btnInsert);
        //  btnInsert=findViewById(R.id.fbInsertLop);
        dao = new LopDAO(QLthemsuasvActivity.this);
        // Get data
        data = dao.readAll();
        adapter = new LopHocAdapter(QLthemsuasvActivity.this, data);
        lv.setAdapter(adapter);


//        lv=findViewById(R.id.lvCustom);
//
//        data.add(new SinhVien("Quạt trần ","Giá:10000 ",R.drawable.boxx1,"Số lượng:001"));
//        data.add(new SinhVien("Quạt gió ","Giá:20000 ",R.drawable.boxx2,"Số lượng:002"));
//        data.add(new SinhVien("Quạt máy ","Giá:30000 ",R.drawable.box3,"Số lượng:003"));
//        data.add(new SinhVien("Quạt bàn ","Giá:40000",R.drawable.anh6,"Số lượng:004"));
//        data.add(new SinhVien("Quạt thông gió ","Giá:50000 ",R.drawable.anhlogin,"Số lượng:005"));
//
//
//        adapter =new SinhVienAdapter(QLthemsuasvActivity.this,data);
//        lv.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        data.clear();
        data.addAll(dao.readAll());
        adapter.notifyDataSetChanged();
    }
}
