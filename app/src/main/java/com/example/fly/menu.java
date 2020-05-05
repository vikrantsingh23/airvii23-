package com.example.fly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.content.Intent;

import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;


public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        WebView browser = findViewById(R.id.web);


        browser.getSettings().setJavaScriptEnabled(true);
        browser.setWebChromeClient(new WebChromeClient());

        browser.loadUrl("file:///android_asset/menu.html");




        browser.addJavascriptInterface(new Object() {
            @JavascriptInterface
            public void booking() {

                Intent n = new Intent(menu.this, booking.class);
                startActivity(n);
            }
        }, "ok");
        browser.addJavascriptInterface(new Object(){
            @JavascriptInterface
            public void checkin() {

                Intent imd= new Intent(menu.this, checkin.class);
                startActivity(imd);
            }
        }, "ok1");

        browser.addJavascriptInterface(new Object(){
            @JavascriptInterface
            public void flightstatus() {

                Intent imn= new Intent(menu.this, flightstatus.class);
                startActivity(imn);
            }
        }, "ok2");



        browser.addJavascriptInterface(new Object(){
            @JavascriptInterface
            public void contactus() {

                Intent i= new Intent(menu.this, contactus.class);
                startActivity(i);
            }
        }, "ok3");


        browser.addJavascriptInterface(new Object(){
            @JavascriptInterface
            public void aboutus() {

                Intent im= new Intent(menu.this, aboutus.class);
                startActivity(im);
            }
        }, "ok4");



        browser.addJavascriptInterface(new Object(){
            @JavascriptInterface
            public void manage() {

                Intent imp= new Intent(menu.this, manage.class);
                startActivity(imp);
            }
        }, "ok5");


    }
}