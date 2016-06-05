package com.mccapp.bianca.mcc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * @author group Ella.
 * This class represents the implementation of allowing the user to watch an episode of Magic School Bus.
 */
public class Episode extends AppCompatActivity {

    /**
     * This method implements the beginning of the activity.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.episode_view);

        //Creation of webview and loadurl
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("https://youtu.be/_2kx8vJBR_s");

        //webView.setWebViewClient(new WebplayerClient());
        webView.setWebChromeClient(new WebplayerChromeClient());

        // Enable the necessary and Javascript
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }
}