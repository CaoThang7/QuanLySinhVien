package com.example.lt15303_ps12545_lycaothang_assignmentgd1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lt15303_ps12545_lycaothang_assignmentgd1.dao.SanPhamDao;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.model.SanPham;

public class SanPhamInsertActivity extends AppCompatActivity {

    EditText ID,Name,Price,Image;
    Button themSP,nhapLai;
    SanPhamDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham_insert);

        ID=findViewById(R.id.txtID);
        Name=findViewById(R.id.txtName);
        Price=findViewById(R.id.txtPrice);
        Image=findViewById(R.id.txtImage);
        themSP=findViewById(R.id.btnThemSP);
        nhapLai=findViewById(R.id.btnNhapLaiSP);
        dao=new SanPhamDao(SanPhamInsertActivity.this);

        themSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ma= Integer.parseInt(ID.getText().toString());
                String ten=Name.getText().toString();
                String hinh=Image.getText().toString();
                Double price=Double.parseDouble(Price.getText().toString());

                SanPham sanpham=new SanPham(ma,ten,hinh,price);
                if(dao.create(sanpham)){
                    Toast.makeText(SanPhamInsertActivity.this,"Insert thành công!!!",
                            Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(SanPhamInsertActivity.this,"Insert thất bại!!!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
