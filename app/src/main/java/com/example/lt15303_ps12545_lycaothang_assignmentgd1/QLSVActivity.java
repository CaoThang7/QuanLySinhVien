package com.example.lt15303_ps12545_lycaothang_assignmentgd1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class QLSVActivity extends AppCompatActivity {
    LinearLayout anhnen;
    ImageButton bt1,bt2,bt3,bt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_l_s_v);

        anhnen=(LinearLayout)findViewById(R.id.AnhNen);
        anhnen.setBackgroundResource(R.drawable.ngoisao2);

        bt1=findViewById(R.id.image1);
        bt1.setBackgroundResource(R.drawable.ggg);

        bt2=findViewById(R.id.image2);
        bt2.setBackgroundResource(R.drawable.ggg);

//        bt3=findViewById(R.id.dangxuat);
//        bt3.setBackgroundResource(R.drawable.ggg);
//
//        bt4=findViewById(R.id.doimatkhau);
//        bt4.setBackgroundResource(R.drawable.ggg);

//        bt3=findViewById(R.id.image3);
//        bt3.setBackgroundResource(R.drawable.ggg);
//
//        bt4=findViewById(R.id.image4);
//        bt4.setBackgroundResource(R.drawable.ggg);




        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(QLSVActivity.this,LopInsertActivity.class);
                startActivity(i);
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(QLSVActivity.this,MainActivity.class);
                startActivity(i);
            }
        });



//        bt3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(QLSVActivity.this,Lab1btThemActivity.class);
//                startActivity(i);
//            }
//        });
//
//
//
//        bt4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(QLSVActivity.this,doimatkhauActivity.class);
//                startActivity(i);
//            }
//        });




    }
}
