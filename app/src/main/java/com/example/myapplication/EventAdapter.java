package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder>  {

    Context context;
    private ArrayList<EventData> eventDataList;

    public EventAdapter(ArrayList<EventData> eventDataList, Context context) {
        this.eventDataList=eventDataList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.event_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return new EventAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textViewName.setText(eventDataList.get(position).getEventName());
        holder.textViewDescription.setText(eventDataList.get(position).getEventDescription());
        holder.eventImage.setImageResource(eventDataList.get(position).getEventImage());
       /* holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aici trebuie sa pui sa te redirectioneze la o noua activiatte
                Toast.makeText(context,eventDataList.getEventName(),Toast.LENGTH_LONG).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return eventDataList.size();
    }


    public void filterList(ArrayList<EventData> filteredList){
        eventDataList = filteredList;
        notifyDataSetChanged();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView eventImage;
        TextView textViewName;
        TextView textViewDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eventImage = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textName);
            textViewDescription = itemView.findViewById(R.id.textDescription);


        }
    }
}
