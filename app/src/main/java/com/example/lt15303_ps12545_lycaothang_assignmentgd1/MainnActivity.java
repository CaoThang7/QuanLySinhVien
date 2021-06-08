package com.example.lt15303_ps12545_lycaothang_assignmentgd1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.lt15303_ps12545_lycaothang_assignmentgd1.R.drawable;
import static com.example.lt15303_ps12545_lycaothang_assignmentgd1.R.id;
import static com.example.lt15303_ps12545_lycaothang_assignmentgd1.R.layout;

public class MainnActivity extends AppCompatActivity {
    LinearLayout manHinh;
    ImageButton botron1,botron2,botron3,botron4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_mainn);
        manHinh=(LinearLayout)findViewById(id.ManHinh);
        manHinh.setBackgroundResource(drawable.ngoisao);


        botron2=findViewById(id.imagebutton);
        botron2.setBackgroundResource(drawable.ggg);

        botron1=findViewById(id.thang);
        botron1.setBackgroundResource(drawable.ggg);

        botron3=findViewById(R.id.dangxuat);
        botron3.setBackgroundResource(R.drawable.ggg);

        botron4=findViewById(R.id.doimatkhau);
        botron4.setBackgroundResource(R.drawable.ggg);






        botron1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainnActivity.this,QLSVActivity.class);
                startActivity(i);
            }
        });


        botron2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainnActivity.this,SinhVienActivity.class);
                startActivity(i);
            }
        });

                botron3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainnActivity.this,Lab1btThemActivity.class);
                startActivity(i);
            }
        });



        botron4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainnActivity.this,doimatkhauActivity.class);
                startActivity(i);
            }
        });



    }
}
