package com.example.fly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class language extends AppCompatActivity {
   Button english,odissa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        english=findViewById(R.id.english);
        odissa=findViewById(R.id.hindi);
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(language.this, home.class));
                finish();

            }
        });
        odissa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(language.this, home1.class));
                finish();

            }
        });





    }
}
