package com.mccapp.bianca.mcc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;


/**
 * Created by Team Ella on 2016-05-21.
 */
public class Webplayer extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_joystick_control);

    WebView webView = (WebView) findViewById(R.id.webView);
    webView.loadUrl("http://192.168.43.171/");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }
}
