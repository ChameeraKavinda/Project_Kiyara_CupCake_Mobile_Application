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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    SQLiteDatabase db;
    List<Category> categoryList;

    public CategoryAdapter(SQLiteDatabase _db, List<Category> categories) {
        db = _db;
        categoryList = categories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.category_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = categoryList.get(position);
        holder.txvID.setText(String.valueOf(category.getId()));
        holder.categoryName.setText(category.getCategoryName());
        holder.categoryDescription.setText(category.getCategoryDescription());
        holder.categoryNumber.setText(category.getCategoryNumber());

        Bitmap bitmap = BitmapFactory.decodeByteArray(category.getCover(), 0, category.getCover().length);
        holder.imageCover.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return categoryList.size(); // Return the size of the list
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txvID, categoryNumber, categoryName, categoryDescription;
        ImageView imageCover;
        ImageButton ibntnEdit, ibtnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txvID = itemView.findViewById(R.id.txvID);
            categoryNumber = itemView.findViewById(R.id.categoryNumber);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryDescription = itemView.findViewById(R.id.categoryDescription);
            ibntnEdit = itemView.findViewById(R.id.ibtnEdit);
            ibtnDelete = itemView.findViewById(R.id.ibtnDelete);
            imageCover = itemView.findViewById(R.id.imvVCover);

            imageCover.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Create an intent to start the OrderActivity
                    Intent intent = new Intent(imageCover.getContext(), CakeViewActivity.class);

                    // Start the OrderActivity
                    imageCover.getContext().startActivity(intent);


                }
            });
        }
    }
}
