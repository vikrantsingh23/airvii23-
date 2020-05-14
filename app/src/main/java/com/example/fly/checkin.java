package com.example.fly;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static java.util.logging.Logger.getGlobal;
import static java.util.logging.Logger.global;

public class checkin extends AppCompatActivity {
    FirebaseFirestore store;


    ImageView one, two, three, four;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkin);
        store = FirebaseFirestore.getInstance();
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);

        three = findViewById(R.id.three);
        four = findViewById(R.id.four);


        store = FirebaseFirestore.getInstance();




        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.one) {


                    AlertDialog.Builder builder = new AlertDialog.Builder(checkin.this);


                    builder.setMessage("confirm seat number 1-A");

                    builder.setTitle("");


                    builder.setCancelable(false);

                    builder.setPositiveButton(
                            "Ok",
                            new DialogInterface
                                    .OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {

                                    String email = getIntent().getStringExtra("email");

                                    Map<String, Object> book = new HashMap<>();

                                    book.put("seat[0]", " 1-A");
                                    store.collection("registration").document("details "+"->"+email).
                                            set(book);
                                   Intent intent;
                                    intent = new Intent(checkin.this,boardingpass.class);

                                    intent.putExtra("email", email);
                                    startActivity(intent);


                                }
                            });


                    builder.setCancelable(false);

                    builder.setNegativeButton(
                            "No",
                            new DialogInterface
                                    .OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    startActivity(new Intent(checkin.this, checkin.class));
                                    finish();

                                }
                            });


                    AlertDialog alertDialog = builder.create();

                    alertDialog.show();


                }
            }
        });


        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.two) {


                    AlertDialog.Builder builder = new AlertDialog.Builder(checkin.this);


                    builder.setMessage("confirm seat number 1-B");

                    builder.setTitle("");


                    builder.setCancelable(false);

                    builder.setPositiveButton(
                            "Ok",
                            new DialogInterface
                                    .OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {



                                    String email = getIntent().getStringExtra("email");




                                    Map<String, Object> book = new HashMap<>();

                                    book.put("seat[1]", " 1-B");

                                    store.collection("registration").document("details "+"->"+email).
                                            set(book);
                                    Intent intent;
                                    intent = new Intent(checkin.this,boardingpass.class);
                                    intent.putExtra("email", email);

                                    startActivity(intent);


                                }
                            });

                    builder.setCancelable(false);

                    builder.setNegativeButton(
                            "No",
                            new DialogInterface
                                    .OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    startActivity(new Intent(checkin.this, checkin.class));
                                    finish();

                                }
                            });


                    AlertDialog alertDialog = builder.create();

                    alertDialog.show();


                }
            }
        });


        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.three) {


                    AlertDialog.Builder builder = new AlertDialog.Builder(checkin.this);


                    builder.setMessage("confirm seat number 2-A");

                    builder.setTitle("");


                    builder.setCancelable(false);

                    builder.setPositiveButton(
                            "Ok",
                            new DialogInterface
                                    .OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {

                                    String email = getIntent().getStringExtra("email");
                                    Map<String, Object> book = new HashMap<>();

                                    book.put("seat[2]", " 2-A");

                                    store.collection("registration").document("details "+"->"+email).
                                            set(book);
                                    Intent intent;
                                    intent = new Intent(checkin.this,boardingpass.class);
                                    intent.putExtra("email", email);

                                    startActivity(intent);

                                }
                            });


                    builder.setCancelable(false);

                    builder.setNegativeButton(
                            "No",
                            new DialogInterface
                                    .OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    startActivity(new Intent(checkin.this, checkin.class));
                                    finish();

                                }
                            });


                    AlertDialog alertDialog = builder.create();

                    alertDialog.show();


                }
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.four) {


                    AlertDialog.Builder builder = new AlertDialog.Builder(checkin.this);


                    builder.setMessage("confirm seat number 2-B");

                    builder.setTitle("");


                    builder.setCancelable(false);

                    builder.setPositiveButton(
                            "Ok",
                            new DialogInterface
                                    .OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {

                                    String email = getIntent().getStringExtra("email");
                                    Map<String, Object> book = new HashMap<>();

                                    book.put("seat[3]", " 2-B");

                                    store.collection("registration").document("details "+"->"+email).
                                            set(book);

                                    Intent intent;
                                    intent = new Intent(checkin.this,boardingpass.class);
                                    intent.putExtra("email", email);

                                    startActivity(intent);

                                }
                            });


                    builder.setCancelable(false);

                    builder.setNegativeButton(
                            "No",
                            new DialogInterface
                                    .OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    startActivity(new Intent(checkin.this, checkin.class));
                                    finish();

                                }
                            });


                    AlertDialog alertDialog = builder.create();

                    alertDialog.show();


                }
            }
        });
    }

}

