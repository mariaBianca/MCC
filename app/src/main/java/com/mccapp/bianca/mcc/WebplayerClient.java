package com.mccapp.bianca.mcc;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Team Ella on 2016-05-25.
 */
public class WebplayerClient extends WebViewClient {

    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        view.loadUrl(url);
        return true;

    }
}
