package com.example.va40.ROOM;

import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {room.class}, version = 1,exportSchema = false)
public abstract class Database extends RoomDatabase {


        //if(database == null){
        //  database = Room.databaseBuilder(VAmail.this,Database.class,"WorldHenDa")
        //                .allowMainThreadQueries().build();
        // }
        // return database;
        public abstract  VADao getDao();


}
