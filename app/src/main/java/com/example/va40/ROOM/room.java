package com.example.va40.ROOM;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class room {

    @PrimaryKey(autoGenerate = true)
    private  int id ;

    @ColumnInfo(name = "code")
    String code;
    @ColumnInfo(name = "time")
    String time;
    @ColumnInfo(name = "date")
    String date;
    @ColumnInfo(name = "AM_PM")
    Boolean am_pm;

    public room(String code, String date,String time, Boolean am_pm) {
        this.code = code;
        this.date = date;
        this.time = time;
        this.am_pm = am_pm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getAm_pm() {
        return am_pm;
    }

    public void setAm_pm(Boolean am_pm) {
        this.am_pm = am_pm;
    }
}
