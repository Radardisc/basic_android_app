package com.locomas.android;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends ActionBarActivity {

	private long mTimeCurrent;
	private ImageView mImgSplash;
	private boolean bCancel = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		mImgSplash = (ImageView) findViewById(R.id.splashImage);
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
		bCancel = false;
		
		Animation a = AnimationUtils.loadAnimation(this, R.anim.splash);
		a.reset();

		mImgSplash.startAnimation(a);
		mTimeCurrent = System.currentTimeMillis();
		animationHandler.sendEmptyMessageDelayed(0, 3000);

	}

	@Override
	public void onPause()
	{
		super.onPause();
		bCancel = true;
		animationHandler.removeMessages(0);
		mImgSplash.clearAnimation();
	}

    @Override
    public boolean onTouchEvent(MotionEvent evt)
    {
        if(evt.getAction() == MotionEvent.ACTION_DOWN)
        {
        	animationHandler.removeMessages(0);
	        animationHandler.sendEmptyMessage(0);
        }
        return true;
    }    
    
    
	public Handler animationHandler = new Handler()
	{
		@Override
		public void handleMessage(final Message msg)
		{
			switch (msg.what)
			{
				case 0:
		            startActivity(new Intent(SplashActivity.this, InitialActivity.class));
		            finish();
					break;
			}
		}
	};

}
