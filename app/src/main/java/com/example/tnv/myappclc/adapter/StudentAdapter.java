package com.example.tnv.myappclc.adapter;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tnv.myappclc.R;
import com.example.tnv.myappclc.model.Student;

import java.util.List;

/**
 * Created by TNV on 3/17/2018.
 */

public class StudentAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Student> listStudent;

    public StudentAdapter(Context context, int layout, List<Student> listStudent) {
        this.context = context;
        this.layout = layout;
        this.listStudent = listStudent;
    }

    public void getSearch(List<Student> list){
        this.listStudent = list;
        notifyDataSetChanged();

    }
    @Override
    public int getCount() {
        return listStudent.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    class ViewHolder{
        ImageView imageView;
        TextView textViewName,textViewGender,textViewAddress;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            viewHolder.textViewName = view.findViewById(R.id.tvName);
            viewHolder.textViewGender= view.findViewById(R.id.tvGender);
            viewHolder.textViewAddress = view.findViewById(R.id.tvAddress);
            viewHolder.imageView= view.findViewById(R.id.imgIcon);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        Student student = listStudent.get(i);
        if (student.isGender()){
            int nam = R.string.nam;
            viewHolder.textViewGender.setText("Giới tính: Nam");
            viewHolder.imageView.setImageResource(R.drawable.nam);
        }else{
            viewHolder.imageView.setImageResource(R.drawable.nu);
            viewHolder.textViewGender.setText("Giới tính: Nữ");
        }
        viewHolder.textViewAddress.setText("Địa Chỉ: "+student.getAddress());
        viewHolder.textViewName.setText("Tên: "+student.getFullName());
        return view;
    }
}
