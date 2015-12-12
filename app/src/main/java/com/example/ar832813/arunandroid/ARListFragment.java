package com.example.ar832813.arunandroid;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ar832813 on 7/23/2015.
 */
public class ARListFragment extends ListFragment {
    //inflate the fragment during onAttach()
    public static final String LIST_MESSAGE = "com.example.ar832813.arunandroid.ARListFragment.MESSAGE";
//dummy comment

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState){
        //Create binding date for the list
        //Create Flag image list

        // get bundle associate with this Fragment
        Bundle args = this.getArguments();

       ArrayList flagArrayList = args.getIntegerArrayList("flaglist");
       ArrayList countryNameArrayList = args.getStringArrayList("countryname");
       ArrayList currencyListArrayList = args.getStringArrayList("currencylist");

        //Create ArrayList for the text view
        ArrayList<HashMap<String,String>> arrayList = new ArrayList<HashMap<String, String>>();

        // Update HashMap for the countries
        for(int i=0;i<2;i++){
            HashMap<String, String> iterationCounterHashMap = new HashMap<String,String>();
            iterationCounterHashMap.put("Country",countryNameArrayList.get(i).toString());
            iterationCounterHashMap.put("Currency",currencyListArrayList.get(i).toString());
            iterationCounterHashMap.put("Flag",flagArrayList.get(i).toString());
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

    @Override
    public void onListItemClick (ListView I, View v, int position, long id){
        // Declare local variables
       // String dataAtItemPosition ;

        // Give a log commment
        Log.v("Fragment","List View Clicked");


        //get Data associated with item at position
       // Log.v("Fragment",(String) getListAdapter().getSelect);
        HashMap<String,String> dataAtItemPosition = (HashMap<String,String>)getListAdapter().getItem(position);
/*
        Intent intentForSelectedItem = new Intent(getActivity().getBaseContext(), DisplayMessageActivity.class);
        intentForSelectedItem.putExtra(LIST_MESSAGE, dataAtItemPosition.get("Currency") );
*/
     //   Uri number = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
        Intent intentForSelectedItem = new Intent();//,number);
        //Check if there are applications available to handle the intent
        intentForSelectedItem.setAction(Intent.ACTION_SEND);
        String intentEmail[] = {"sharadha.23@gmail.com","sharadha.navya@gmail.com"};
        String intentCC[]={"arun_r80@yahoo.co.in"};
        intentForSelectedItem.putExtra(Intent.EXTRA_TEXT,"Sent from my Android Phone!!");
        intentForSelectedItem.putExtra(Intent.EXTRA_EMAIL,intentEmail);
        intentForSelectedItem.putExtra(Intent.EXTRA_CC,"arun_r80@yahoo.co.in");
        intentForSelectedItem.putExtra(Intent.EXTRA_BCC,"arun_r80@yahoo.co.in");
        intentForSelectedItem.setType("text/plain");
        PackageManager packageManager = getActivity().getBaseContext().getPackageManager();
        List activities = packageManager.queryIntentActivities(intentForSelectedItem,PackageManager.MATCH_DEFAULT_ONLY);
        if (activities.size() > 0 )
        {
            Log.v("Fragment","Email app found");
            startActivity(intentForSelectedItem);
        }

    }
}
