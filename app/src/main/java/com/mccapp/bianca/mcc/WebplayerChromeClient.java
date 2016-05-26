package com.mccapp.bianca.mcc;

import android.view.View;
import android.webkit.WebChromeClient;

/**
 * Created by Team Ella on 2016-05-26.
 */
public class WebplayerChromeClient extends WebChromeClient {

    private CustomViewCallback webViewCallback;
    private WebChromeClient mWebChromeClient;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    View view;



    //mWebChromeClient = new WebChromeClient() {


        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback){
            onShowCustomView(view, callback);

        }

        public void onHideCustomView() {
        }

}


