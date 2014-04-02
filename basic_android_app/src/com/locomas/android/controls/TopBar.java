package com.locomas.android.controls;

import com.locomas.android.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class TopBar extends LinearLayout {

	public Context mContext;
	public TopBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		setupView(context, attrs);
	}

	public void setupView(Context context, AttributeSet attrs) {
		mContext = context;
		LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		layoutInflater.inflate(R.layout.component_topbar, this, true);
		
		TypedArray arr = mContext.obtainStyledAttributes(attrs, R.styleable.topbar);
		boolean  bShowBack = arr.getBoolean(R.styleable.topbar_showBack, true);
		if (!bShowBack ) {
			findViewById(R.id.buttonBack).setVisibility(View.GONE);
		}

		boolean  bShowMore= arr.getBoolean(R.styleable.topbar_showMore, true);
		if (!bShowMore ) {
			findViewById(R.id.buttonMore).setVisibility(View.GONE);
		}

		
		arr.recycle();  // Do this when done.

	}
}
