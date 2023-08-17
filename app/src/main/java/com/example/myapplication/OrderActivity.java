package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

   ArrayList<OrderModel> orderModels = new ArrayList<>();
   OrderAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewOrder);

        setUpOrderModel();

        adapter = new OrderAdapter(orderModels,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_profile);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_home) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_favorite) {
                startActivity(new Intent(getApplicationContext(), FavoritesActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_profile) {

                return true;
            }
            return false;

        });


    }
    private void setUpOrderModel(){

        String[] date = getResources().getStringArray(R.array.date);
        String[] ticketCategory = getResources().getStringArray(R.array.ticketCategory);
        String[] orderId = getResources().getStringArray(R.array.id);
        String[] numberOfTickets = getResources().getStringArray(R.array.numberOfTickets);


        for (int i = 0; i <orderId.length; i++) {
            orderModels.add(new OrderModel(orderId[i],
                    date[i],
                    ticketCategory[i],
                    numberOfTickets[i]));

        }
    }


}