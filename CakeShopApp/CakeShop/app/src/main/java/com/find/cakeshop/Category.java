package com.find.cakeshop;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String categoryNumber;
    private int Id;
    private  String categoryName;
    private String categoryDescription;

    private  byte[] Cover;


    @SuppressLint("SuspiciousIndentation")
    public void setCategoryNumber(String categoryNumber) {
        //if(categoryNumber.length() >= 13)
        this.categoryNumber = categoryNumber;
    }

    public void setId(int id){
        Id = id;
    }

    public void setCategoryName(String categoryName) {
        categoryName = categoryName;
    }

    public void setCategoryDescription(String categoryDescription) {
        categoryDescription = categoryDescription;
    }



    public void setCover(byte[] cover) {
        Cover = cover;
    }






    public int getId() {
        return Id;
    }

    public String getCategoryNumber() {
        return categoryNumber;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }



    public byte[] getCover() {
        return Cover;
    }
    public void Save(SQLiteDatabase db)
    {
        try {
            ContentValues values=new ContentValues();
            values.put("categoryName",categoryName);
            values.put("categoryDescription",categoryDescription);
            values.put("categoryNumber",categoryNumber);
            values.put("cover",Cover);
            db.insert("category",null,values);



        }
        catch (Exception ex){
            throw ex;
        }
    }
    public List<Category> GetCategories(SQLiteDatabase db){
        try
        {
            List<Category>categories=new ArrayList<Category>();
            String query="Select id,categoryName,categoryNumber,categoryDescription,cover from category";
            Cursor cursor=db.rawQuery(query,null);
            if(cursor.moveToFirst())
            {
                do{
                    Category category=new Category ();
                    category.setId(cursor.getInt(0));
                    category.setCategoryName (cursor.getString(1));
                    category.setCategoryNumber (cursor.getString(2));
                    category.setCategoryDescription (cursor.getString(3));
                    category.setCover(cursor.getBlob(4));
                    categories.add(category);

                }while (cursor.moveToNext());

            }
            return categories;


        }
        catch (Exception ex){
            throw ex;
        }
    }
    public void Update(SQLiteDatabase db){
        try {
            ContentValues values=new ContentValues();
            values.put("categoryName",categoryName);
            values.put("categoryDescription",categoryDescription);
            values.put("categoryNumber",categoryNumber);
            values.put("cover",Cover);
            db.update("category",values,"id="+Id,null);



        }
        catch (Exception ex){
            throw ex;
        }
    }
    public void Delete(SQLiteDatabase db) {
        try {

            db.delete("category", "id=" + Id, null);


        } catch (Exception ex) {
            throw ex;
        }
    }

}







