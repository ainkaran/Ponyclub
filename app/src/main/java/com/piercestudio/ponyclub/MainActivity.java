package com.piercestudio.ponyclub;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import java.util.Random;
import android.graphics.Point;
import android.media.MediaPlayer;

public class MainActivity extends Activity
{
	String TAG = "MainActivity";

	public PopupWindow mPopUpWindow;
	public LinearLayout mainLayout;
	public LayoutInflater layoutInflater;
	public Button showPopupButton;
	public View popupView;
	public Handler mHandler;
	public final Point mPoint = new Point();

	public String gameState = "start";
	public int i = 0;
	public boolean popupIsActive = false;

	public int heightDisplay;
	public int widthDisplay;
	public MediaPlayer player;

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Display mDisplay = getWindowManager().getDefaultDisplay();
		widthDisplay = mDisplay.getWidth();
		heightDisplay = mDisplay.getHeight();
		mDisplay.getSize(mPoint);


		mainLayout = (LinearLayout) findViewById(R.id.activity_main_layout_id);

		showPopupButton = (Button) findViewById(R.id.button_Bar_bottom_id);

		setGameLoop(i);
	}

	public void setGameLoop(int i){
			switch (i)
			{
				case 0:
					showPopupButton.setText("Where is the pony's head?");
					mainLayout.setOnTouchListener(headPopupButtonOnTouchListner);
					break;
				case 1:
					showPopupButton.setText("Where is the pony's tail?");
					mainLayout.setOnTouchListener(tailPopupButtonOnTouchListner);
					break;
				case 2:
					showPopupButton.setText("Where are the pony's front hoofs?");
					mainLayout.setOnTouchListener(hoofsPopupButtonOnTouchListner);
					break;
				case 3:
					showPopupButton.setText("Where is the kitty?");
					mainLayout.setOnTouchListener(kittyPopupButtonOnTouchListner);
					break;
				case 4:
					showPopupButton.setText("Where is the Nyan Cat?");
					mainLayout.setOnTouchListener(nyanCatPopupButtonOnTouchListner);
					break;

			}
	}

	OnTouchListener headPopupButtonOnTouchListner = new OnTouchListener()
	{
			@Override
			public boolean onTouch(View v, MotionEvent event)
			{
				Log.i(TAG, "X: " + event.getX() + " Y: " + event.getY());
				if(event.getX()<(550) && event.getY()>500 && event.getY()<770 && popupIsActive != true)
				{
					popupIsActive = true;
					Log.i(TAG, "headOnClick");
					layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
					popupView = layoutInflater.inflate(R.layout.head_popup_window, null);
					mPopUpWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

					mPopUpWindow.setBackgroundDrawable(new BitmapDrawable());
					//mPopUpWindow.setOutsideTouchable(true);
					popupView.setOnClickListener(dismissPopupButtonOnClickListner);

					showPopupButton.setText("There's the pony's head!");

					//popupview implementation
					mPopUpWindow.showAtLocation(mainLayout, Gravity.START, 0, 0);
					mPopUpWindow.update(50, 50, 512, 512);
					i = 1;
				}
				return true;

		}
	};

	OnTouchListener tailPopupButtonOnTouchListner = new OnTouchListener()
	{
		@Override
		public boolean onTouch(View v, MotionEvent event)
		{
			Log.i(TAG, "X: " + event.getX() + " Y: " + event.getY());
			if(event.getX()>700 && event.getY()>770 & event.getY()<1400 && popupIsActive != true)
			{
				Log.i(TAG, "tailOnClick");
				popupIsActive = true;
				layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
				popupView = layoutInflater.inflate(R.layout.tail_popup_window, null);
				mPopUpWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

				mPopUpWindow.setBackgroundDrawable(new BitmapDrawable());
				//mPopUpWindow.setOutsideTouchable(true);
				popupView.setOnClickListener(dismissPopupButtonOnClickListner);

				showPopupButton.setText("There's the pony's tail!");


				//popupview implementation
				mPopUpWindow.showAtLocation(mainLayout, Gravity.START, 0, 0);
				mPopUpWindow.update(600, 500, 512, 512);
				i = 2;
			}
			return true;

		}
	};

	OnTouchListener hoofsPopupButtonOnTouchListner = new OnTouchListener()
	{
		@Override
		public boolean onTouch(View v, MotionEvent event)
		{
			Log.i(TAG, "X: " + event.getX() + " Y: " + event.getY());
			if(event.getX()<550 && event.getY()>770 & event.getY()<1400 && popupIsActive != true)
			{
				Log.i(TAG, "hoofsOnClick");
				popupIsActive = true;
				layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
				popupView = layoutInflater.inflate(R.layout.hoofs_popup_window, null);
				mPopUpWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

				mPopUpWindow.setBackgroundDrawable(new BitmapDrawable());
				//mPopUpWindow.setOutsideTouchable(true);
				popupView.setOnClickListener(dismissPopupButtonOnClickListner);

				showPopupButton.setText("There are the pony's hoofs!");


				//popupview implementation
				mPopUpWindow.showAtLocation(mainLayout, Gravity.START, 0, 0);
				mPopUpWindow.update(50, 450, 512, 512);
				i = 3;
			}
			return true;

		}
	};

	OnTouchListener kittyPopupButtonOnTouchListner = new OnTouchListener()
	{
		@Override
		public boolean onTouch(View v, MotionEvent event)
		{
			Log.i(TAG, "X: " + event.getX() + " Y: " + event.getY());
			if(event.getY()>500 && event.getY()<1000 && event.getX()>550 && popupIsActive != true)
			{
				Log.i(TAG, "kittyOnClick");
				popupIsActive = true;
				layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
				popupView = layoutInflater.inflate(R.layout.kitty_popup_window, null);
				mPopUpWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

				mPopUpWindow.setBackgroundDrawable(new BitmapDrawable());
				//mPopUpWindow.setOutsideTouchable(true);
				popupView.setOnClickListener(dismissPopupButtonOnClickListner);

				showPopupButton.setText("There's the kitty!");


				//popupview implementation
				mPopUpWindow.showAtLocation(mainLayout, Gravity.START, 0, 0);
				mPopUpWindow.update(450, -60, 512, 512);
				i = 4;

			}
			return true;

		}
	};

	OnTouchListener nyanCatPopupButtonOnTouchListner = new OnTouchListener()
	{
		@Override
		public boolean onTouch(View v, MotionEvent event)
		{
			Log.i(TAG, "X: " + event.getX() + " Y: " + event.getY());
			if(event.getY()>1200 && event.getY()<1400 && event.getX()>800 && popupIsActive != true)
			{
				Log.i(TAG, "nyanCatOnClick");
				popupIsActive = true;
				layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
				popupView = layoutInflater.inflate(R.layout.nyan_cat_popup_window, null);
				mPopUpWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

				mPopUpWindow.setBackgroundDrawable(new BitmapDrawable());
				//mPopUpWindow.setOutsideTouchable(true);
				popupView.setOnClickListener(dismissPopupButtonOnClickListner);

				showPopupButton.setText("NYAN CAAAT!");


				//popupview implementation
				mPopUpWindow.showAtLocation(mainLayout, Gravity.CENTER, 0, 0);
				mPopUpWindow.update(0, 0, 500, 1000);

				player = MediaPlayer.create(MainActivity.this,R.raw.nyancat37seconds);
				player.start();

				i = 0;

			}
			return true;

		}
	};

	OnClickListener dismissPopupButtonOnClickListner = new OnClickListener()
	{
		public void onClick(View v)
		{
			Log.i(TAG, "dismissOnClickListner");

			stopPlayer();

			popupIsActive = false;

			mPopUpWindow.dismiss();

			setGameLoop(i);

		}
	};

	public void stopPlayer(){
		Log.i(TAG, "stopping");
		try
		{
			if (player.isPlaying())
			{
				Log.i(TAG, "stopped");
				player.stop();
			}
		} catch (Exception e) {
		}
	}

	@Override
	protected void onPause()
	{
		super.onPause();
		if(mPopUpWindow != null)
		{
			mPopUpWindow.dismiss();
		}
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		if(mPopUpWindow != null)
		{
			mPopUpWindow.dismiss();
		}
	}

	@Override
	protected void onResume()
	{
		super.onResume();
	}
}