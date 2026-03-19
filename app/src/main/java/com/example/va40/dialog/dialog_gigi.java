package com.example.va40.dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.room.Room;

import com.example.va40.R;
import com.example.va40.ROOM.Database;
import com.example.va40.ROOM.VADao;
import com.example.va40.ROOM.room;
import com.example.va40.Viewmodel;
import com.example.va40.databinding.ActivityDialogBinding;

import java.util.ArrayList;
import java.util.List;


public class dialog_gigi extends DialogFragment {
    private ActivityDialogBinding binding;
    private Boolean ap = false;
    Viewmodel viewmodel;
    room room;

    public dialog_gigi(Viewmodel viewmodel,room room) {
        this.viewmodel = viewmodel;
        this.room = room;
    }
    @NonNull
    @Override

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        binding = ActivityDialogBinding.inflate(getLayoutInflater());
        AlertDialog alertDialog = new AlertDialog.Builder(requireContext())
                .setView(binding.getRoot())
                .setCancelable(false)
                .create();
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Database database;
        database = Room.databaseBuilder(requireContext(),Database.class,"ININ").allowMainThreadQueries().build();


        if (room== null){
            ampm();
            binding.confirmBtn.setOnClickListener(new View.OnClickListener()    {
                @Override
                public void onClick(View view) {

                    String code  = binding.localcode.getText().toString();
                    String date = binding.date.getText().toString();
                    String time = binding.time.getText().toString();

                    room room;
                    room = new room(code,date,time,ap);
                    viewmodel.come(room);
                    dismiss();
                }
            });
        }
        else if(!(room == null)){
            ampm();
            binding.localcode.setText(room.getCode());
            binding.date.setText(room.getDate());
            binding.time.setText(room.getTime());

            if(room.getAm_pm()){
                binding.am.setTextColor(0xFF6FAE46);
                binding.pm.setTextColor(0xFFADADAD);
            }
            if(!(room.getAm_pm())){
                binding.am.setTextColor(0xFFADADAD);
                binding.pm.setTextColor(0xFF6FAE46);
            }

            binding.confirmBtn.setOnClickListener(new View.OnClickListener()    {
                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View view) {


                    binding.diaTitle.setText("");
                    room.setCode(binding.localcode.getText().toString());
                    room.setDate(binding.date.getText().toString());
                    room.setTime(binding.time.getText().toString());
                    database.getDao().Update(room);
                    dismiss();
                }
            });

        }

        binding.cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return alertDialog;
    }
    public  void  ampm(){
        binding.am.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.am.setTextColor(0xFF6FAE46);
                binding.pm.setTextColor(0xFFADADAD);
                ap = true;
            }
        });
        binding.pm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.am.setTextColor(0xFFADADAD);
                binding.pm.setTextColor(0xFF6FAE46);
                ap = false;
            }
        });
    }


}
