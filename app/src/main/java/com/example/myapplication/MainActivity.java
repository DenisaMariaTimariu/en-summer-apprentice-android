package com.example.myapplication;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

     ArrayList<EventData> eventDataList = new ArrayList<>();
     int[] eventImage = {R.drawable.electric, R.drawable.untold,R.drawable.jazz, R.drawable.fotbal};
     EventAdapter adapter;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setUpEventData();

        adapter = new EventAdapter(eventDataList,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SearchView searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_home) {
                return true;
            } else if (item.getItemId() == R.id.bottom_favorite) {
                startActivity(new Intent(getApplicationContext(), FavoritesActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_profile) {
                startActivity(new Intent(getApplicationContext(), OrderActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }
            return false;

        });



    }

    private void filter(String newText) {
        ArrayList<EventData> filteredList = new ArrayList<>();
        for (EventData item : eventDataList) {
            if(item.getEventName().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(item);
            }

        }
        adapter.filterList(filteredList);

    }

    private void setUpEventData(){
        String[] eventName = getResources().getStringArray(R.array.events_name);
        String[] eventDescription = getResources().getStringArray(R.array.description);

        for (int i = 0; i <eventName.length; i++) {
            eventDataList.add(new EventData(eventName[i],
                    eventDescription[i],
                    eventImage[i]));
            
        }
    }
}
