package com.innoprenez.apps.solarsyssim.fragments;

import com.innoprenez.apps.solarsyssim.R;
import com.innoprenez.apps.solarsyssim.view.CelestialRenderView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CelestialViewFragment extends Fragment
{
	CelestialRenderView mPlanetDisplay; 
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view =  inflater.inflate(R.layout.fragment_celestialview, container, false);
		
		mPlanetDisplay =  (CelestialRenderView) view.findViewById(R.id.planet_display); 
		return view;
	}
	@Override
	public void onResume() {
		super.onResume();
		mPlanetDisplay.resume();
	}
	
	@Override
	public void onPause() {
		super.onPause();
		mPlanetDisplay.pause();
	}
}
