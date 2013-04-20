package com.innoprenez.apps.solarsyssim.fragments;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.innoprenez.apps.solarsyssim.R;

public class PlanetListFragment extends Fragment 
{
	String [] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
    
	private ListView mPlanetListView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view =  inflater.inflate(R.layout.fragment_planet_list, container, false);
		
		mPlanetListView = (ListView)view.findViewById(R.id.planet_listview); 
		
		return view;
	}
	@Override
    public void onActivityCreated(Bundle savedInstanceState) {
    	super.onActivityCreated(savedInstanceState);
    	
    	//lv.setBackgroundResource(R.drawable.fragment_background);
    	//lv.setDivider(getActivity().getResources().getDrawable(R.drawable.divider)); 
    	List<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
    	
    	for(int i = 0; i  < planets.length; i++)
    	{
    		HashMap<String, String> item = new HashMap<String, String>();
    		item.put("planet_name", planets[i]);
    		data.add(item);
     	}
    	
    	mPlanetListView.setAdapter(new SimpleAdapter(getActivity(),
    									data,
    									R.layout.planet_item, 
    									new String[]{"planet_name"},
    									new int[]{R.id.planet_name}));
    }
}
