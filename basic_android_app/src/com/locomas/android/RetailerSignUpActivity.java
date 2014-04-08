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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.os.Build;

public class RetailerSignUpActivity extends ActionBarActivity implements
		OnClickListener {

	private ViewFlipper mFlipper;
	private Button mBtnNext, mBtnPrev;
	private int mPageIndex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_retailer_signup);
		initView();

	}

	private void initView() {
		findViewById(R.id.buttonBack).setOnClickListener(this);
		findViewById(R.id.buttonMore).setOnClickListener(this);
		Button more = ((Button) findViewById(R.id.buttonMore));
		more.setText("Exit");
		more.setOnClickListener(this);
		
		mBtnNext = (Button) findViewById(R.id.btn_navigateNext);
		mBtnPrev = (Button) findViewById(R.id.btn_navigatePrev);

		mBtnNext.setOnClickListener(this);
		mBtnPrev.setOnClickListener(this);
		mFlipper = (ViewFlipper) findViewById(R.id.flipper);
		updateNavigationButtons();
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.buttonBack:
			finish();
			break;
		case R.id.buttonMore:
			setResult(101);
			finish();
			break;
		case R.id.btn_navigateNext:
			if (validate()) {
				if (mFlipper.getDisplayedChild() < mFlipper.getChildCount() - 1) {
					mFlipper.showNext();
					updateNavigationButtons();

				}
				else
					Toast.makeText(this, "Submit...", Toast.LENGTH_SHORT)
							.show();
			}
			else
			{
			Toast.makeText(this, "Ooops, some fields are incorrect...", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.btn_navigatePrev:
			if (mFlipper.getDisplayedChild() > 0) {
				mFlipper.showPrevious();
			}
			updateNavigationButtons();
			break;
		}

	}

	public void updateNavigationButtons() {
		int index = mFlipper.getDisplayedChild();
		mBtnPrev.setEnabled(index > 0);
		mBtnNext.setText(index < 5 ? "NEXT" : "APPLY");

	}

	public boolean validate() {
		switch(mFlipper.getDisplayedChild()) {
			case 0:
			case 4:
				return true;
			case 5:
				return ((CheckBox) findViewById(R.id.chb_license)).isChecked();
				
			case 1:
				
				return     isValidEmail(findViewById(R.id.edt_email)) 
						&& isValidPass(findViewById(R.id.edt_pass))
						&& isPassMatch(findViewById(R.id.edt_pass), findViewById(R.id.edt_passConfirm));
				
			case 2:
				return     isValidText(findViewById(R.id.edt_business)) 
						&& isValidText(findViewById(R.id.edt_businessOwner)) 
						&& isValidText(findViewById(R.id.edt_businesstype)) 
						&& isValidPhone(findViewById(R.id.edt_contact));
			case 3:
				return     isValidText(findViewById(R.id.edt_building)) 
						&& isValidText(findViewById(R.id.edt_street)) 
						&& isValidText(findViewById(R.id.edt_area)) 
						&& isValidText(findViewById(R.id.edt_district)) 
						&& isValidText(findViewById(R.id.edt_city)) 
						&& isValidText(findViewById(R.id.edt_province)) 
						&& isValidText(findViewById(R.id.edt_country));
				
			
		}
		
		return false;
	}
	
	private boolean isValidPass(View edt) {
		return isValidText(edt, 20);
	}

	private boolean isValidText(View edt) {
		return isValidText(edt, 40);
	}
	
	
	
	private boolean isValidText(View edt, int len) {
		if(edt instanceof EditText) {
			String str = ((EditText)edt).getText().toString();
			return str.length() > 0 && str.length() <= len;
		}
		else
			return false;
	}
	
	private boolean isValidPhone(View edt) {
		if(edt instanceof EditText) {
			String str = ((EditText)edt).getText().toString().trim();
			for(int i=0; i<str.length(); i++) {
				if((str.charAt(i) < '0' || str.charAt(i) > '9') && str.charAt(i) !=  ' ' && str.charAt(i) !=  '+')
					return false;
			}
			return true;
		}
		else
			return false;
	}
	
	
	private boolean isPassMatch(View p1, View p2) {
		return ((EditText) p1).getText().toString().trim().equalsIgnoreCase(((EditText) p2).getText().toString().trim());
	}
	
	private boolean isValidEmail(View edt) {
		if(edt instanceof EditText) {
			String str = ((EditText)edt).getText().toString().trim();
			return str.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
			}
		else
			return false;
	}

}
