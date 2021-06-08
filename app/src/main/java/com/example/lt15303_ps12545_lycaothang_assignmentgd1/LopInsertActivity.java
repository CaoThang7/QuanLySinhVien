package com.example.lt15303_ps12545_lycaothang_assignmentgd1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lt15303_ps12545_lycaothang_assignmentgd1.dao.LopDAO;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.model.LopHoc;

public class LopInsertActivity extends AppCompatActivity {
EditText etMa,etTen;
Button btInsert,btSua,btXoa;
ImageView sua,xoa;
LopDAO dao;

    LinearLayout anhheader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lop_insert);

        anhheader=(LinearLayout)findViewById(R.id.anhheader);
        anhheader.setBackgroundResource(R.drawable.anh6);

        etMa=findViewById(R.id.txtMaLop);
        etTen=findViewById(R.id.txtTenLop);
        btInsert=findViewById(R.id.btnInsert);
        btSua=findViewById(R.id.btnSua);
        btXoa=findViewById(R.id.btnXoa);
        sua=findViewById(R.id.ivEdit);
        xoa=findViewById(R.id.ivDel);
        dao=new LopDAO(LopInsertActivity.this);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ma=etMa.getText().toString();
                String ten=etTen.getText().toString();
                LopHoc lop=new LopHoc(ma,ten);
                if(dao.create(lop)){
                    Toast.makeText(LopInsertActivity.this,"Insert thành công!!!",
                            Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(LopInsertActivity.this,"Insert thất bại!!!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });


//          su  kien xoa
        btXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ma=etMa.getText().toString();
                String ten=etTen.getText().toString();
                LopHoc lop=new LopHoc(ma,ten);
                if(dao.delete(lop.getMaLop())){
                    Toast.makeText(LopInsertActivity.this,"Delete thành công!!!",
                            Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(LopInsertActivity.this,"Delete thất bại!!!",
                            Toast.LENGTH_LONG).show();
                }

            }
        });


        // Su kien sua
        btSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ma=etMa.getText().toString();
                String ten=etTen.getText().toString();
                LopHoc lop=new LopHoc(ma,ten);
                if(dao.update(lop.getTenLop(),lop.getMaLop())){
                    Toast.makeText(LopInsertActivity.this,"Update thành công!!!",
                            Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(LopInsertActivity.this,"Update thất bại!!!",
                            Toast.LENGTH_LONG).show();
                }


            }
        });


//        xoa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LopHoc lh=new LopHoc();
//                String ma=etMa.getText().toString();
//                dao.delete(lh.getMaLop());
//
//            }
//        });


    }
}
