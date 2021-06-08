package com.example.lab5b3activity.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab5b3activity.R;
import com.example.lab5b3activity.lopEditActivity;
import com.example.lab5b3activity.model.LopHoc;

import java.util.ArrayList;

public class LopHocAdapter extends BaseAdapter {
    Context context;
    ArrayList<LopHoc> data;
    public LopHocAdapter(Context context, ArrayList<LopHoc> data){
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
            convertView =inflater.inflate(R.layout.lophoc_item,null);

            holder.ivEdit=convertView.findViewById(R.id.ivEdit);
            holder.ivDel=convertView.findViewById(R.id.ivDel);
            holder.tvTen=convertView.findViewById(R.id.tvTenSinhVien);
            holder.tvSdt=convertView.findViewById(R.id.tvSoDT);
           // holder.tvPrice=convertView.findViewById(R.id.tvPrice);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
       // LopHoc lop=data.get(position);
        holder.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent i=new Intent(context,lopEditActivity.class);
                 i.putExtra("lophoc",data.get(position));
                ((Activity)context).startActivity(i);

            }
        });

        holder.ivDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,lopEditActivity.class);
                i.putExtra("lophoc",data.get(position));
                ((Activity)context).startActivity(i);

            }
        });
        holder.tvTen.setText(data.get(position).getMaLop());
        holder.tvSdt.setText(data.get(position).getTenLop());

        return convertView;
    }
    class  ViewHolder{
        ImageView ivEdit,ivDel;
        TextView tvTen,tvSdt;
    }
}
