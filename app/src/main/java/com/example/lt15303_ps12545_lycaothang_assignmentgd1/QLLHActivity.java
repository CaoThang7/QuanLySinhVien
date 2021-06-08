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

public class QLLHActivity extends AppCompatActivity {
    LinearLayout anhmanhinh;

    EditText etMa,etTen;
    Button btInsertt,btSua,btXoa,btEdit;
    ImageView sua,xoa;
    LopDAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_l_l_h);
        anhmanhinh=(LinearLayout)findViewById(R.id.AnhManHinh);
        anhmanhinh.setBackgroundResource(R.drawable.anh6);
        etMa=findViewById(R.id.txtMaLop);
        etTen=findViewById(R.id.txtTenLop);
        btInsertt=findViewById(R.id.btnInsert);
        btSua=findViewById(R.id.btnSua);
//        btXoa=findViewById(R.id.btnXoa);
        sua=findViewById(R.id.ivEdit);
        xoa=findViewById(R.id.ivDel);
        btEdit=findViewById(R.id.btnEditLop);
        dao=new LopDAO(QLLHActivity.this);
        btInsertt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ma=etMa.getText().toString();
                String ten=etTen.getText().toString();
                LopHoc lop=new LopHoc(ma,ten);
                if(dao.create(lop)){
                    Toast.makeText(QLLHActivity.this,"Insert thành công!!!",
                            Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(QLLHActivity.this,"Insert thất bại!!!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ma= etMa.getText().toString();
                String ten=etTen.getText().toString();
                if(dao.update(ma,ten)){
                    Toast.makeText(QLLHActivity.this," thành công!!!",
                            Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(QLLHActivity.this," thất bại!!!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        //Su kien xoa
//        btXoa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String ma= etMa.getText().toString();
//
//                LopHoc lop=new LopHoc(ma);
//
//                if( dao.delete(ma)){
//                    Toast.makeText(QLLHActivity.this,"Delete thành công!!!",
//                            Toast.LENGTH_LONG).show();
//                    finish();
//                }else {
//                    Toast.makeText(QLLHActivity.this,"Delete thất bại!!!",
//                            Toast.LENGTH_LONG).show();
//                }
//
//                LopHoc nv=new LopHoc();
//                String ma= etMa.getText().toString();
//
//                dao.delete(nv.getMaLop());
//            }
//        });



    }
}
