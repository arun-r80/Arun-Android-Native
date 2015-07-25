package com.example.ar832813.arunandroid;


import android.app.Fragment;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ar832813 on 7/23/2015.
 */
public class ARListFragment extends ListFragment {
    //inflate the fragment during onAttach()



    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState){
        //Create binding date for the list
        //Create Flag image list
        int flaglist[]={R.drawable.flag_india,
        R.drawable.flag_us};

        //Create name of countries
        String countryname[] = {
                "India",
                "US"
        };

        //Create Currency for countries
        String currencyList[]={
                "Rupee",
                "US Dollar"
        };

        //Create ArrayList for the text view
        ArrayList<HashMap<String,String>> arrayList = new ArrayList<HashMap<String, String>>();

        // Update HashMap for the countries
        for(int i=0;i<2;i++){
            HashMap<String, String> iterationCounterHashMap = new HashMap<String,String>();
            iterationCounterHashMap.put("Country",countryname[i]);
            iterationCounterHashMap.put("Currency",currencyList[i]);
            iterationCounterHashMap.put("Flag",Integer.toString(flaglist[i]));
            arrayList.add(iterationCounterHashMap);
        }

        //Create row identifier array
        String rowIdentifierArray[] = {"Flag","Country","Currency"};

        //Create layout id array
        int layoutIdArray[] ={R.id.flag,R.id.txt,R.id.cur};

        //Create SimpleAdapter for the ListView
        SimpleAdapter listViewSimpleAdapter = new SimpleAdapter(getActivity().getBaseContext(), arrayList, R.layout.list_row_layout, rowIdentifierArray,layoutIdArray);
        this.setListAdapter(listViewSimpleAdapter);
        Log.v("ARListFragment", "Set Adapter for the ListFragment");
        // inflate the fragment

        return layoutInflater.inflate(R.layout.list_fragment_layout,viewGroup,false);
        //return super.onCreateView(layoutInflater,viewGroup,savedInstanceState);

    }
}
