package com.example.va40;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.room.Room;

import com.example.va40.ROOM.Database;
import com.example.va40.ROOM.VADao;
import com.example.va40.ROOM.room;


public class Viewmodel extends AndroidViewModel {
    private Application application;
    public Viewmodel(@NonNull Application application) {
        super(application);
        this.application = application;
    }

    public void come(room room){
        Database database;

        database = Room.databaseBuilder(application.getApplicationContext(),Database.class,"WorldHenDa")
                .allowMainThreadQueries().build();
        VADao vaDao;
        vaDao=database.getDao();
        vaDao.Insert(room);
    }
}
