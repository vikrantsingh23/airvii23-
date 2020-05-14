package com.example.fly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class flightavailable extends AppCompatActivity {
    TextView origin,destination,date,origin1,destination1,date1;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flightavailable);
        origin = findViewById(R.id.origin9);

        destination = findViewById(R.id.destination9);
        date = findViewById(R.id.time9);
        origin1 = findViewById(R.id.origin10);
        db=FirebaseFirestore.getInstance();
        destination1 = findViewById(R.id.destination10);
        date1 = findViewById(R.id.time10);

        String id = getIntent().getStringExtra("id");


        CollectionReference collectionrefernce = db.collection("flight available");
        collectionrefernce
                .whereEqualTo("id", id)

                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override

                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String date3 = getIntent().getStringExtra("date");
                                if(date3.equals("12/5/2020") ){


                                    origin.setText(document.getString("origin"));
                                    destination.setText(document.getString("destination"));

                                    date.setText(document.getString("time2"));


                                    origin1.setText(document.getString("origin"));
                                    destination1.setText(document.getString("destination"));
                                    date1.setText(document.getString("time3"));

                                }
                             else if(date3.equals("13/5/2020")){

                                    origin.setText(document.getString("origin"));
                                    destination.setText(document.getString("destination"));

                                    date.setText(document.getString("time4"));


                                    origin1.setText(document.getString("origin"));
                                    destination1.setText(document.getString("destination"));
                                    date1.setText(document.getString("time5"));



                                }
                                else if(date3.equals("11/5/2020") ){

                                    origin.setText(document.getString("origin"));
                                    destination.setText(document.getString("destination"));

                                    date.setText(document.getString("time"));


                                    origin1.setText(document.getString("origin"));
                                    destination1.setText(document.getString("destination"));
                                    date1.setText(document.getString("time1"));


                                }
                      else{




                                    AlertDialog.Builder builder = new AlertDialog.Builder(flightavailable.this);


                                    builder.setMessage("No flight available");

                                    builder.setTitle("");


                                    builder.setCancelable(false);

                                    builder.setPositiveButton(
                                            "Ok",
                                            new DialogInterface
                                                    .OnClickListener() {

                                                @Override
                                                public void onClick(DialogInterface dialog,
                                                                    int which) {

                                                    Intent intent;
                                                    intent = new Intent(flightavailable.this,flightstatus.class);

                                                    startActivity(intent);


                                                }
                                            });


                                    AlertDialog alertDialog = builder.create();

                                    alertDialog.show();



                                }




                            }
                        }
                    }
                });








    }
}
