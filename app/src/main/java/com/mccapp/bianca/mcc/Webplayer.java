package com.mccapp.bianca.mcc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;


/**
 * Created by mika on 2016-05-21.
 */
public class Webplayer extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.web_view);

    WebView webView = (WebView) findViewById(R.id.webView);
    webView.loadUrl("https://www.youtube.com/watch?v=_2kx8vJBR_s");


}
}
