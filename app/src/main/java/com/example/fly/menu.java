package com.example.fly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;


public class menu extends AppCompatActivity {
    TextView origin, destination, date, time, price, origin1, destination1, date1, time1, price1;
    Button card1, card2;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        origin = findViewById(R.id.origin5);
        destination = findViewById(R.id.des5);
        date = findViewById(R.id.date5);
        time = findViewById(R.id.time5);
        price = findViewById(R.id.amount5);
        origin1 = findViewById(R.id.origin6);
        destination1 = findViewById(R.id.des6);
        date1 = findViewById(R.id.date6);
        time1 = findViewById(R.id.time6);
        price1 = findViewById(R.id.amount6);
        card1 = findViewById(R.id.book);
        card2 = findViewById(R.id.book1);
        db = FirebaseFirestore.getInstance();







       String id= getIntent().getStringExtra("id");
String datetext = getIntent().getStringExtra("date");

if(datetext.equals("11/5/2020")) {

    CollectionReference collectionreference = db.collection("flight available");
    collectionreference
            .whereEqualTo("id", id)
            .get()
            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {

                            String datetext = getIntent().getStringExtra("date");
                            String diffclass = getIntent().getStringExtra("classs");

                            origin.setText(document.getString("origin"));

                            destination.setText(document.getString("destination"));


                            origin1.setText(document.getString("origin"));
                            destination1.setText(document.getString("destination"));

                            time1.setText(document.getString("time1"));
                            time.setText(document.getString("time"));
                            date1.setText(datetext);
                            date.setText(datetext);

                            if (diffclass.equals("Economic class")) {

                                price.setText(document.getString("economicprice"));
                                price1.setText(document.getString("economicprice"));
                            }

                            if (diffclass.equals("Business class")) {

                                price.setText(document.getString("businessprice"));
                                price1.setText(document.getString("businessprice"));
                            }
                            if (diffclass.equals("First class")) {

                                price.setText(document.getString("firstclassprice"));
                                price1.setText(document.getString("firstclassprice"));
                            }


                        }


                    }
                }
            });


    card1.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String origin = getIntent().getStringExtra("origin");

                    String destination = getIntent().getStringExtra("destination");

                    String date = getIntent().getStringExtra("date");


                    String class1 = getIntent().getStringExtra("classs");


                    String way = getIntent().getStringExtra("way");

                    String children = getIntent().getStringExtra("children");

                    String adult = getIntent().getStringExtra("adult");

                    String infants = getIntent().getStringExtra("infants");

                    String email = getIntent().getStringExtra("email");
                    String member = getIntent().getStringExtra("member");

                    String price1 = price.getText().toString().trim();


                    String time1 = time.getText().toString().trim();
                    Map<String, Object> book = new HashMap<>();

                    book.put("origin", origin);
                    book.put("destination", destination);
                    book.put("day", date);
                    book.put("price", price1);
                    book.put("class", class1);
                    book.put("way", way);
                    book.put("adult", adult);
                    book.put("children", children);
                    book.put("infants", infants);

                    book.put("time", time1);


                    db.collection("registration").document("details " + "->" + email).
                            set(book);


                    Intent intent = new Intent(menu.this, gpay.class);

                    intent.putExtra("amount", price1);
                    intent.putExtra("email", email);
                    intent.putExtra("members", member);
                    startActivity(intent);


                }
            });
    card2.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String origin = getIntent().getStringExtra("origin");

                    String destination = getIntent().getStringExtra("destination");

                    String date = getIntent().getStringExtra("date");


                    String class1 = getIntent().getStringExtra("classs");


                    String way = getIntent().getStringExtra("way");

                    String children = getIntent().getStringExtra("children");

                    String adult = getIntent().getStringExtra("adult");

                    String infants = getIntent().getStringExtra("infants");

                    String email = getIntent().getStringExtra("email");
                    String member = getIntent().getStringExtra("member");

                    String price2 = price1.getText().toString().trim();


                    String time2 = time1.getText().toString().trim();
                    Map<String, Object> book = new HashMap<>();

                    book.put("origin", origin);
                    book.put("destination", destination);
                    book.put("day", date);
                    book.put("price", price2);
                    book.put("class", class1);
                    book.put("way", way);
                    book.put("adult", adult);
                    book.put("children", children);
                    book.put("infants", infants);

                    book.put("time", time2);


                    db.collection("registration").document("details " + "->" + email).
                            set(book);


                    Intent intent = new Intent(menu.this, gpay.class);

                    intent.putExtra("amount", price2);
                    intent.putExtra("email", email);
                    intent.putExtra("members", member);
                    startActivity(intent);


                }
            });


}
        if(datetext.equals("12/5/2020")) {

            CollectionReference collectionreference = db.collection("flight available");
            collectionreference
                    .whereEqualTo("id", id)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {

                                    String datetext = getIntent().getStringExtra("date");
                                    String diffclass = getIntent().getStringExtra("classs");

                                    origin.setText(document.getString("origin"));

                                    destination.setText(document.getString("destination"));


                                    origin1.setText(document.getString("origin"));
                                    destination1.setText(document.getString("destination"));

                                    time1.setText(document.getString("time3"));
                                    time.setText(document.getString("time2"));
                                    date1.setText(datetext);
                                    date.setText(datetext);

                                    if (diffclass.equals("Economic class")) {

                                        price.setText(document.getString("economicprice"));
                                        price1.setText(document.getString("economicprice"));
                                    }

                                    if (diffclass.equals("Business class")) {

                                        price.setText(document.getString("businessprice"));
                                        price1.setText(document.getString("businessprice"));
                                    }
                                    if (diffclass.equals("First class")) {

                                        price.setText(document.getString("firstclassprice"));
                                        price1.setText(document.getString("firstclassprice"));
                                    }


                                }


                            }
                        }
                    });


            card1.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            String origin = getIntent().getStringExtra("origin");

                            String destination = getIntent().getStringExtra("destination");

                            String date = getIntent().getStringExtra("date");


                            String class1 = getIntent().getStringExtra("classs");


                            String way = getIntent().getStringExtra("way");

                            String children = getIntent().getStringExtra("children");

                            String adult = getIntent().getStringExtra("adult");

                            String infants = getIntent().getStringExtra("infants");

                            String email = getIntent().getStringExtra("email");
                            String member = getIntent().getStringExtra("member");

                            String price1 = price.getText().toString().trim();


                            String time1 = time.getText().toString().trim();
                            Map<String, Object> book = new HashMap<>();

                            book.put("origin", origin);
                            book.put("destination", destination);
                            book.put("day", date);
                            book.put("price", price1);
                            book.put("class", class1);
                            book.put("way", way);
                            book.put("adult", adult);
                            book.put("children", children);
                            book.put("infants", infants);

                            book.put("time", time1);


                            db.collection("registration").document("details " + "->" + email).
                                    set(book);


                            Intent intent = new Intent(menu.this, gpay.class);

                            intent.putExtra("amount", price1);
                            intent.putExtra("email", email);
                            intent.putExtra("members", member);
                            startActivity(intent);


                        }
                    });
            card2.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            String origin = getIntent().getStringExtra("origin");

                            String destination = getIntent().getStringExtra("destination");

                            String date = getIntent().getStringExtra("date");


                            String class1 = getIntent().getStringExtra("classs");


                            String way = getIntent().getStringExtra("way");

                            String children = getIntent().getStringExtra("children");

                            String adult = getIntent().getStringExtra("adult");

                            String infants = getIntent().getStringExtra("infants");

                            String email = getIntent().getStringExtra("email");
                            String member = getIntent().getStringExtra("member");

                            String price2 = price1.getText().toString().trim();


                            String time2 = time1.getText().toString().trim();
                            Map<String, Object> book = new HashMap<>();

                            book.put("origin", origin);
                            book.put("destination", destination);
                            book.put("day", date);
                            book.put("price", price2);
                            book.put("class", class1);
                            book.put("way", way);
                            book.put("adult", adult);
                            book.put("children", children);
                            book.put("infants", infants);

                            book.put("time", time2);


                            db.collection("registration").document("details " + "->" + email).
                                    set(book);


                            Intent intent = new Intent(menu.this, gpay.class);

                            intent.putExtra("amount", price2);
                            intent.putExtra("email", email);
                            intent.putExtra("members", member);
                            startActivity(intent);


                        }
                    });


        }
        if(datetext.equals("13/5/2020")) {

            CollectionReference collectionreference = db.collection("flight available");
            collectionreference
                    .whereEqualTo("id", id)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {

                                    String datetext = getIntent().getStringExtra("date");
                                    String diffclass = getIntent().getStringExtra("classs");

                                    origin.setText(document.getString("origin"));

                                    destination.setText(document.getString("destination"));


                                    origin1.setText(document.getString("origin"));
                                    destination1.setText(document.getString("destination"));

                                    time1.setText(document.getString("time5"));
                                    time.setText(document.getString("time4"));
                                    date1.setText(datetext);
                                    date.setText(datetext);

                                    if (diffclass.equals("Economic class")) {

                                        price.setText(document.getString("economicprice"));
                                        price1.setText(document.getString("economicprice"));
                                    }

                                    if (diffclass.equals("Business class")) {

                                        price.setText(document.getString("businessprice"));
                                        price1.setText(document.getString("businessprice"));
                                    }
                                    if (diffclass.equals("First class")) {

                                        price.setText(document.getString("firstclassprice"));
                                        price1.setText(document.getString("firstclassprice"));
                                    }


                                }


                            }
                        }
                    });


            card1.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            String origin = getIntent().getStringExtra("origin");

                            String destination = getIntent().getStringExtra("destination");

                            String date = getIntent().getStringExtra("date");


                            String class1 = getIntent().getStringExtra("classs");


                            String way = getIntent().getStringExtra("way");

                            String children = getIntent().getStringExtra("children");

                            String adult = getIntent().getStringExtra("adult");

                            String infants = getIntent().getStringExtra("infants");

                            String email = getIntent().getStringExtra("email");
                            String member = getIntent().getStringExtra("member");

                            String price1 = price.getText().toString().trim();


                            String time1 = time.getText().toString().trim();
                            Map<String, Object> book = new HashMap<>();

                            book.put("origin", origin);
                            book.put("destination", destination);
                            book.put("day", date);
                            book.put("price", price1);
                            book.put("class", class1);
                            book.put("way", way);
                            book.put("adult", adult);
                            book.put("children", children);
                            book.put("infants", infants);

                            book.put("time", time1);


                            db.collection("registration").document("details " + "->" + email).
                                    set(book);


                            Intent intent = new Intent(menu.this, gpay.class);

                            intent.putExtra("amount", price1);
                            intent.putExtra("email", email);
                            intent.putExtra("members", member);
                            startActivity(intent);


                        }
                    });
            card2.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            String origin = getIntent().getStringExtra("origin");

                            String destination = getIntent().getStringExtra("destination");

                            String date = getIntent().getStringExtra("date");


                            String class1 = getIntent().getStringExtra("classs");


                            String way = getIntent().getStringExtra("way");

                            String children = getIntent().getStringExtra("children");

                            String adult = getIntent().getStringExtra("adult");

                            String infants = getIntent().getStringExtra("infants");

                            String email = getIntent().getStringExtra("email");
                            String member = getIntent().getStringExtra("member");

                            String price2 = price1.getText().toString().trim();


                            String time2 = time1.getText().toString().trim();
                            Map<String, Object> book = new HashMap<>();

                            book.put("origin", origin);
                            book.put("destination", destination);
                            book.put("day", date);
                            book.put("price", price2);
                            book.put("class", class1);
                            book.put("way", way);
                            book.put("adult", adult);
                            book.put("children", children);
                            book.put("infants", infants);

                            book.put("time", time2);


                            db.collection("registration").document("details " + "->" + email).
                                    set(book);


                            Intent intent = new Intent(menu.this, gpay.class);

                            intent.putExtra("amount", price2);
                            intent.putExtra("email", email);
                            intent.putExtra("members", member);
                            startActivity(intent);


                        }
                    });


        }
    }
}