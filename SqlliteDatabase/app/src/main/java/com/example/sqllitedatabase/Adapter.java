package com.example.sqllitedatabase;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context context;
    private ArrayList id,name,surname,phone,email,address;

    public Adapter(Context context, ArrayList id, ArrayList name, ArrayList surname, ArrayList phone, ArrayList email, ArrayList address) {
        this.context = context;
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id.setText(String.valueOf(id.get(position)));
        holder.name.setText(String.valueOf(name.get(position)));
        holder.surname.setText(String.valueOf(surname.get(position)));
        holder.phone.setText(String.valueOf(phone.get(position)));
        holder.email.setText(String.valueOf(email.get(position)));
        holder.address.setText(String.valueOf(address.get(position)));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView id,name,surname,phone,email,address;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.idText);
            name = itemView.findViewById(R.id.nameText);
            surname = itemView.findViewById(R.id.surnameText);
            phone = itemView.findViewById(R.id.phoneText);
            email = itemView.findViewById(R.id.mailText);
            address = itemView.findViewById(R.id.addressText);
        }
    }
}
