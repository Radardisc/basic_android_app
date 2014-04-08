package com.locomas.android;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

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
    	link.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivityForResult(new Intent(SignUpActivity.this, RetailerSignUpActivity.class), 1);
				
			}
		});;
    }

	@Override
	public void onClick(View arg0) {
		switch(arg0.getId()) {
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
