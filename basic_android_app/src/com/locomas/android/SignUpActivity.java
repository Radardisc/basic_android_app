package com.locomas.android;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
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
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class SignUpActivity extends ActionBarActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initView();

    }
    
    private void initView() {
    	findViewById(R.id.buttonBack).setOnClickListener(this);
    	TextView link = (TextView) findViewById(R.id.link_signup);
    	link.setMovementMethod(LinkMovementMethod.getInstance());
    }

	@Override
	public void onClick(View arg0) {
		switch(arg0.getId()) {
			case R.id.buttonBack:
				finish();
				break;
		}
		
	}

}
