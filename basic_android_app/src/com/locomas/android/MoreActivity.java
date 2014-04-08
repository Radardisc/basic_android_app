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
import android.widget.Toast;
import android.os.Build;

public class MoreActivity extends ActionBarActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        initView();

    }
    
    private void initView() {
    	findViewById(R.id.btn_about).setOnClickListener(this);
    	findViewById(R.id.btn_signup).setOnClickListener(this);
    	findViewById(R.id.btn_login).setOnClickListener(this);
    	findViewById(R.id.buttonBack).setOnClickListener(this);
    }

	@Override
	public void onClick(View arg0) {
		switch(arg0.getId()) {
			case R.id.btn_about:
				Toast.makeText(this, "Coming Soon...", Toast.LENGTH_SHORT).show();
				break;
			case R.id.btn_login:
				Toast.makeText(this, "Coming Soon...", Toast.LENGTH_SHORT).show();
				break;
			case R.id.btn_signup:
				startActivityForResult(new Intent(this, SignUpActivity.class), 1);
				break;
			case R.id.buttonBack:
				finish();
				break;
		}
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == 1) {
	        // Make sure the request was successful
	        if (resultCode == 101) {
	        	setResult(101);
	        	finish();
	        }
	    }
	}
}
