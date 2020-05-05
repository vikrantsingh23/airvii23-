package com.example.fly;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;




public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        WebView browser = findViewById(R.id.web2);


        browser.getSettings().setJavaScriptEnabled(true);
        browser.setWebChromeClient(new WebChromeClient());

        browser.loadUrl("file:///android_asset/home.html");


        browser.addJavascriptInterface(new Object() {
            @JavascriptInterface
            public void register() {

                Intent n = new Intent(home.this, register.class);
                startActivity(n);
            }
        }, "ok");




        browser.addJavascriptInterface(new Object() {
            @JavascriptInterface
            public void login() {

                Intent i = new Intent(home.this, login.class);
                startActivity(i);
            }
        }, "ok1");



    }
}
