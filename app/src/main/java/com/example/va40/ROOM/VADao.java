package com.example.va40.ROOM;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.va40.R;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface VADao {
    @Insert
    void Insert(room...rooms);

    @Update
    void Update(room...rooms);

    @Delete
    void Delete(room rooms);

    @Query("delete from room")
    void clearall();

    @Query("select * from room order by id desc")
    LiveData<List<room>> getall();

    @Query("select * from room where time like :time")
    LiveData<List<room>> select(String time);

}
