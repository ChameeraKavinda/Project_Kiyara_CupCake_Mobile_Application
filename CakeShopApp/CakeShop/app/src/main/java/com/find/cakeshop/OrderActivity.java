package com.find.cakeshop;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class OrderActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView totalAmountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // Initialize RecyclerView and TextView
        recyclerView = findViewById(R.id.rcvcake);
        totalAmountTextView = findViewById(R.id.textViewTotalAmount);

        // Retrieve order details from intent extra
        Order order = (Order) getIntent().getSerializableExtra("order");

        // Check if order is not null before displaying details
        if (order != null) {
            // Display order details
            displayOrderDetails(order);
        }
    }

    private void displayOrderDetails(Order order) {
        // Set total amount in TextView
        totalAmountTextView.setText(String.valueOf(order.getTotalAmount()));

        // Set up RecyclerView with LinearLayoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Create and set OrderAdapter with order items
        OrderAdapter orderAdapter = new OrderAdapter(order.getOrderItems());
        recyclerView.setAdapter(orderAdapter);
    }
}
