package com.example.fly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;

public class home1 extends AppCompatActivity {
  Button regis,logi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);


  regis=findViewById(R.id.regisx);

        logi=findViewById(R.id.logix);
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(home1.this, register1.class));
                finish();

            }
        });

        logi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(home1.this, login1.class));
                finish();

            }
        });


    }
}
