package com.example.livv;

import android.app.Activity;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewChat extends Activity{
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from new_activity.xml
        setContentView(R.layout.webview_chat);
        WebView mWebView;
        mWebView = findViewById(R.id.activity_main_webview);
            // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());
            // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // REMOTE RESOURCE
        mWebView.loadUrl("https://www.buoyhealth.com/symptom-checker/");
        mWebView.setWebViewClient(new MyWebViewClient());
        // LOCAL RESOURCE
        // mWebView.loadUrl("file:///android_asset/index.html");
    }
        // Prevent the back-button from closing the app
        @Override
        public void onBackPressed() {
            WebView mWebView;
            mWebView = findViewById(R.id.activity_main_webview);
            if(mWebView.canGoBack()){
                mWebView.goBack();
            }
            else {
                super.onBackPressed();
            }
        }
    }
