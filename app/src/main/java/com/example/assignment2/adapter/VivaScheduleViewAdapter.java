package com.example.assignment2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment2.R;

import java.util.List;

public class VivaScheduleViewAdapter extends RecyclerView.Adapter<VivaScheduleViewAdapter.MHolder> {

    List<AdapterModel> adapterModelList;

    public VivaScheduleViewAdapter(List<AdapterModel> adapterModelList) {
        this.adapterModelList = adapterModelList;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_view_content, parent, false);
        return new MHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        holder.time.setText(adapterModelList.get(position).getTime());
        holder.date.setText(adapterModelList.get(position).getDate());
        holder.name.setText(adapterModelList.get(position).getStudentName());
    }

    @Override
    public int getItemCount() {
        return adapterModelList.size();
    }

    static class MHolder extends RecyclerView.ViewHolder {
        TextView name, date, time;

        public MHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.Name);
            date = itemView.findViewById(R.id.Date);
            time = itemView.findViewById(R.id.Time);
        }
    }
}
