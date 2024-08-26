package com.find.cakeshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class CategoryView extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_view);
        RecyclerView revCategory=findViewById(R.id.revCategory);
        setDB();
        Category category=new Category();
        List<Category>categories=category.GetCategories (db);
        CategoryAdapter adapter=new CategoryAdapter(db,categories);
        revCategory.setLayoutManager(new LinearLayoutManager(this));
        revCategory.setAdapter(adapter);
    }
    private void setDB()
    {
        try{
            db=openOrCreateDatabase("CategoryDB",MODE_PRIVATE,null);
            db.execSQL("Create table " +
                    " if not exists" +
                    " Category(id integer primary key autoincrement" +
                    ",categoryName text,categoryDescription text,categoryNumber text,cover blob)");

        }
        catch (Exception ex)
        {
            Toast.makeText(getApplicationContext(),ex.getMessage(),Toast.LENGTH_LONG).show();
        }

    }
}