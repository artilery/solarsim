package com.innoprenez.apps.solarsyssim.fragments;

import com.innoprenez.apps.solarsyssim.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PlanetDetailsFragment extends Fragment 
{
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, 
							ViewGroup container,
							Bundle savedInstanceState) 
	{
		View view =  inflater.inflate(R.layout.fragment_planet_details, container, false);
		return view;
	}
}
