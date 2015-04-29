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

	public int heightDisplay;
	public int widthDisplay;

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		Display mDisplay = getWindowManager().getDefaultDisplay();
		widthDisplay = mDisplay.getWidth();
		heightDisplay = mDisplay.getHeight();
		mDisplay.getSize(mPoint);


		mainLayout = (LinearLayout) findViewById(R.id.activity_main_layout_id);


		//showPopupButton
		showPopupButton = (Button) findViewById(R.id.button_Bar_bottom_id);


		setGameLoop();


	}

	public void setGameLoop(){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(12);
		switch(randomInt){
			case 0:
			case 1:
			case 2:
			case 3:
				showPopupButton.setText("Where is the pony's head?");
				mainLayout.setOnTouchListener(headPopupButtonOnTouchListner);
				break;
			case 4:
			case 5:
			case 6:
				showPopupButton.setText("Where is the pony's tail?");
				mainLayout.setOnTouchListener(tailPopupButtonOnTouchListner);
				break;
			case 7:
			case 8:
			case 9:
				showPopupButton.setText("Where are the pony's front hoofs?");
				mainLayout.setOnTouchListener(hoofsPopupButtonOnTouchListner);
				break;
			case 10:
				showPopupButton.setText("Where is the kitty?");
				mainLayout.setOnTouchListener(kittyPopupButtonOnTouchListner);
				break;
			case 11:
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
				if(event.getX()<(mPoint.x/2))
				{
					layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
					popupView = layoutInflater.inflate(R.layout.m_popup_window, null);
					mPopUpWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

					mPopUpWindow.setBackgroundDrawable(new BitmapDrawable());
					//mPopUpWindow.setOutsideTouchable(true);
					popupView.setOnClickListener(dismissPopupButtonOnClickListner);


					//popupview implementation
					mPopUpWindow.showAtLocation(mainLayout, Gravity.START, 0, 0);
					mPopUpWindow.update(50, 50, 512, 512);
				}
				return true;

		}
	};

	OnTouchListener tailPopupButtonOnTouchListner = new OnTouchListener()
	{
		@Override
		public boolean onTouch(View v, MotionEvent event)
		{
			if(event.getX()>(mPoint.x/2))
			{
				layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
				popupView = layoutInflater.inflate(R.layout.m_popup_window, null);
				mPopUpWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

				mPopUpWindow.setBackgroundDrawable(new BitmapDrawable());
				//mPopUpWindow.setOutsideTouchable(true);
				popupView.setOnClickListener(dismissPopupButtonOnClickListner);


				//popupview implementation
				mPopUpWindow.showAtLocation(mainLayout, Gravity.START, 0, 0);
				mPopUpWindow.update(50, 50, 512, 512);
			}
			return true;

		}
	};

	OnTouchListener hoofsPopupButtonOnTouchListner = new OnTouchListener()
	{
		@Override
		public boolean onTouch(View v, MotionEvent event)
		{
			if(event.getY()<(mPoint.y/2))
			{
				layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
				popupView = layoutInflater.inflate(R.layout.m_popup_window, null);
				mPopUpWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

				mPopUpWindow.setBackgroundDrawable(new BitmapDrawable());
				//mPopUpWindow.setOutsideTouchable(true);
				popupView.setOnClickListener(dismissPopupButtonOnClickListner);


				//popupview implementation
				mPopUpWindow.showAtLocation(mainLayout, Gravity.START, 0, 0);
				mPopUpWindow.update(50, 50, 512, 512);
			}
			return true;

		}
	};

	OnTouchListener kittyPopupButtonOnTouchListner = new OnTouchListener()
	{
		@Override
		public boolean onTouch(View v, MotionEvent event)
		{
			if(event.getY()<(mPoint.y/2))
			{
				layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
				popupView = layoutInflater.inflate(R.layout.m_popup_window, null);
				mPopUpWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

				mPopUpWindow.setBackgroundDrawable(new BitmapDrawable());
				//mPopUpWindow.setOutsideTouchable(true);
				popupView.setOnClickListener(dismissPopupButtonOnClickListner);


				//popupview implementation
				mPopUpWindow.showAtLocation(mainLayout, Gravity.START, 0, 0);
				mPopUpWindow.update(50, 50, 512, 512);
			}
			return true;

		}
	};

	OnTouchListener nyanCatPopupButtonOnTouchListner = new OnTouchListener()
	{
		@Override
		public boolean onTouch(View v, MotionEvent event)
		{
			if(event.getY()<(mPoint.y/2))
			{
				layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
				popupView = layoutInflater.inflate(R.layout.m_popup_window, null);
				mPopUpWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

				mPopUpWindow.setBackgroundDrawable(new BitmapDrawable());
				//mPopUpWindow.setOutsideTouchable(true);
				popupView.setOnClickListener(dismissPopupButtonOnClickListner);


				//popupview implementation
				mPopUpWindow.showAtLocation(mainLayout, Gravity.START, 0, 0);
				mPopUpWindow.update(50, 50, 512, 512);
			}
			return true;

		}
	};

	OnClickListener dismissPopupButtonOnClickListner = new OnClickListener()
	{
		public void onClick(View v)
		{
			Log.i(TAG, "dismissOnClickListner");
				mPopUpWindow.dismiss();
			setGameLoop();
		}
	};

	@Override
	protected void onPause()
	{
		super.onPause();
		mPopUpWindow.dismiss();
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		mPopUpWindow.dismiss();
	}

	@Override
	protected void onResume()
	{
		super.onResume();
	}
}