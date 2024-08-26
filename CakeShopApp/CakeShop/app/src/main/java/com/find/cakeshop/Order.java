package com.find.cakeshop;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private String customerName;
    private String customerAddress;
    private List<Cake> orderItems;
    private double totalAmount;

    public Order() {
        this.orderItems = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    // Add a cake item to the order
    public void addItem(Cake cake) {
        orderItems.add(cake);
        totalAmount += cake.getPrice();
    }

    // Getters and setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<Cake> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Cake> orderItems) {
        this.orderItems = orderItems;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void Save(SQLiteDatabase db) {
        ContentValues values=new ContentValues ();
        values.put("customerName",customerName);
        values.put("totalAmount",totalAmount);
        db.insert ("orders",null,values);

    }
}
