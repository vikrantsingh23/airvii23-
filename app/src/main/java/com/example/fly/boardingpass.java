package com.example.fly;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class boardingpass extends AppCompatActivity {
      FirebaseFirestore db;

    Button screen;
    TextView name,origin,destination,date,boardingtime,seat,cla,flightno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boardingpass);
        db = FirebaseFirestore.getInstance();

        name = findViewById(R.id.name);
        origin = findViewById(R.id.o);
        destination = findViewById(R.id.destination1);
        date = findViewById(R.id.date1);
        cla= findViewById(R.id.class1);
        flightno= findViewById(R.id.flightno);

        date = findViewById(R.id.date1);
        boardingtime = findViewById(R.id.boardingtime);
        seat = findViewById(R.id.seat);

        String email = getIntent().getStringExtra("email");
        //String origin2 = getIntent().getStringExtra("origin");
        //String destination2 = getIntent().getStringExtra("destination");

//        String time= getIntent().getStringExtra("time");
        CollectionReference collectionreference = db.collection("registration");
        collectionreference
                .whereEqualTo("email", email)

                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {


                                String origin1 = getIntent().getStringExtra("origin");
                                String destination1 = getIntent().getStringExtra("destination");

                                origin.setText(origin1);

                                destination.setText(destination1);

                                String date1 = document.getString("day");
                                date.setText(date1);
                                String time1 = document.getString("time");
                                boardingtime.setText(time1);
                                String seat1 = document.getString("seat");
                                seat.setText(seat1);

                                String name1 = document.getString("name");
                                name.setText(name1);


                                String cla1 = document.getString("class");
                                cla.setText(cla1);


                            }
                        }

                    }

                });

        String origin = getIntent().getStringExtra("origin");
        String destination = getIntent().getStringExtra("destination");

        CollectionReference collectionreference1 = db.collection("flight avilable");
        collectionreference1
                .whereEqualTo("origin", origin).
        whereEqualTo("destination", destination)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {


                                String flightno1 = document.getString("flightno");
                                flightno.setText(flightno1);

                            }
                        }
                    }
                });





    }
}
