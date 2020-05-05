package com.example.fly;




import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class flightstatus extends AppCompatActivity {


    Spinner spinorigin, spindestination, spintime;
    FirebaseFirestore store;



    Button flightstatus;
    ImageView back;

    // ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flightstatus);


        spinorigin = findViewById(R.id.origin);

        spindestination = findViewById(R.id.destination);


        back = findViewById(R.id.back);
        flightstatus = findViewById(R.id.check);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(flightstatus.this, menu.class));
                finish();

            }
        });



        store = FirebaseFirestore.getInstance();

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

        // Drop down layout style - list view with radio button
        arrayadapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spindestination.setAdapter(arrayadapter1);


        flightstatus.setOnClickListener(new View.OnClickListener(){


        @Override
        public void onClick (View v){
            DocumentReference docRef = store.collection("flight1").document("booking");
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                             String origin=document.getString("origin");
                            String destination=document.getString("destination");
                            String time =document.getString("time");
                            AlertDialog.Builder builder = new AlertDialog.Builder(flightstatus.this);

                            builder.setMessage("origin" + ":" + origin + "\n "
                                    + "destination" + ":" + destination + " "
                                    + "time" + ":" + time);


                            // Set Alert Title
                            builder.setTitle("");


                            builder.setCancelable(false);

                            builder.setPositiveButton(
                                    "Ok",
                                    new DialogInterface
                                            .OnClickListener() {

                                        @Override
                                        public void onClick(DialogInterface dialog,
                                                            int which) {
                                            startActivity(new Intent(flightstatus.this, menu.class));
                                            finish();


                                        }
                                    });


                            // Create the Alert dialog
                            AlertDialog alertDialog = builder.create();


                            alertDialog.show();


                        }


                        }

                }
            });


    }


    });
    }

}



