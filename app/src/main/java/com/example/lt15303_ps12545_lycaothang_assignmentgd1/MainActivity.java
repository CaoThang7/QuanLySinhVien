package com.example.lt15303_ps12545_lycaothang_assignmentgd1;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lt15303_ps12545_lycaothang_assignmentgd1.adapter.LopHocAdapter;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.dao.LopDAO;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.model.LopHoc;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
//    Button btnInsert;
    //FloatingActionButton btnInsert;
    ArrayList<LopHoc> data=new ArrayList<>();
    LopHocAdapter adapter;
    LopDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lvLopHoc);

//        btnInsert=findViewById(R.id.btnInsert);
        //  btnInsert=findViewById(R.id.fbInsertLop);
        dao = new LopDAO(MainActivity.this);
        // Get data
        data = dao.readAll();
        adapter = new LopHocAdapter(MainActivity.this, data);
        lv.setAdapter(adapter);

//
//        btnInsert.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(MainActivity.this,LopInsertActivity.class);
//                startActivity(i);
//            }
//        });

//        for(int i=0;i<data.size();i++){
//            Log.i("Data",data.get(i).getMaLop());
//            Log.i("Data",data.get(i).getTenLop());
//
//        }
    }







    @Override
    protected void onResume() {
        super.onResume();
        data.clear();
        data.addAll(dao.readAll());
        adapter.notifyDataSetChanged();
    }
}
