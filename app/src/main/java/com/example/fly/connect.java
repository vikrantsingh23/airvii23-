package com.example.fly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class connect extends AppCompatActivity {
FirebaseFirestore store;

 Button search,flight,contact,about,modify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        search= findViewById(R.id.searchflight);
  store=FirebaseFirestore.getInstance();
        flight= findViewById(R.id.flightstatus);
        contact= findViewById(R.id.contactus);
        about= findViewById(R.id.aboutus);

        modify= findViewById(R.id.modify);


            search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=  getIntent().getStringExtra("email");
                Intent intent;
                intent = new Intent(connect.this,search.class);
                intent.putExtra("email", email);
                startActivity(intent);

            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String email=  getIntent().getStringExtra("email");
                Intent intent;
                intent = new Intent(connect.this,contactus.class);
                intent.putExtra("email", email);
                startActivity(intent);

            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(connect.this, aboutus.class));
                finish();

            }
        });
        flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=  getIntent().getStringExtra("email");
                Intent intent;
                intent = new Intent(connect.this,flightstatus.class);
                intent.putExtra("email", email);
                startActivity(intent);


            }
        });
        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(connect.this, modify.class));
                finish();

            }
        });





    }
}
