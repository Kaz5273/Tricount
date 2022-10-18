package com.example.mytricount.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytricount.R;

import java.util.List;

import com.example.mytricount.Models.Tricount;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private List<Tricount> dataModelList;
    public  RecyclerViewAdapter(List<Tricount> dataModelList) { this.dataModelList = dataModelList; }

    @NonNull
    @Override
    public RecyclerViewAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_list_item, parent, false);
        viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.text_titre.setText(dataModelList.get(position).getTitre());
        holder.text_desc.setText(dataModelList.get(position).getDescription());

    }
    public long getItemId(int position){
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView text_titre;
        TextView text_desc;


        public RecyclerViewHolder(@NonNull View itemView){
            super(itemView);

            text_titre = itemView.findViewById(R.id.text_titre);
            text_desc = itemView.findViewById(R.id.text_desc);
        }
    }

}
