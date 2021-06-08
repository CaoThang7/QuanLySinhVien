package com.example.lt15303_ps12545_lycaothang_assignmentgd1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lt15303_ps12545_lycaothang_assignmentgd1.adapter.SanPhamAdapter;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.dao.SanPhamDao;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.model.SanPham;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class SanPhamActivity extends AppCompatActivity {
    ListView lv;


    FloatingActionButton btnInsert;
    ArrayList<SanPham> data=new ArrayList<>();
    SanPhamAdapter adapter;
    SanPhamDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham);
        lv = findViewById(R.id.lvSanPham);

//        btnInsert=findViewById(R.id.btnInsert);
          btnInsert=findViewById(R.id.fbInsertLop);
        dao = new SanPhamDao(SanPhamActivity.this);
        // Get data
        data = dao.readAll();
        adapter = new SanPhamAdapter(SanPhamActivity.this, data);
        lv.setAdapter(adapter);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SanPhamActivity.this,SanPhamInsertActivity.class);
                startActivity(i);
            }
        });


    }
    @Override
    protected void onResume() {
        super.onResume();
        data.clear();
        data.addAll(dao.readAll());
        adapter.notifyDataSetChanged();
    }
}
