package com.example.ar832813.arunandroid;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ar832813 on 9/15/2015.
 */
//Create static class for tab fragments manager
public class ARTabFragmentStateAdapter extends android.support.v4.app.FragmentStatePagerAdapter {

    public ARTabFragmentStateAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public int getCount(){
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position){
        String pageTitle = new String();

        switch(position){
            case 0:
                return "Friendly";
            case 1:
                return "Hostile";
        }

        return "Not Needed";
    }


    @Override
    public android.support.v4.app.Fragment getItem(int position){

        switch(position){
            case 0:{
                ARListFragment firstFragmentTab = new ARListFragment();

                ArrayList flagArrayList = new ArrayList<Integer>(Arrays.asList(R.drawable.flag_india, R.drawable.flag_us));
                ArrayList countryArrayList = new ArrayList<String>(Arrays.asList("India","US"));
                ArrayList currencyArrayList = new ArrayList<String>(Arrays.asList( "Rupee","US Dollar"));
                Bundle argsBundle = new Bundle();


                argsBundle.putIntegerArrayList("flaglist",flagArrayList);
                argsBundle.putStringArrayList("countryname",countryArrayList);
                argsBundle.putStringArrayList("currencylist",currencyArrayList);
                firstFragmentTab.setArguments(argsBundle);
                Log.v("countries", "Friendly");
                return firstFragmentTab;
            }

            case 1:{
                ARListFragment secondFragmentTab = new ARListFragment();

                ArrayList flagArrayList = new ArrayList<Integer>(Arrays.asList(R.drawable.flag_jpn,R.drawable.flag_pakistan));
                ArrayList countryArrayList = new ArrayList<String>(Arrays.asList("Japan","Pakistan"));
                ArrayList currencyArrayList = new ArrayList<String>(Arrays.asList( "Yen","Yuan"));
                Bundle argsBundle = new Bundle();


                argsBundle.putIntegerArrayList("flaglist",flagArrayList);
                argsBundle.putStringArrayList("countryname",countryArrayList);
                argsBundle.putStringArrayList("currencylist",currencyArrayList);
                secondFragmentTab.setArguments(argsBundle);
                Log.v("countries","Hostile");
                return secondFragmentTab;

            }


        }


        return null;
    }
}