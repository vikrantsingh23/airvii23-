package com.example.fly;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class login extends AppCompatActivity {


    EditText emailloginview,passwordloginview;
    TextView textloginview;
     private FirebaseAuth mauth;
    ProgressDialog p;
    ImageView back;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mauth = FirebaseAuth.getInstance();



        emailloginview = findViewById(R.id.emaillogin);
        passwordloginview = findViewById(R.id.passwordlogin);
        textloginview=findViewById(R.id.logintextview) ;
        login = findViewById(R.id.login);

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,menu.class));
                finish();

            }
        });

        textloginview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(login.this,register.class));
                finish();

            }
        });


// login button click
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //input data
                String emailinput = emailloginview.getText().toString().trim();
                String passwordinput = passwordloginview.getText().toString().trim();

                if (!Patterns.EMAIL_ADDRESS.matcher(emailinput).matches()) {
                    // set error message
                    emailloginview.setError("Invalid Email");
                    emailloginview.setFocusable(true);
                } else {

                    //valid email pattern
                    loginUser(emailinput, passwordinput);


                }


            }
        });





        //not have account textview click

        p= new ProgressDialog(this);
        p.setMessage("Logging In.....");
    }
    public void loginUser(String emailinput, String passwordinput) {
//         show progress dialog
        p.show();

        mauth.signInWithEmailAndPassword(emailinput, passwordinput)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success ,dismiss dialog and start register activity
                            p.dismiss();
                            FirebaseUser user= mauth.getCurrentUser();
                            //user is logged in,so start loginactivity
                            startActivity(new Intent(login.this, home.class));
                            finish();


                        } else {
                            p.dismiss();
                            AlertDialog.Builder builder= new AlertDialog.Builder(login.this);

                            // Set the message show for the Alert time
                            builder.setMessage("Wrong credentials.Please try again");

                            // Set Alert Title
                            builder.setTitle("");


                            builder.setCancelable(false);

                            builder.setPositiveButton(
                                    "Ok",
                                    new DialogInterface
                                            .OnClickListener() {

                                        @Override
                                        public void onClick(DialogInterface dialog,
                                                            int which)
                                        {
                                            startActivity(new Intent(login.this, login.class));
                                            finish();



                                        }
                                    });

                            // Set the Negative button with No name
                            // OnClickListener method is use
                            // of DialogInterface interface.

                            // Create the Alert dialog
                            AlertDialog alertDialog = builder.create();

                            // Show the Alert Dialog box
                            alertDialog.show();


                        }
                    }


                });

    }

    // If sign in fails, display a message to the user.





}
