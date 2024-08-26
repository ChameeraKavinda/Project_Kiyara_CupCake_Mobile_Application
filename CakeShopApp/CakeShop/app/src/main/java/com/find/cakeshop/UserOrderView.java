package com.find.cakeshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class UserOrderView extends AppCompatActivity {
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_order_view);
        RecyclerView rcvorder= findViewById(R.id.rcvorder);
        SetDB();
        Cake cake= new Cake();
        List<Cake> cakes= cake.GetCakes(db);
        UserOrderAdapter adapter= new UserOrderAdapter (db,cakes);
        rcvorder.setLayoutManager(new LinearLayoutManager(this));
        rcvorder.setAdapter(adapter);



    }


    private void SetDB()
    {
        try {
            db=openOrCreateDatabase("CakeDB",MODE_PRIVATE,null);
            db.execSQL("Create table " +
                    "if not exists " +
                    "Orders(UserCakeid integer primary key autoincrement " +
                    "      ,userCakeName text,userCakeDes text,totalAmount text,userCakePrice real,cover blob)");





        }
        catch (Exception ex)
        {
            Toast.makeText(getApplicationContext(),ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }


}