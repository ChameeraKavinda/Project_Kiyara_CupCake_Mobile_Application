package com.find.cakeshop;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class CategoryActivity extends AppCompatActivity {

    EditText categoryNumber,categoryName,categoryDescription;
    Button btnadd, btnupdate,btnvisite;
    ImageButton ibtncover;
    ImageView imvcover;

    SQLiteDatabase db;
    Bitmap pic;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        categoryNumber = findViewById(R.id.categoryNU);
        categoryName = findViewById(R.id.categoryNa);
        categoryDescription = findViewById(R.id.categoryDes);
        btnadd = findViewById(R.id.btnadd);
        btnupdate = findViewById(R.id.btnupdate);
        btnvisite = findViewById(R.id.btnvisite);
        ibtncover=findViewById(R.id.ibtncover);
        imvcover = findViewById(R.id.imvcover);

        setDB();
        ActivityResultLauncher launcher1=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        Intent intent=o.getData();
                        pic=(Bitmap) intent.getExtras().get("data");
                        imvcover.setImageBitmap(pic);
                    }
                }
        );

        ActivityResultLauncher launcher2 = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {

                        Intent intent = o.getData();
                        Uri uri = intent.getData();
                        imvcover.setImageURI(uri);
                    }
                });
        ibtncover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ibtncover.getContext());
                builder.setMessage("Please select the option you wish to use !");
                builder.setTitle("Select a category image");
                builder.setPositiveButton("Use the camera",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface DialogInterface, int i) {
                                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                launcher1.launch(intent);
                            }
                        });
                builder.setNegativeButton("Use the gallery",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface DialogInterface, int i) {
                                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                                intent.setType("image/");
                                launcher2.launch(intent);
                            }
                        });
                AlertDialog dialog =  builder.create();
                dialog.show();//View the picture option.

            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Category category = new Category ();
                    category.setCategoryName (categoryName.getText().toString());
                    category.setCategoryNumber (categoryNumber.getText().toString());
                    category.setCategoryDescription (categoryDescription.getText().toString());
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    pic.compress(Bitmap.CompressFormat.JPEG, 80, stream);
                    byte[] cover = stream.toByteArray();
                    category.setCover(cover);

                    category.Save(db);
                    Toast.makeText(getApplicationContext(),
                            "New Category added", Toast.LENGTH_LONG).show();
                }
                catch (Exception ex)
                {
                    Toast.makeText(getApplicationContext(),ex.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
        btnvisite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), CategoryView.class);
                Toast.makeText(getApplicationContext(), "Category View Successful", Toast.LENGTH_LONG).show();

                startActivity(intent);

            }
        });
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Category category = new Category();
                    category.setId(Integer.parseInt(categoryNumber.getText().toString())); // Assuming categoryNumber is the ID
                    category.setCategoryName(categoryName.getText().toString());
                    category.setCategoryNumber(categoryNumber.getText().toString());
                    category.setCategoryDescription(categoryDescription.getText().toString());
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    pic.compress(Bitmap.CompressFormat.JPEG, 80, stream);
                    byte[] cover = stream.toByteArray();
                    category.setCover(cover);

                    // Update the category in the database
                    category.Update(db);

                    Toast.makeText(getApplicationContext(), "Category updated", Toast.LENGTH_LONG).show();
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });



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