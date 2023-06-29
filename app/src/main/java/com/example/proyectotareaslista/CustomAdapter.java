package com.example.proyectotareaslista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

//    private List<String> dataList;
private List<ListItemm> itemList;
//    public CustomAdapter(List<String> lista)
//    {
//        dataList = lista;
//    }

    public CustomAdapter(List<ListItemm> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
//        return new ViewHolder(view);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
//        String data = dataList.get(position);
//        holder.textView.setText(data);
        ListItemm item = itemList.get(position);
        holder.textViewTitle.setText(item.getTitle());
        holder.textViewDescription.setText(item.getDesctiption());
    }
//AQUI ME QUEDEEEEEEEEEEEEEEEEEEEEEEEEEEEE
    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
//        public TextView textView;

        public TextView textViewTitle;
        public TextView textViewDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            textView = itemView.findViewById(R.id.rvdetail);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
        }
    }
}


























