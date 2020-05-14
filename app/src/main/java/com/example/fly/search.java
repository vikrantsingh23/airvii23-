package com.example.fly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;


import android.app.DatePickerDialog;
import android.app.ProgressDialog;


import android.view.View;

import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.DatePicker;

import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;



public class search extends AppCompatActivity {
    private static int i = 1;

    Spinner spinorigin, spindestination,adult,children,infants,way,class1;
    FirebaseFirestore store;
    TextView datetext;
    Calendar c;
    DatePickerDialog picker;
    Button search;

    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        store=FirebaseFirestore.getInstance();

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Searching...");
        spinorigin = findViewById(R.id.o);

        spindestination = findViewById(R.id.destination1);
        datetext = findViewById(R.id.date1);
      ;
       adult= findViewById(R.id.adult);
        children= findViewById(R.id.children);
        infants= findViewById(R.id.infants);
        way= findViewById(R.id.way2);
        class1= findViewById(R.id.class1);
        search = findViewById(R.id.search);

        datetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day;
                day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                picker = new DatePickerDialog(search.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int myear, int mmonth, int mdayOfMonth) {

                        datetext.setText(mdayOfMonth + "/" + (mmonth + 1) + "/" + myear);

                    }
                }, day, month, year);
                picker.show();
            }
        });






        List<String> list = new ArrayList<String>();


        list.add("Mumbai-Chhatrapati shivaji international airport ");
        list.add("Delhi-Indira gandhi international airport");
        list.add("Bhopal-Raja bhoj international airport");
        list.add("Dehli-Indira gandhi international airport");

        ArrayAdapter<String> arrayadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);


        arrayadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinorigin.setAdapter(arrayadapter);


        List<String> list1 = new ArrayList<String>();


        list1.add("Delhi-Indira gandhi international airport");
        list1.add("Chennai-Chennai international airport");
        list1.add("Agra-Kheria airport");
        list1.add("Ahmedabad-Sardar vallabhbhai international airport");


        // Creating adapter for spinner
        ArrayAdapter<String> arrayadapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list1);


        arrayadapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spindestination.setAdapter(arrayadapter1);



       List<String> list3 = new ArrayList<String>();


        list3.add("0");
        list3.add("1");
        list3.add("2");
        list3.add("3");
        list3.add("4");



        ArrayAdapter<String> arrayadapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list3);


        arrayadapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adult.setAdapter(arrayadapter3);

        List<String> list4= new ArrayList<String>();


        list4.add("0");
        list4.add("1");
        list4.add("2");
        list4.add("3");
        list4.add("4");



        ArrayAdapter<String> arrayadapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list4);


        arrayadapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        children.setAdapter(arrayadapter4);
        List<String> list5 = new ArrayList<String>();


        list5.add("0");
        list5.add("1");
        list5.add("2");
        list5.add("3");
        list5.add("4");



        ArrayAdapter<String> arrayadapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list5);


        arrayadapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        infants.setAdapter(arrayadapter5);

        List<String> list6 = new ArrayList<String>();


        list6.add("one way");
        list6.add("two way");




        ArrayAdapter<String> arrayadapter6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list6);


        arrayadapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        way.setAdapter(arrayadapter6);



        List<String> list7 = new ArrayList<String>();


        list7.add("Economy class");
        list7.add("Business class");
        list7.add("First class");





        ArrayAdapter<String> arrayadapter7= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list7);


        arrayadapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        class1.setAdapter(arrayadapter7);




        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String destination = spindestination.getSelectedItem().toString();
                String origin = spinorigin.getSelectedItem().toString();


                CollectionReference collectionrefernce = store.collection("flight available");

                collectionrefernce
                        .whereEqualTo("origin", origin)
                        .whereEqualTo("destination", destination)

                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        String email = getIntent().getStringExtra("email");
                                        String date = datetext.getText().toString().trim();
                                        String adult1 = adult.getSelectedItem().toString();

                                        String children1 = children.getSelectedItem().toString();

                                        String way1 = way.getSelectedItem().toString();
                                        String class2 = class1.getSelectedItem().toString();
                                        String infants1 = infants.getSelectedItem().toString();
                                            int adult2=Integer.parseInt(adult1);
                                        int children2=Integer.parseInt(children1);
                                        int  member=adult2+children2;
                                        String members= String.valueOf(member);


                                        Intent intent;
                                        intent = new Intent(search.this, menu.class);
                                        intent.putExtra("id", document.getString("id"));
                                        intent.putExtra("email", email);
                                        intent.putExtra("origin", document.getString("origin"));
                                        intent.putExtra("destination", document.getString("destination"));
                                        intent.putExtra("date", date);
                                        intent.putExtra("member", members);
                                        intent.putExtra("price", document.getString("price"));
                                        intent.putExtra("adult", adult1);
                                        intent.putExtra("children", children1);
                                        intent.putExtra("infants", infants1);
                                        intent.putExtra("classs", class2);
                                        intent.putExtra("way", way1);
                                        startActivity(intent);


                                    }

                                }
                            }
                        });

            }
        });
            }


        }