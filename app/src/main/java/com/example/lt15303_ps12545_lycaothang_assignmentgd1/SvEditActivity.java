package com.example.lt15303_ps12545_lycaothang_assignmentgd1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lt15303_ps12545_lycaothang_assignmentgd1.dao.LopDAO;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.model.SinhVien;

import java.text.SimpleDateFormat;

public class SvEditActivity extends AppCompatActivity {
    EditText TenSVV,NgaySinhh,Avartar;
    Spinner spnLopHocc;
    Button btEditSV,btXoaSv;
    ImageView xoa;
    LopDAO dao;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sv_edit);

        TenSVV=findViewById(R.id.TenSVV);
        NgaySinhh=findViewById(R.id.NgaySinhh);
        Avartar=findViewById(R.id.Avatar);
        spnLopHocc=findViewById(R.id.spnLopHocc);
        btEditSV=findViewById(R.id.btnEditSv);
        btXoaSv=findViewById(R.id.btnxoaSV);
        dao= new LopDAO(SvEditActivity.this);
        SinhVien lop=(SinhVien) getIntent().getSerializableExtra("sinhvien");


        TenSVV.setText(lop.getTenSv());
        NgaySinhh.setText(sdf.format(lop.getNgaySinh()));
        Avartar.setText(lop.getHinh());

        btEditSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten=TenSVV.getText().toString();
                String ngaysinh= NgaySinhh.getText().toString();


                if(dao.update(ten,ngaysinh)){
                    Toast.makeText(SvEditActivity.this," thành công!!!",
                            Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(SvEditActivity.this," thất bại!!!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });





    }
}
