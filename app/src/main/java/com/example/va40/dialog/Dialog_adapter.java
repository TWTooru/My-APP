package com.example.va40.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.va40.R;
import com.example.va40.ROOM.Database;
import com.example.va40.ROOM.VADao;
import com.example.va40.ROOM.room;
import com.example.va40.VApassport;
import com.example.va40.Viewmodel;


import java.util.ArrayList;
import java.util.List;


public class Dialog_adapter extends RecyclerView.Adapter<Dialog_adapter.LinearViewHolder> {
    private final Context ctx;
    private ArrayList<room> room =new ArrayList<>();
    public ArrayList<room> room_d =new ArrayList<>();

    Viewmodel viewmodel;
    FragmentManager fragmentManager;

    public Dialog_adapter(Context context, Viewmodel viewmodel, FragmentManager fragmentManager){
        this.ctx = context;
        this.viewmodel = viewmodel;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public Dialog_adapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(ctx).inflate(R.layout.dialog_item, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.date.setText(room.get(position).getDate());
        holder.time.setText(room.get(position).getTime());
        holder.code.setText(room.get(position).getCode());
        if (room.get(position).getAm_pm()){
            holder.ampm.setText("AM");
        }
        if (!room.get(position).getAm_pm()){
            holder.ampm.setText("PM");
        }
        holder.checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.img_check.getVisibility() ==View.VISIBLE){
                    holder.img_check.setVisibility(View.INVISIBLE);
                    room_d.remove(room.get(position));
                }
                else if(holder.img_check.getVisibility() ==View.INVISIBLE){
                    holder.img_check.setVisibility(View.VISIBLE);
                    room_d.add(room.get(position));
                }
            }
        });
        holder.img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog_gigi dialog_gigi;
                dialog_gigi = new dialog_gigi(viewmodel,room.get(position));
                dialog_gigi.show(fragmentManager, "GIGI");




            }
        });
    }

    @Override
    public int getItemCount() {
        return room.size();
    }


    static class LinearViewHolder extends RecyclerView.ViewHolder{
        private TextView date,time,ampm,code,title;
        private final ConstraintLayout checkbox;
        private final ImageView img_check;
        private  ImageView img_edit;
        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.dg_item_date);
            time = itemView.findViewById(R.id.dg_item_time);
            ampm = itemView.findViewById(R.id.dg_item_ap);
            code = itemView.findViewById(R.id.dg_item_code);
            checkbox = itemView.findViewById(R.id.checkbox);
            img_edit = itemView.findViewById(R.id.img_edit);
            img_check = itemView.findViewById(R.id.img_check);
            title = itemView.findViewById(R.id.dia_title);
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    public void addList(ArrayList<room> arrayList){
        this.room = arrayList;
        notifyDataSetChanged();
    }

}
