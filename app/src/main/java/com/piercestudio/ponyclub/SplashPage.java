package com.piercestudio.ponyclub;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import com.piercestudio.ponyclub.MainActivity;

/**
 * Created by User on 4/28/15.
 */
public class SplashPage extends Activity
{

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_layout);

		final Intent mIntent = new Intent(this, MainActivity.class);

		Runnable splash = new Runnable()
		{
			public void run()
			{

				startActivity(mIntent);
			}
		};

		Handler mHandler = new Handler();
		mHandler.postDelayed(splash, 1000);

	}
}