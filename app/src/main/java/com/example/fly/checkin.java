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

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class checkin extends AppCompatActivity {
     FirebaseFirestore store;

// static int count1=0;
  //  static int count2=0;
   Button one,proceed,two,three;
     // three, four, five, six, seven, eight, nine, ten, eleven, proceed, twelve;
     //ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkin);
    //    store = FirebaseFirestore.getInstance();
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
       // progressDialog = new ProgressDialog(this);
        //progressDialog.setMessage("checkin...");
        three = findViewById(R.id.three);
      /*  four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        ten = findViewById(R.id.ten);
        eleven = findViewById(R.id.eleven);
        twelve = findViewById(R.id.twelve);*/
        proceed = findViewById(R.id.proceed);
        store = FirebaseFirestore.getInstance();


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.one) {


                    Map<String, Object> book = new HashMap<>();

                    book.put("seat", "1");

                    store.collection("flight").document("booking").set(book);
                    AlertDialog.Builder builder = new AlertDialog.Builder(checkin.this);


                    builder.setMessage("confirm seat number 1");

                    builder.setTitle("");


                    builder.setCancelable(false);

                    builder.setPositiveButton(
                            "Ok",
                            new DialogInterface
                                    .OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {

                                    AlertDialog.Builder builder = new AlertDialog.Builder(checkin.this);


                                    builder.setMessage("checkin done.");

                                    builder.setTitle("");


                                    builder.setCancelable(false);

                                    builder.setPositiveButton(
                                            "Ok",
                                            new DialogInterface
                                                    .OnClickListener() {

                                                @Override
                                                public void onClick(DialogInterface dialog,
                                                                    int which) {

                                                    startActivity(new Intent(checkin.this, boardingpass.class));
                                                    finish();

                                                }
                                            });


                                    AlertDialog alertDialog = builder.create();

                                    alertDialog.show();


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


                    Map<String, Object> book = new HashMap<>();

                    book.put("seat", "2");

                    store.collection("flight").document("booking").set(book);
                    AlertDialog.Builder builder = new AlertDialog.Builder(checkin.this);


                    builder.setMessage("confirm seat number 2");

                    builder.setTitle("");


                    builder.setCancelable(false);

                    builder.setPositiveButton(
                            "Ok",
                            new DialogInterface
                                    .OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {

                                    AlertDialog.Builder builder = new AlertDialog.Builder(checkin.this);


                                    builder.setMessage("checkin done.");

                                    builder.setTitle("");


                                    builder.setCancelable(false);

                                    builder.setPositiveButton(
                                            "Ok",
                                            new DialogInterface
                                                    .OnClickListener() {

                                                @Override
                                                public void onClick(DialogInterface dialog,
                                                                    int which) {

                                                    startActivity(new Intent(checkin.this, boardingpass.class));
                                                    finish();

                                                }
                                            });


                                    AlertDialog alertDialog = builder.create();

                                    alertDialog.show();


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


                    Map<String, Object> book = new HashMap<>();

                    book.put("seat", "3");

                    store.collection("flight").document("booking").set(book);
                    AlertDialog.Builder builder = new AlertDialog.Builder(checkin.this);


                    builder.setMessage("confirm seat number 3");

                    builder.setTitle("");


                    builder.setCancelable(false);

                    builder.setPositiveButton(
                            "Ok",
                            new DialogInterface
                                    .OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {

                                    AlertDialog.Builder builder = new AlertDialog.Builder(checkin.this);


                                    builder.setMessage("checkin done.");

                                    builder.setTitle("");


                                    builder.setCancelable(false);

                                    builder.setPositiveButton(
                                            "Ok",
                                            new DialogInterface
                                                    .OnClickListener() {

                                                @Override
                                                public void onClick(DialogInterface dialog,
                                                                    int which) {

                                                    startActivity(new Intent(checkin.this, boardingpass.class));
                                                    finish();

                                                }
                                            });


                                    AlertDialog alertDialog = builder.create();

                                    alertDialog.show();


                                }
                            });


                    AlertDialog alertDialog = builder.create();

                    alertDialog.show();



                }
            }
        });




















    }
}
