package com.example.lt15303_ps12545_lycaothang_assignmentgd1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class QLSV2Activity extends AppCompatActivity {
    LinearLayout g;
    ImageButton btt1,btt2,btt3,btt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_l_s_v2);

        g=(LinearLayout)findViewById(R.id.ggg);
        g.setBackgroundResource(R.drawable.ngoisao2);

        btt1=findViewById(R.id.image11);
        btt1.setBackgroundResource(R.drawable.ggg);

        btt2=findViewById(R.id.image22);
        btt2.setBackgroundResource(R.drawable.ggg);

//        bt3=findViewById(R.id.image3);
//        bt3.setBackgroundResource(R.drawable.ggg);
//
//        bt4=findViewById(R.id.image4);
//        bt4.setBackgroundResource(R.drawable.ggg);




        btt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(QLSV2Activity.this,QLthemsuasvActivity.class);
                startActivity(i);
            }
        });
//
//        btt1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(QLSV2Activity.this,CustomListViewActivity.class);
//                startActivity(i);
//            }
//        });

    }
}
