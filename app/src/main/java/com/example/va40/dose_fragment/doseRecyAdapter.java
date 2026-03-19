package com.example.va40.dose_fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.va40.R;

public class doseRecyAdapter extends RecyclerView.Adapter<doseRecyAdapter.LinearViewHolder> {
    private final Context mct;
    public doseRecyAdapter(Context context){
        this.mct = context;
    }

    @NonNull
    @Override
    public doseRecyAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mct).inflate(R.layout.dose_recyclerview_item, parent, false));

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull doseRecyAdapter.LinearViewHolder holder, int position) {

        if(position==1){
            holder.dose_item_tv1.setText("第2劑");
            holder.dose_type.setText("高端");
            holder.dose_date.setText("2022.04.10 14:20");
            holder.dose_re_bg.setBackgroundColor(0xFFFFC100);
        }
        if(position==2){
            holder.dose_item_tv1.setText("第3劑");
            holder.dose_type.setText("BNT");
            holder.dose_date.setText("2022.04.11 14:20");
            holder.dose_re_bg.setBackgroundColor(0xFF0348A7);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }


    static class LinearViewHolder extends RecyclerView.ViewHolder{
        private final TextView dose_item_tv1;
        private final TextView dose_type;
        private final TextView dose_date;
        private final TextView dose_hospital;
        private final ConstraintLayout dose_re_bg;
        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            dose_item_tv1 = itemView.findViewById(R.id.dose_item_tv1);
            dose_type = itemView.findViewById(R.id.dose_type);
            dose_date = itemView.findViewById(R.id.dose_date);
            dose_hospital = itemView.findViewById(R.id.dose_hospital);
            dose_re_bg = itemView.findViewById(R.id.dose_re_bg);

        }
    }
}
