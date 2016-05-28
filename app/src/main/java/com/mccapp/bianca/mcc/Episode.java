package com.mccapp.bianca.mcc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by Team Ella on 2016-05-27.
 * This class allows the user to watch an episode of Magic School Bus.
 */
public class Episode extends AppCompatActivity {

    //Beginning of the activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.episode_view);


        WebView webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebplayerClient());
        webView.loadUrl("https://youtu.be/_2kx8vJBR_s");

        webView.setWebViewClient(new WebplayerClient());
        webView.setWebChromeClient(new WebplayerChromeClient());

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }
}