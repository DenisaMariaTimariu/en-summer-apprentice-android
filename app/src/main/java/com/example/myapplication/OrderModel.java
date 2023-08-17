package com.example.myapplication;

import java.util.Date;

public class OrderModel {

    private String orderId;
    private String orderedAt;
    private String ticketCategory;
    private String numberOfTickets;

    public OrderModel(String orderId, String orderedAt, String ticketCategory, String numberOfTickets) {
        this.orderId = orderId;
        this.orderedAt = orderedAt;
        this.ticketCategory = ticketCategory;
        this.numberOfTickets = numberOfTickets;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String  orderId) {
        this.orderId = orderId;
    }

    public String getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(String orderedAt) {
        this.orderedAt = orderedAt;
    }

    public String getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(String ticketCategory) {
        this.ticketCategory = ticketCategory;
    }

    public String getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(String numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}
