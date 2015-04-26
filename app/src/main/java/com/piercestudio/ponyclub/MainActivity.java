package com.piercestudio.ponyclub;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.graphics.drawable.BitmapDrawable;

public class MainActivity extends Activity
{
	String TAG = "MainActivity";

	public PopupWindow mPopUpWindow;
	public LinearLayout mainLayout;
	public LayoutInflater layoutInflater;
	public Button showPopupButton;
	public View popupView;

	public String gameState = "start";

	public int heightDisplay;
	public int widthDisplay;

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		Display display = getWindowManager().getDefaultDisplay();
		widthDisplay = display.getWidth();
		heightDisplay = display.getHeight();


		mainLayout = (LinearLayout) findViewById(R.id.activity_main_layout_id);


		//showPopupButton
		showPopupButton = (Button) findViewById(R.id.button_Bar_bottom_id);
		showPopupButton.setOnClickListener(openPopupButtonOnClickListner);


		setGameLoop();


	}

	public void setGameLoop(){

	}


	OnClickListener openPopupButtonOnClickListner = new OnClickListener()
	{
		public void onClick(View v)
		{
			Log.i(TAG, "button clicked");
			Log.i(TAG, gameState);
			switch(gameState)
			{
				case "start":
					Log.i(TAG, "case: start");

				layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
				popupView = layoutInflater.inflate(R.layout.m_popup_window, null);
				mPopUpWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

				mPopUpWindow.setBackgroundDrawable(new BitmapDrawable());
				//mPopUpWindow.setOutsideTouchable(true);
				popupView.setOnClickListener(dismissPopupButtonOnClickListner);


				//popupview implementation
				mPopUpWindow.showAtLocation(mainLayout, Gravity.START, 0, 0);
				mPopUpWindow.update(50, 50, 512, 512);
				gameState = "head visible";

					break;

				case "head visible":
					Log.i(TAG, "case: head visible");
				mPopUpWindow.dismiss();
					gameState = "start";
				break;

				default:
					break;
			}
		}
	};

	OnClickListener dismissPopupButtonOnClickListner = new OnClickListener()
	{
		public void onClick(View v)
		{
			Log.i(TAG, "dismissOnClickListner");
			switch(v.getId())
			{
				case R.id.mPopupWindowId:
				mPopUpWindow.dismiss();
					gameState = "start";
					break;
			}
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