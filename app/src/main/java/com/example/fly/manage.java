package com.example.fly;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class manage extends AppCompatActivity {
    Button cancel,modifydetails;

      FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        cancel = findViewById(R.id.cancel);
        modifydetails = findViewById(R.id.modifydetails);
        db= FirebaseFirestore.getInstance();
        modifydetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(manage.this, modify.class));
                finish();

            }
        });





        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Map<String, Object> book = new HashMap<>();

                book.put("name", "            ");
                book.put("password", "         ");
                book.put("email", "            ");
                book.put("phoneno", "          ");
                book.put("seat", "          ");

                db.collection("flight").document("booking")
                        .set(book);

                AlertDialog.Builder builder = new AlertDialog.Builder(manage.this);


                builder.setMessage("Thanks for showing four interest.Your money will be transfer to your bank account within 2 days");

                builder.setTitle("");


                builder.setCancelable(false);

                builder.setPositiveButton(
                        "Ok",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                startActivity(new Intent(manage.this, menu.class));
                                finish();

                            }
                        });


                AlertDialog alertDialog = builder.create();

                alertDialog.show();




                            }
                        });






    }
}
