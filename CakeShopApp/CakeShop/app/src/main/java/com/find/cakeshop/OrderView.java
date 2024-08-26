package com.find.cakeshop;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class OrderView extends RelativeLayout {
    private TextView orderIdTextView;
    private TextView customerNameTextView;
    private TextView customerAddressTextView;
    private TextView totalAmountTextView;
    private RecyclerView recyclerViewOrderItems;

    public OrderView(Context context) {
        super(context);
        init(context);
    }

    public OrderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public OrderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.order_view, this);
        orderIdTextView = findViewById(R.id.textViewOrderId);
        customerNameTextView = findViewById(R.id.textViewCustomerName);
        customerAddressTextView = findViewById(R.id.textViewCustomerAddress);
        totalAmountTextView = findViewById(R.id.textViewTotalAmount);
        recyclerViewOrderItems = findViewById(R.id.rcvcake);
    }

    public void setOrderDetails(Order order) {
        orderIdTextView.setText("Order ID: " + order.getOrderId());
        customerNameTextView.setText("Customer Name: " + order.getCustomerName());
        customerAddressTextView.setText("Customer Address: " + order.getCustomerAddress());
        totalAmountTextView.setText("Total Amount: " + order.getTotalAmount());

        // Set up RecyclerView for order items
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerViewOrderItems.setLayoutManager(layoutManager);
        OrderAdapter orderAdapter = new OrderAdapter(order.getOrderItems());
        recyclerViewOrderItems.setAdapter(orderAdapter);
    }
}
