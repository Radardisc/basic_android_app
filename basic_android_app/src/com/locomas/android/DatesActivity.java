package com.locomas.android;

import java.util.Calendar;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.DatePickerDialog;
import android.app.Dialog;
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
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class DatesActivity extends ActionBarActivity implements OnClickListener {

	private int year1, month1, day1;
	
	private DatePicker picker1, picker2;
	
	static final int DATE_DIALOG_ID1 = 998;
	static final int DATE_DIALOG_ID2 = 999;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dates);
        initView();

    }
    
    private void initView() {
    	
    	picker1 = (DatePicker) findViewById(R.id.dp_start);
    	picker2 = (DatePicker) findViewById(R.id.dp_end);
    	setCurrentDateOnView();
    }
    
    private void setCurrentDateOnView() {
    	
   		final Calendar c = Calendar.getInstance();
   		year1 = c.get(Calendar.YEAR);
   		month1 = c.get(Calendar.MONTH);
   		day1 = c.get(Calendar.DAY_OF_MONTH);
     
  		// set current date into datepicker
   		picker1.init(year1, month1, day1, null);
   		picker2.init(year1, month1, day1, null);
     
    }
    

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
