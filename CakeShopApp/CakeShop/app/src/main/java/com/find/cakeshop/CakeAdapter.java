package com.find.cakeshop;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.ViewHolder> {

    SQLiteDatabase db;
    List<Cake> cakeList;
    public CakeAdapter(SQLiteDatabase _db, List<Cake> cakes)
    {
        db=_db;
        cakeList = cakes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View items= inflater.inflate(R.layout.cake_item,parent,false);
        ViewHolder holder= new ViewHolder(items);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cake cake= cakeList.get(position);
        holder.txvID.setText(String.valueOf(cake.getId()));
        holder.txvCaName.setText(cake.getName ());
        holder.txvDes.setText(cake.getDescription());
        holder.txvCaNum.setText(cake.getNumber ());
        holder.txvPrice.setText(String.valueOf(cake.getPrice()));

        Bitmap bitmap= BitmapFactory.decodeByteArray(cake.getCover(),
                0,cake.getCover().length);
        holder.imvCover.setImageBitmap(bitmap);


    }

    @Override
    public int getItemCount() {
        return cakeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txvID,txvDes,txvPrice,txvCaName,txvCaNum;
        ImageView imvCover;
        ImageButton ibtnEdit,ibtnDelete,ibtnbuynow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txvID= itemView.findViewById(R.id.txvID);
            txvCaNum= itemView.findViewById(R.id.txvCaName);
            txvDes= itemView.findViewById(R.id.txvCaDes);
            txvCaName= itemView.findViewById(R.id.txvCaNum);
            txvPrice= itemView.findViewById(R.id.txvPrice);
            ibtnDelete= itemView.findViewById(R.id.ibtnDelete);
            ibtnEdit= itemView.findViewById(R.id.ibtnEdit);
            ibtnbuynow= itemView.findViewById(R.id.ibtnbuynow);
            imvCover= itemView.findViewById(R.id.imvVCover);

            ibtnbuynow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Create an intent to start the OrderActivity
                    Intent intent = new Intent(ibtnbuynow.getContext(), OrderActivity.class);

                    // Start the OrderActivity
                    ibtnbuynow.getContext().startActivity(intent);

                    // Show a toast message to indicate successful addition to the cart
                    Toast.makeText(ibtnbuynow.getContext(), "Added to Cart Successfully", Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}
