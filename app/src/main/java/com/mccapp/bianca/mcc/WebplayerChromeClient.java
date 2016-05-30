package com.mccapp.bianca.mcc;

import android.view.View;
import android.webkit.WebChromeClient;

/**
 * Created by Team Ella on 2016-05-26.
 * This class implements WebChromeClient
 */
public class WebplayerChromeClient extends WebChromeClient {

    // Initiate the required for WebChromeClient
    private CustomViewCallback webViewCallback;
    private WebChromeClient mWebChromeClient;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    View view;

    // The CustomView for WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
        onShowCustomView(view, callback);

    }

}