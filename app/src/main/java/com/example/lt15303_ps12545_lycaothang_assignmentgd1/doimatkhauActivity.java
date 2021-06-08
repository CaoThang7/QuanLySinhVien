package com.example.lt15303_ps12545_lycaothang_assignmentgd1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lt15303_ps12545_lycaothang_assignmentgd1.dao.QuanTriDAO;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.model.User;

public class doimatkhauActivity extends AppCompatActivity {
    EditText oldPwd,newPwd,rePwd;
    Button btDmk,btNhapLai;
    QuanTriDAO qtDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doimatkhau);
        qtDao=new QuanTriDAO(doimatkhauActivity.this);

        oldPwd=findViewById(R.id.oldPwd);
        newPwd=findViewById(R.id.newPwd);
        rePwd=findViewById(R.id.rePwd);
        btDmk=findViewById(R.id.btDmk);
        btNhapLai=findViewById(R.id.btNhapLai);


        btNhapLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(doimatkhauActivity.this,Lab1btThemActivity.class);
                startActivity(i);
            }
        });


        btDmk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String old= oldPwd.getText().toString();
                String nPwd= newPwd.getText().toString();
                String re= rePwd.getText().toString();
                String un= Lab1btThemActivity.USER.getUsername();
                 if(!qtDao.checkOldPWD(old)){
                     Toast.makeText(doimatkhauActivity.this,"Mat khau cu khong dung!!!",Toast.LENGTH_SHORT).show();
                 }else{
                     if(!nPwd.equals(re)){
                         Toast.makeText(doimatkhauActivity.this,"Mat Khau nhap lai khong giong mat khau moi!!!",Toast.LENGTH_SHORT).show();
                     }else{
                         if(qtDao.updatePwd(new User(un,nPwd))){
                             Toast.makeText(doimatkhauActivity.this,"Cap nhat thanh cong!!!",Toast.LENGTH_SHORT).show();

                             Lab1btThemActivity.USER.setPassword(nPwd);
                         }else{
                             Toast.makeText(doimatkhauActivity.this,"Thai Bai!!!",Toast.LENGTH_SHORT).show();
                         }

                     }

                 }
            }
        });





    }
}
