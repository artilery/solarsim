package com.innoprenez.apps.solarsyssim;

import com.innoprenez.apps.solarsyssim.view.CelestialRenderView;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends FragmentActivity {

	//CelestialRenderView renderView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*requestWindowFeature(Window.FEATURE_NO_TITLE); 
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
							WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
		
		//renderView = new CelestialRenderView(this);
		setContentView(R.layout.activity_main);
	}
	@Override
	protected void onResume() {
		super.onResume();
		//renderView.resume();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		//renderView.pause();
	}

	

}
