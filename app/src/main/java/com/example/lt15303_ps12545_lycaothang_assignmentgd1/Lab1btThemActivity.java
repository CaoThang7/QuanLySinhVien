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

import com.example.lt15303_ps12545_lycaothang_assignmentgd1.dao.QuanTriDAO;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.model.User;

public class Lab1btThemActivity extends AppCompatActivity {
   EditText etUsername,etPass;
    Button btDangNhap,btHuy,btnMy;
    LinearLayout ggg;
    CheckBox ckRem;
    public static User USER =null;
    QuanTriDAO qtDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1bt_them);
//        ggg=(LinearLayout)findViewById(R.id.ggg);
//        ggg.setBackgroundResource(R.drawable.anhlogin);





        qtDao=new QuanTriDAO(Lab1btThemActivity.this);
        //Tham chieu
        etUsername= findViewById(R.id.txtUsername);
        etPass= findViewById(R.id.txtPassword);
        btDangNhap= findViewById(R.id.btnDangNhap);
        btHuy= findViewById(R.id.btnHuy);
        btnMy=findViewById(R.id.btnMy);
        ckRem=findViewById(R.id.checkbox);
        loadData();

       btnMy.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(Lab1btThemActivity.this,Login2Activity.class);
               startActivity(i);
           }
       });


        btDangNhap.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String username=etUsername.getText().toString();
            String pass=etPass.getText().toString();
            boolean check=ckRem.isChecked();
            User user=new User(username,pass);
            if(qtDao.checkLogin(user)){
                luuTT(username,pass,check);
                USER =user;
                Toast.makeText(Lab1btThemActivity.this,"Dang nhap thanh cong!!!",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Lab1btThemActivity.this,MainnActivity.class);
                startActivity(i);

            }else{
                Toast.makeText(Lab1btThemActivity.this,"Dang nhap that bai!!!",Toast.LENGTH_SHORT).show();
            }





//
//              String username= "admin";
//              String pass="admin";

//              boolean check=ckRem.isChecked();
//              luuTT(username,pass,check);
//
//              if(etUsername.getText().toString().equals(username)&& etPass.getText().toString().equals(pass)){
//                  Toast.makeText(Lab1btThemActivity.this,"Đăng nhập thành công!!!",Toast.LENGTH_LONG).show();
//                  Intent i=new Intent(Lab1btThemActivity.this,MainnActivity.class);
//                  startActivity(i);
//
////
//              }else{
//                  Toast.makeText(Lab1btThemActivity.this,"Đăng nhập thất bại mời nhập lại",Toast.LENGTH_LONG).show();
//              }

            // chuyen sang trang lab1b3
            //Intent i=new Intent(Lab1btThemActivity.this,Lab1b3Activity.class);
            //startActivity(i);


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

private void loadData(){
    SharedPreferences pref=getSharedPreferences("thongtin.dat",MODE_PRIVATE);
    boolean check=pref.getBoolean("check",false);
    if(check){
        etUsername.setText(pref.getString("username",""));
        etPass.setText(pref.getString("password",""));
        ckRem.setChecked(check);

    }
}

}
