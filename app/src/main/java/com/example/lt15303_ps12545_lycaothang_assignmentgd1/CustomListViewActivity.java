//package com.example.lt15303_ps12545_lycaothang_assignmentgd1;
//
//import android.os.Bundle;
//import android.widget.ListView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.lt15303_ps12545_lycaothang_assignmentgd1.adapter.SinhVienAdapter;
//import com.example.lt15303_ps12545_lycaothang_assignmentgd1.model.SinhVien;
//
//import java.util.ArrayList;
//
//public class CustomListViewActivity extends AppCompatActivity {
//    ListView lv;
//    ArrayList<SinhVien> data=new ArrayList<>();
//    SinhVienAdapter adapter;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_custom_list_view);
//        lv=findViewById(R.id.lvCustom);
//
//        data.add(new SinhVien("Quạt trần ","Giá:10000 ",R.drawable.boxx1,"Số lượng:001"));
//        data.add(new SinhVien("Quạt gió ","Giá:20000 ",R.drawable.boxx2,"Số lượng:002"));
//        data.add(new SinhVien("Quạt máy ","Giá:30000 ",R.drawable.box3,"Số lượng:003"));
//        data.add(new SinhVien("Quạt bàn ","Giá:40000",R.drawable.anh6,"Số lượng:004"));
//        data.add(new SinhVien("Quạt thông gió ","Giá:50000 ",R.drawable.anhlogin,"Số lượng:005"));
//
//
//         adapter =new SinhVienAdapter(CustomListViewActivity.this,data);
//         lv.setAdapter(adapter);
//    }
//}
