package com.locomas.android;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.os.Build;

public class InitialActivity extends ActionBarActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }
    
    private void initView() {
    	WebView web = (WebView) findViewById(R.id.main_web);
    	web.setWebViewClient(new LocomasWebViewClient());
    	web.loadUrl("http://www.google.com");
    	
    	findViewById(R.id.buttonMore).setOnClickListener(this);

    }

    private class LocomasWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.buttonMore:
			startActivityForResult(new Intent(this, MoreActivity.class), 1);
			break;
		}
		
	}

}
