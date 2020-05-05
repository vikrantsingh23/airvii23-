package com.example.fly;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;



import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("ALL")
public  class register1 extends AppCompatActivity {

    static int i = 1;

    EditText nameview, emailview, passwordview, phoneNumberview;

    ImageView back;
    Button register;

    ProgressDialog progressDialog;

    private FirebaseAuth mAuth;
    FirebaseFirestore store;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameview = findViewById(R.id.name);

        emailview = findViewById(R.id.email);
        passwordview = findViewById(R.id.password);
        mAuth=  FirebaseAuth.getInstance();
        store=FirebaseFirestore.getInstance();
        phoneNumberview = findViewById(R.id.phone);
        back = findViewById(R.id.back);
        register = findViewById(R.id.register);


        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Registering...");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(register1.this, home.class));
                finish();

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = nameview.getText().toString().trim();
                String email = emailview.getText().toString().trim();
                String password = passwordview.getText().toString().trim();
                String phonenumber = phoneNumberview.getText().toString().trim();


                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

                    emailview.setError("Invalid Email");
                    emailview.setFocusable(true);

                } else if (password.length() < 8) {
                    passwordview.setError("Password length at least 8 characters");
                    passwordview.setFocusable(true);


                } else if (phonenumber.length() < 10 || phonenumber.length() > 10) {


                    phoneNumberview.setError("This Phonenumber does not exists");
                    phoneNumberview.setFocusable(true);

                } else {


                    Map<String, Object> book = new HashMap<>();

                    book.put("name", name);
                    book.put("password", password);
                    book.put("email", email);
                    book.put("phoneno", phonenumber);


                    store.collection("flight").document("registration")
                            .set(book);


                    registerUser(email, password);
                }
            }
        });
    }

    public void registerUser(String email, String password) {


        progressDialog.show();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressDialog.dismiss();

                            FirebaseUser user = mAuth.getCurrentUser();

                            AlertDialog.Builder builder = new AlertDialog.Builder(register1.this);


                            builder.setMessage("धन्यवाद");

                            builder.setTitle("");


                            builder.setCancelable(false);

                            builder.setPositiveButton(
                                    "Ok",
                                    new DialogInterface
                                            .OnClickListener() {

                                        @Override
                                        public void onClick(DialogInterface dialog,
                                                            int which) {
                                            startActivity(new Intent(register1.this, login.class));
                                            finish();

                                        }
                                    });


                            AlertDialog alertDialog = builder.create();

                            alertDialog.show();


                        } else {

                            progressDialog.dismiss();
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(register1.this);


                            builder1.setMessage("You have already registered.Please login");

                            builder1.setTitle("");


                            builder1.setCancelable(false);

                            builder1.setPositiveButton(
                                    "Cancel",
                                    new DialogInterface
                                            .OnClickListener() {

                                        @Override
                                        public void onClick(DialogInterface dialog,
                                                            int which) {
                                            startActivity(new Intent(register1.this, home.class));
                                            finish();

                                        }
                                    });


                            AlertDialog alertDialog = builder1.create();
                            alertDialog.show();
                        }


                    }
                });

    }


}




