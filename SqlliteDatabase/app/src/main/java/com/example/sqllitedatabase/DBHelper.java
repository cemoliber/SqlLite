package com.example.sqllitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(idPrimary primary key,name TEXT,surname TEXT,phone TEXT,email TEXT,address TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop table if exists Userdetails");
    }

    public Boolean insertuserdata(String idPrimary,String name,String Surname,String phone,String email,String address){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("idPrimary",idPrimary);
        contentValues.put("name",name);
        contentValues.put("Surname",Surname);
        contentValues.put("phone",phone);
        contentValues.put("email",email);
        contentValues.put("address",address);

        long result = DB.insert("Userdetails",null,contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails",null);
        return cursor;
    }
}