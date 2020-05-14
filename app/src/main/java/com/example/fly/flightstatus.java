package com.example.fly;




import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
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
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class flightstatus extends AppCompatActivity {


    Spinner spinorigin, spindestination;
    FirebaseFirestore store;
    TextView datetext;
    Calendar c;
    DatePickerDialog picker;
    Button flightstatus;


    // ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flightstatus);


        spinorigin = findViewById(R.id.o);

        spindestination = findViewById(R.id.destination1);
        datetext = findViewById(R.id.date1);


        flightstatus = findViewById(R.id.check);


        datetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day;
                day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                picker = new DatePickerDialog(flightstatus.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int myear, int mmonth, int mdayOfMonth) {

                        datetext.setText(mdayOfMonth + "/" + (mmonth + 1) + "/" + myear);

                    }
                }, day, month, year);
                picker.show();
            }
        });





        store = FirebaseFirestore.getInstance();

        List<String> list = new ArrayList<String>();

        list.add("Mumbai-Chhatrapati shivaji international airport ");
        list.add("Delhi-Indira gandhi international airport");
        list.add("Bhopal-Raja bhoj international airport");
        list.add("Dehli-Indira gandhi international airport");


        ArrayAdapter<String> arrayadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);


        arrayadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinorigin.setAdapter(arrayadapter);


        List<String> list1 = new ArrayList<String>();


        list1.add("Delhi-Indira gandhi international airport");
        list1.add("Chennai-Chennai international airport");
        list1.add("Agra-Kheria airport");
        list1.add("Ahmedabad-Sardar vallabhbhai international airport");
        // Creating adapter for spinner
        ArrayAdapter<String> arrayadapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list1);

        // Drop down layout style - list view with radio button
        arrayadapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spindestination.setAdapter(arrayadapter1);


        flightstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String destination = spindestination.getSelectedItem().toString();
                String origin = spinorigin.getSelectedItem().toString();



                CollectionReference collectionrefernce = store.collection("flight available");
                String date = datetext.getText().toString().trim();

                collectionrefernce
                        .whereEqualTo("origin", origin)
                        .whereEqualTo("destination",destination)

                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {

                                        String date = datetext.getText().toString().trim();




                                        Intent intent;
                                        intent = new Intent(flightstatus.this,flightavailable.class);
                                        intent.putExtra("id", document.getString("id"));

                                        intent.putExtra("date",date);
                                        startActivity(intent);


                                    }
                                } else {
                                    startActivity(new Intent(flightstatus.this, connect.class));
                                    finish();

                                }
                            }
                        });







            }


    });
    }

}



