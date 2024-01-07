package com.example.sqllitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText id,name,surname,phone,email,address;
    Button insert,view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.idPrimary);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        phone = findViewById(R.id.number);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);

        insert = findViewById(R.id.insertData);
        view = findViewById(R.id.btnView);

        DBHelper DB;

        DB = new DBHelper(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Userlist.class));
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idTXT = id.getText().toString();
                String nameTXT = name.getText().toString();
                String surnameTXT = surname.getText().toString();
                String phoneTXT = phone.getText().toString();
                String emailTXT = email.getText().toString();
                String addressTXT = address.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(idTXT,nameTXT,surnameTXT,phoneTXT,emailTXT,addressTXT);
                if(checkinsertdata){
                    Toast.makeText(MainActivity.this,"New Entry Inserted",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"New Entry NOT Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}