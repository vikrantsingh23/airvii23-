package com.example.fly;




import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;




import androidx.appcompat.app.AlertDialog;

import android.app.ProgressDialog;

import android.content.DialogInterface;
import android.content.Intent;


import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class contactus extends AppCompatActivity {
     FirebaseFirestore store;
    EditText query;
    Button submit;
    ImageView back;
    ProgressDialog progressDialog;

    static  int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        query = findViewById(R.id.query1);
        submit = findViewById(R.id.button1);





        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Sending..");

        store = FirebaseFirestore.getInstance();

        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {




                        progressDialog.show();


                        Map<String, Object> book = new HashMap<>();
                        String email=  getIntent().getStringExtra("email");

                        String str = query.getText().toString().trim();



                        book.put("query", str);


                        store.collection("registration").document("details"+"->"+email)
                                .set(book);

                        progressDialog.dismiss();
                        AlertDialog.Builder builder = new AlertDialog.Builder(contactus.this);


                        builder.setMessage("Thank you for sharing your views ");


                        builder.setTitle("");


                        builder.setCancelable(false);

                        builder.setPositiveButton(
                                "Ok",
                                new DialogInterface
                                        .OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        startActivity(new Intent(contactus.this, search.class));
                                        finish();


                                    }
                                });


                        AlertDialog alertDialog = builder.create();


                        alertDialog.show();


                        progressDialog.dismiss();
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(contactus.this);


                        builder1.setMessage("Error while sending,try again...");

                        builder1.setTitle("");


                        builder1.setCancelable(false);

                        builder1.setNegativeButton(
                                "Ok",
                                new DialogInterface
                                        .OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which) {

                                        dialog.cancel();

                                    }
                                });


                        AlertDialog alertDialog1 = builder.create();


                        alertDialog1.show();


                    }


                });










    }
}








