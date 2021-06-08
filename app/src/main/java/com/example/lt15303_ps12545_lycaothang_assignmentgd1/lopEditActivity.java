package com.example.lt15303_ps12545_lycaothang_assignmentgd1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lt15303_ps12545_lycaothang_assignmentgd1.dao.LopDAO;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.model.LopHoc;

public class lopEditActivity extends AppCompatActivity {
    EditText etMa,etTen;
    Button btEdit,btXoa;
    ImageView xoa;
    LopDAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lop_edit);
        etMa=findViewById(R.id.txtMaLopEdit);
        etTen=findViewById(R.id.txtTenLopEdit);
        dao= new LopDAO(lopEditActivity.this);
        btEdit=findViewById(R.id.btnEditLop);
        xoa=findViewById(R.id.ivDel);
        btXoa=findViewById(R.id.btnXoaLop);
        LopHoc lop=(LopHoc) getIntent().getSerializableExtra("lophoc");
        etMa.setText(lop.getMaLop());
        etTen.setText(lop.getTenLop());

        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ma= etMa.getText().toString();
                String ten=etTen.getText().toString();
                if(dao.update(ma,ten)){
                    Toast.makeText(lopEditActivity.this," thành công!!!",
                            Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(lopEditActivity.this," thất bại!!!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });





        btXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ma= etMa.getText().toString();
                String ten=etTen.getText().toString();
                if(dao.delete(ten)){
                    Toast.makeText(lopEditActivity.this," thành công!!!",
                            Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(lopEditActivity.this," thất bại!!!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });





         //Su kien xoa
//        xoa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String ma= etMa.getText().toString();
//
//                LopHoc lop=new LopHoc(ma);
//
//                if( dao.delete(ma)){
//                    Toast.makeText(lopEditActivity.this,"Delete thành công!!!",
//                            Toast.LENGTH_LONG).show();
//                    finish();
//                }else {
//                    Toast.makeText(lopEditActivity.this,"Delete thất bại!!!",
//                            Toast.LENGTH_LONG).show();
//                }
//            }
//        });
    }
}
