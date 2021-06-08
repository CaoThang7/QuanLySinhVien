package com.example.lt15303_ps12545_lycaothang_assignmentgd1.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lt15303_ps12545_lycaothang_assignmentgd1.R;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.SinhVienActivity;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.dao.SinhVienDAO;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.model.SinhVien;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.sinhvienEdit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SinhVienAdapter extends BaseAdapter {
    Context context;
    ArrayList<SinhVien> data;
    SinhVienDAO dao;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    public SinhVienAdapter(Context context, ArrayList<SinhVien> data){
        this.context=context;
        this.data=data;

    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView ==null){
            holder =new ViewHolder();
            LayoutInflater inflater=((Activity)context).getLayoutInflater();
            convertView =inflater.inflate(R.layout.sinhvien_item,null);

            holder.ivEdit=convertView.findViewById(R.id.ivEdit);
            holder.ivDel=convertView.findViewById(R.id.ivDel);
            holder.tvTenSv=convertView.findViewById(R.id.tvTenSv);
            holder.tvNgaySinh=convertView.findViewById(R.id.tvNgaySinh);
            holder.tvLopFK=convertView.findViewById(R.id.tvLopHocFK);
            holder.ivAva=convertView.findViewById(R.id.ivAvatar);

            // holder.tvPrice=convertView.findViewById(R.id.tvPrice);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
        // LopHoc lop=data.get(position);
        holder.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, sinhvienEdit.class);
                i.putExtra("sinhvien",data.get(position));
                ((Activity)context).startActivity(i);

            }
        });




        holder.ivDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i=new Intent(context, sinhvien_item.class);
//                i.putExtra("sinhvien",data.get(position));


                String ten =data.get(position).getTenSv();

                if(dao.delete(ten)){
                    Toast.makeText(context," thành công!!!",
                            Toast.LENGTH_LONG).show();




                }else {
                    Toast.makeText(context," thất bại!!!",
                            Toast.LENGTH_LONG).show();
                }
                Intent i=new Intent(context, SinhVienActivity.class);
                i.putExtra("sinhvien",data.get(position));
                ((Activity)context).startActivity(i);
//                String ten = etTen.getText().toString();
//                String ns = etNs.getText().toString();
//                String hinh = etHinh.getText().toString();
//                LopHoc lop = (LopHoc) spnLop.getSelectedItem();
//                String maLop = lop.getMaLop();
            }


        });

        String tenHinh=data.get(position).getHinh();
        int resImg=context.getResources().getIdentifier(tenHinh,"drawable",context.getPackageName());
        holder.ivAva.setImageResource(resImg);
        holder.tvTenSv.setText(data.get(position).getTenSv());
        holder.tvNgaySinh.setText(sdf.format(data.get(position).getNgaySinh()));
        holder.tvLopFK.setText(data.get(position).getMaLopHoc());

        dao = new SinhVienDAO(context);
        // Get data
        data = dao.readAll();

        return convertView;
    }
    class  ViewHolder{
        ImageView ivEdit,ivDel, ivAva;
        TextView tvTenSv,tvNgaySinh,tvLopFK;

    }



}
