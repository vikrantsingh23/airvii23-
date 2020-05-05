package com.example.fly;





import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;


import android.app.DatePickerDialog;
import android.app.ProgressDialog;


import android.content.Intent;


import android.view.View;

import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.DatePicker;

import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class booking extends AppCompatActivity {
    private static int i = 1;

    Spinner spinorigin, spindestination, spintime;
    FirebaseFirestore store;

    TextView datetext;
    Calendar c;
    DatePickerDialog picker;
    Button booking;
    ImageView back;

    ProgressDialog progressDialog;
    //private Object str9="10,000 INR";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
      store=FirebaseFirestore.getInstance();

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Booking...");
        spinorigin = findViewById(R.id.spinner1);
        spintime = findViewById(R.id.spinner);
        spindestination = findViewById(R.id.spinner2);
        datetext = findViewById(R.id.datetext);

        booking = findViewById(R.id.button2);
        back = findViewById(R.id.back);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(booking.this, boardingpass.class));





                finish();

            }
        });
        datetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day;
                day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                picker = new DatePickerDialog(booking.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int myear, int mmonth, int mdayOfMonth) {

                        datetext.setText(mdayOfMonth + "/" + (mmonth + 1) + "/" + myear);

                    }
                }, day, month, year);
                picker.show();
            }
        });



        List<String> list2 = new ArrayList<String>();

        list2.add("8:00 AM");
        list2.add("10:00 AM");
        list2.add("4:00 PM");
        list2.add("6:00 PM");
        list2.add("9:00 PM");
        list2.add("11:00 PM");

        // Creating adapter for spinner
        ArrayAdapter<String> arrayadapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list2);

        // Drop down layout style - list view with radio button
        arrayadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spintime.setAdapter(arrayadapter2);


        List<String> list = new ArrayList<String>();


        list.add("Delhi");
        list.add("Goa");
        list.add("Banglore");
        list.add("Gujarat");
        list.add("Assam");
        list.add("Mumbai");

        ArrayAdapter<String> arrayadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);


        arrayadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinorigin.setAdapter(arrayadapter);


        List<String> list1 = new ArrayList<String>();


        list1.add("Goa");
        list1.add("Delhi");
        list1.add("Banglore");
        list1.add("Gujarat");
        list1.add("Assam");
        list1.add("Mumbai");

        // Creating adapter for spinner
        ArrayAdapter<String> arrayadapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list1);


        arrayadapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spindestination.setAdapter(arrayadapter1);


        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



           String str5 = spindestination.getSelectedItem().toString();
                     String str6 = spintime.getSelectedItem().toString();
               String str7 = spinorigin.getSelectedItem().toString();
               String str8 = datetext.getText().toString().trim();


                progressDialog.show();

                Map<String, Object> book1 = new HashMap<>();

            if(str7 =="Goa" && str5 =="Delhi" &&  str6=="10:00 AM")
                {
                    book1.put("origin", str7);
                    book1.put("destination", str5);
                    book1.put("day", "10");
                    book1.put("time", str6);
                book1.put("price","1 INR");

                    store.collection("flight").document("booking" ).set(book1);
                    AlertDialog.Builder builder = new AlertDialog.Builder(booking.this);

                    builder.setMessage("SUCCESSFUL BOOKING");

                    builder.setTitle("");


                    builder.setCancelable(false);

                    builder.setPositiveButton(
                            "Ok",
                            new DialogInterface
                                    .OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    progressDialog.dismiss();
                                    Intent intent     = new Intent(booking.this,gpay.class);
                                    intent.putExtra("price","1");
                                    startActivity(intent);



                                }
                            });

                    AlertDialog alertDialog = builder.create();


                    alertDialog.show();


             }
               else if(str7=="Delhi" && str5 =="Goa" &&  str6=="10:00 AM")
                {

                    book1.put("origin", str7);
                    book1.put("destination", str5);
                    book1.put("day", str8);
                    book1.put("time", str6);
                    book1.put("price","11,000 INR");

                    store.collection("flight").document("booking" ).set(book1);
                    AlertDialog.Builder builder = new AlertDialog.Builder(booking.this);

                    builder.setMessage("SUCCESSFUL BOOKING");

                    builder.setTitle("");


                    builder.setCancelable(false);

                    builder.setPositiveButton(
                            "Ok",
                            new DialogInterface
                                    .OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    progressDialog.dismiss();
                              Intent intent     = new Intent(booking.this,gpay.class);
                                   intent.putExtra("price","11000");
                                    startActivity(intent);

                                }
                            });

                    AlertDialog alertDialog = builder.create();


                    alertDialog.show();


                }
              else   if(str7=="Mumbai" && str5 =="Delhi" &&  str6 =="8:00 AM")
                {

                    book1.put("origin", str7);
                    book1.put("destination", str5);
                    book1.put("day", str8);
                    book1.put("time", str6);
                    book1.put("price","9,000 INR");

                    store.collection("flight").document("booking").set(book1);
                    AlertDialog.Builder builder = new AlertDialog.Builder(booking.this);

                    builder.setMessage("SUCCESSFUL BOOKING");

                    builder.setTitle("");


                    builder.setCancelable(false);

                    builder.setPositiveButton(
                            "Ok",
                            new DialogInterface
                                    .OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    progressDialog.dismiss();
                                    Intent intent     = new Intent(booking.this,gpay.class);
                                    intent.putExtra("price","9000");
                                    startActivity(intent);



                                }
                            });

                    AlertDialog alertDialog = builder.create();


                    alertDialog.show();

                }
                   else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(booking.this);

                    builder.setMessage("FLIGHT NOT AVIALABLE");


                    builder.setTitle("");


                    builder.setCancelable(false);

                    builder.setPositiveButton(
                            "Ok",
                            new DialogInterface
                                    .OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    progressDialog.dismiss();
                                    startActivity(new Intent(booking.this, booking.class));
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




