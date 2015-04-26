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

	public boolean popupIsVisible = false;

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


	}


	OnClickListener openPopupButtonOnClickListner = new OnClickListener()
	{
		public void onClick(View v)
		{
			Log.i(TAG, "button clicked");
			if (!popupIsVisible)
			{

				layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
				popupView = layoutInflater.inflate(R.layout.m_popup_window, null);
				mPopUpWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

				mPopUpWindow.setBackgroundDrawable(new BitmapDrawable());
				//mPopUpWindow.setOutsideTouchable(true);
				popupView.setOnClickListener(dismissPopupButtonOnClickListner);


				//popupview implementation
				mPopUpWindow.showAtLocation(mainLayout, Gravity.CENTER, 50, 50);
				mPopUpWindow.update(50, 50, 512, 512);
				popupIsVisible = true;

			} else {
				mPopUpWindow.dismiss();
				popupIsVisible = false;
			}
		}
	};

	OnClickListener dismissPopupButtonOnClickListner = new OnClickListener()
	{
		public void onClick(View v)
		{
			mPopUpWindow.dismiss();
			popupIsVisible = false;
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