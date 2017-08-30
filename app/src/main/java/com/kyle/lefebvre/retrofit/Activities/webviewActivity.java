package com.kyle.lefebvre.retrofit.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kyle.lefebvre.retrofit.R;

public class webviewActivity extends AppCompatActivity {

    private WebView mWebView;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        initWebview();

        getBundleExtras();

        mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String urlz) {
                view.loadUrl(urlz);
                return false;
            }
        });

        mWebView.loadUrl(url);

    }

    private void getBundleExtras() {
        Bundle b = getIntent().getExtras();
        url = b.getString("url");
    }

    private void initWebview() {
        mWebView = (WebView) findViewById(R.id.web);

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mWebView.destroy();
        mWebView = null;
        super.onDestroy();
    }

    @Override
    protected void onPause() {

        mWebView.onPause();
        mWebView.pauseTimers();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mWebView.resumeTimers();
        mWebView.onResume();
    }
}
