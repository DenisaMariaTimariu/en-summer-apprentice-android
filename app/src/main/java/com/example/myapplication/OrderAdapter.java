package com.example.myapplication;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAdapter extends  RecyclerView.Adapter<OrderAdapter.ViewHolder> {


    Context context;
    private ArrayList<OrderModel> orderDataList;


    public OrderAdapter(ArrayList<OrderModel> orderDataList, Context context) {
        this.orderDataList=orderDataList;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.order_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ViewHolder holder, int position) {

        holder.textViewId.setText(orderDataList.get(position).getOrderId());
        holder.textViewDate.setText(orderDataList.get(position).getOrderedAt());
        holder.textViewTicketCategory.setText(orderDataList.get(position).getTicketCategory());
        holder.textViewNumberTickets.setText(orderDataList.get(position).getNumberOfTickets());



    }

    @Override
    public int getItemCount() {
        return orderDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewId;
        TextView textViewDate;
        TextView textViewTicketCategory;
        TextView textViewNumberTickets;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.textViewId);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewTicketCategory = itemView.findViewById(R.id.textViewTicketCateg);
            textViewNumberTickets = itemView.findViewById(R.id.textViewNumberTickets);


        }
    }
}
