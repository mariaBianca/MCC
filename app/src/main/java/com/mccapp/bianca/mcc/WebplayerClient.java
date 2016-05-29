package com.mccapp.bianca.mcc;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Team Ella on 2016-05-25.
 * This class implements WebplayerClient
 */
public class WebplayerClient extends WebViewClient {

    // The application remains in control when a link is pressed
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;

    }
}