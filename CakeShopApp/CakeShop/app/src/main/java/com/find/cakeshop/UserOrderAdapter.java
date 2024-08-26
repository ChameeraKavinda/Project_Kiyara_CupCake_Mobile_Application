package com.find.cakeshop;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserOrderAdapter extends RecyclerView.Adapter<UserOrderAdapter.ViewHolder> {

    SQLiteDatabase db;
    List<Cake> orderList;
    public UserOrderAdapter(SQLiteDatabase _db, List<Cake> orders)
    {
        db=_db;
        orderList = orders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View items= inflater.inflate(R.layout.user_order,parent,false);
        ViewHolder holder= new ViewHolder(items);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cake cake= orderList.get(position);
        holder.OrderID.setText(String.valueOf(cake.getId()));
        holder.OrderName.setText(cake.getName ());
        holder.OrderDes.setText(cake.getDescription());
        holder.OrderNum.setText(cake.getNumber ());
        holder.OrderPrice.setText(String.valueOf(cake.getPrice()));

        Bitmap bitmap= BitmapFactory.decodeByteArray(cake.getCover(),
                0,cake.getCover().length);
        holder.imvVOrder.setImageBitmap(bitmap);

        holder.oderBtn.setOnClickListener(new View.OnClickListener() {
            Order order =new Order ();


            @Override
            public void onClick(View v) {

            }




        });


    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView OrderID,OrderName,OrderDes,OrderNum,OrderPrice;
        ImageView imvVOrder;
        Button oderBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            OrderID= itemView.findViewById(R.id.OrderID);
            OrderName= itemView.findViewById(R.id.OrderName);
            OrderDes= itemView.findViewById(R.id.OrderDes);
            OrderNum= itemView.findViewById(R.id.OrderNum);
            OrderPrice= itemView.findViewById(R.id.OrderPrice);
            oderBtn= itemView.findViewById(R.id.oderBtn);
            imvVOrder= itemView.findViewById(R.id.imvVOrder);



        }
    }
}
