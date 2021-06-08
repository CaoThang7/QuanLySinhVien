package com.example.lt15303_ps12545_lycaothang_assignmentgd1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lt15303_ps12545_lycaothang_assignmentgd1.dao.SanPhamDao;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.model.SanPham;

public class SpEditActivity extends AppCompatActivity {
    EditText ID,Namee,Pricee,Avartar;
    Button btEditSP,btXoaSP;
    ImageView xoa;
    SanPhamDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_edit);

        ID=findViewById(R.id.IDD);
        Namee=findViewById(R.id.Namee);
        Pricee=findViewById(R.id.Pricee);
        Avartar=findViewById(R.id.Avatar);
        btEditSP=findViewById(R.id.btnEditSP);
        btXoaSP=findViewById(R.id.btnxoaSP);
        dao= new SanPhamDao(SpEditActivity.this);
        SanPham sanpham=(SanPham) getIntent().getSerializableExtra("sanpham");
        



        ID.setText(String.valueOf(sanpham.getID()));
        Namee.setText(sanpham.getName());
        Pricee.setText(String.valueOf(sanpham.getPrice()) );
        Avartar.setText(sanpham.getImage());

       btEditSP.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Integer id=Integer.parseInt(ID.getText().toString());
               String ten=Namee.getText().toString();
               String hinh= Avartar.getText().toString();
               Double price=Double.parseDouble(Pricee.getText().toString());


               if(dao.update(id,ten,hinh,price)){
                   Toast.makeText(SpEditActivity.this," thành công!!!",
                           Toast.LENGTH_LONG).show();
                   finish();
               }else {
                   Toast.makeText(SpEditActivity.this," thất bại!!!",
                           Toast.LENGTH_LONG).show();
               }
           }
       });





    }


}
