package com.example.lt15303_ps12545_lycaothang_assignmentgd1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lt15303_ps12545_lycaothang_assignmentgd1.dao.LopDAO;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.model.LopHoc;

public class lophoc_item extends AppCompatActivity {
    ImageView xoaa;
    TextView tvTen,tvSdt;
    ImageView xoa;
    EditText etTen;
    LopDAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lophoc_item);
        LopHoc lop=(LopHoc) getIntent().getSerializableExtra("lophoc");
        dao= new LopDAO(lophoc_item.this);
        xoaa=findViewById(R.id.ivDel);
        tvSdt=findViewById(R.id.tvSoDT);
        tvTen=findViewById(R.id.tvTenSinhVien);



        xoaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ma= tvSdt.getText().toString();
                String ten=tvTen.getText().toString();
                if(dao.delete(ten)){
                    Toast.makeText(lophoc_item.this," thành công!!!",
                            Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(lophoc_item.this," thất bại!!!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
