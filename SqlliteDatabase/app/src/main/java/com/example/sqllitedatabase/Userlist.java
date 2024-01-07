package com.example.sqllitedatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Userlist extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> id,name,surname,phone,email,address;
    DBHelper DB;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);

        DB = new DBHelper(this);
        id = new ArrayList<>();
        name = new ArrayList<>();
        surname = new ArrayList<>();
        phone = new ArrayList<>();
        email = new ArrayList<>();
        address = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new Adapter(this,id,name,surname,phone,email,address);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        displaydata();
    }

    private void displaydata(){
        Cursor cursor = DB.getData();

        if(cursor.getCount() == 0){
            Toast.makeText(Userlist.this,"No Entry Exist",Toast.LENGTH_LONG).show();
            return;
        }else
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                surname.add(cursor.getString(2));
                phone.add(cursor.getString(3));
                email.add(cursor.getString(4));
                address.add(cursor.getString(5));
            }

    }

}