package com.example.va40;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.va40.ROOM.Database;
import com.example.va40.ROOM.VADao;
import com.example.va40.ROOM.room;
import com.example.va40.databinding.ActivityVamailBinding;
import com.example.va40.dialog.Dialog_adapter;
import com.example.va40.dialog.dialog_gigi;

import java.util.ArrayList;
import java.util.List;


public class VAmail extends AppCompatActivity {
    private ActivityVamailBinding binding;
    VADao vaDao;
    Database database;
    Viewmodel viewmodel;
    Dialog_adapter dialog_adapter;
    LiveData liveData;
    room room;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVamailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        database = Room.databaseBuilder(VAmail.this,Database.class,"WorldHenDa")
                .allowMainThreadQueries().build();
        vaDao = database.getDao();


        vmback();add();delete();search();


        dialog_adapter = new Dialog_adapter(VAmail.this,viewmodel, getSupportFragmentManager() );
        binding.vmRecyclerview.setAdapter(dialog_adapter);
        binding.vmRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        viewmodel  = new ViewModelProvider(this).get(Viewmodel.class);

        liveData = database.getDao().getall();
                liveData.observe(VAmail.this, new Observer<List<room>>() {
            @Override
            public void onChanged(List<room> rooms) {
                dialog_adapter.addList((ArrayList<room>) rooms);

            }
        });

    }
    private void vmback(){
        binding.vmBack.setColorFilter(0xFF6FAE46);
        binding.vmBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent(VAmail.this,MainFace.class);
                startActivity(i);
            }
        });
    }

    private void add(){
        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_gigi dialog_gigi = new dialog_gigi(viewmodel,room);
                dialog_gigi.show(getSupportFragmentManager(),"GIGI");



            }
        });
    }
    private void delete(){
        binding.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0;i<dialog_adapter.room_d.size();i++){
                    database.getDao().Delete(dialog_adapter.room_d.get(i));
                }

            }
        });
    }
    private void search(){
        binding.searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                liveData.removeObservers(VAmail.this);
                liveData = database.getDao().select(binding.searchEdit.getText().toString());
                liveData.observe(VAmail.this,new Observer<List<room>>() {
                    @Override
                    public void onChanged(List<room> rooms) {
                        dialog_adapter.addList((ArrayList<room>) rooms);
                    }
                });

            }
        });
    }


}