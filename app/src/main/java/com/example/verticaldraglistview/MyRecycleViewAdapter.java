package com.example.verticaldraglistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyViewHolder> {


    Context context;
    List<String> data;

    public MyRecycleViewAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = View.inflate(context, R.layout.item, null);
//        return new MyViewHolder(view);

        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);//解决宽度不能铺满
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecycleViewAdapter.MyViewHolder holder, int position) {
        holder.textView.setText(data.get(position));

    }


    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
        }
    }
}
