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
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.SanPhamActivity;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.SpEditActivity;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.dao.SanPhamDao;
import com.example.lt15303_ps12545_lycaothang_assignmentgd1.model.SanPham;

import java.util.ArrayList;

public class SanPhamAdapter extends BaseAdapter {
    Context context;
    ArrayList<SanPham> data;
    SanPhamDao dao;

    public SanPhamAdapter(Context context, ArrayList<SanPham> data){
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
            convertView =inflater.inflate(R.layout.sanpham_item,null);

            holder.ivEdit=convertView.findViewById(R.id.ivEdit);
            holder.ivDel=convertView.findViewById(R.id.ivDel);
            holder.tvID=convertView.findViewById(R.id.tvID);
            holder.tvName=convertView.findViewById(R.id.tvName);
            holder.tvPrice=convertView.findViewById(R.id.tvPrice);
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
                Intent i=new Intent(context, SpEditActivity.class);
                i.putExtra("sanpham",data.get(position));
                ((Activity)context).startActivity(i);

            }
        });




        holder.ivDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer ten =data.get(position).getID();

                if(dao.delete(ten)){
                    Toast.makeText(context," thành công!!!",
                            Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(context," thất bại!!!",
                            Toast.LENGTH_LONG).show();
                }
                Intent i=new Intent(context, SanPhamActivity.class);
                i.putExtra("sanpham",data.get(position));
                ((Activity)context).startActivity(i);
            }


        });

        Double a=data.get(position).getPrice();
        int b=data.get(position).getID();
        String tenHinh=data.get(position).getImage();
        int resImg= context.getResources().getIdentifier(tenHinh,"drawable",context.getPackageName());
        holder.ivAva.setImageResource(resImg);
        holder.tvID.setText(String.valueOf(b));
        holder.tvName.setText(data.get(position).getName());
        holder.tvPrice.setText(String.valueOf(a));

        dao = new SanPhamDao(context);
        // Get data
        data = dao.readAll();

        return convertView;
    }
    class  ViewHolder{
        ImageView ivEdit,ivDel, ivAva;
        TextView tvID,tvName,tvPrice;

    }



}
