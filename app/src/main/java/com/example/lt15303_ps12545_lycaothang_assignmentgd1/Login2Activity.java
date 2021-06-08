package com.example.lt15303_ps12545_lycaothang_assignmentgd1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login2Activity extends AppCompatActivity {
    EditText etUsernamee,etPasss;
    Button btDangNhapp,btHuyy,btnVN;
    LinearLayout gggg;
    CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);


        gggg=(LinearLayout)findViewById(R.id.gggg);
        gggg.setBackgroundResource(R.drawable.anhlogin);



        //Tham chieu
        etUsernamee= findViewById(R.id.txtUsernamee);
        etPasss= findViewById(R.id.txtPasswordd);
        btDangNhapp= findViewById(R.id.btnDangNhapp);
        btHuyy= findViewById(R.id.btnHuy);
        btnVN=findViewById(R.id.btnVN);


        cb=findViewById(R.id.checkbox2);
        loadData2();


        btnVN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login2Activity.this,Lab1btThemActivity.class);
                startActivity(i);
            }
        });


        btDangNhapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//            String username= etUsername.getText().toString();
//            String pass=etPass.getText().toString();
//            //Toast.makeText(Lab1btThemActivity.this,"Username:" + username,Toast.LENGTH_LONG).show();
//
                String username= "lycaothang";
                String pass="123";

                boolean check=cb.isChecked();
                luuTT(username,pass,check);

                if(etUsernamee.getText().toString().equals(username)&& etPasss.getText().toString().equals(pass)){
                    Toast.makeText(Login2Activity.this,"successfully!!!",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(Login2Activity.this,MainnActivity.class);
                    startActivity(i);

//
                }else{
                    Toast.makeText(Login2Activity.this,"Faild,Please enter again!",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private  void luuTT(String un,String pwd,boolean check){
        SharedPreferences preferences=getSharedPreferences("thongtin.dat",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        if(check){
            editor.putString("username",un);
            editor.putString("password",pwd);
            editor.putBoolean("check",check);
        }else{
            editor.clear();
        }
        editor.commit();
    }

    private void loadData2(){
        SharedPreferences pref=getSharedPreferences("thongtin.dat",MODE_PRIVATE);
        boolean check=pref.getBoolean("check",false);
        if(check){
            etUsernamee.setText(pref.getString("username",""));
            etPasss.setText(pref.getString("password",""));
            cb.setChecked(check);
        }
    }
}
