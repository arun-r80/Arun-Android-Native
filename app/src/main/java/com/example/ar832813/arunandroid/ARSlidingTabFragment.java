package com.example.ar832813.arunandroid;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by ar832813 on 9/15/2015.
 */
public class ARSlidingTabFragment extends Fragment {
    private SlidingTabLayout arSlidingTabLayout;
    private ViewPager arViewPager;
    private ARTabFragmentStateAdapter arTabFragmentStateAdapter;

    @Override
    public void onCreate(Bundle savedinstance){

        super.onCreate(savedinstance);

        //Create new instance for
        arTabFragmentStateAdapter = new ARTabFragmentStateAdapter(getChildFragmentManager());
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Log.v("OnCreteView","In OnCreate View");
        return inflater.inflate(R.layout.sliding_tab_layout,container,false);
    }

    @Override
    public void onViewCreated (View view, Bundle savedInstanceState){

        //get viewpager
        arViewPager = (ViewPager)view.findViewById(R.id.countrypager);
        arViewPager.setAdapter(arTabFragmentStateAdapter);
        //Set the Sliding Tab
        arSlidingTabLayout= (SlidingTabLayout) view.findViewById(R.id.ar_sliding_tab);

        arSlidingTabLayout.setViewPager(arViewPager);

        //Set tab colors for SlidingTablayout
        arSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer(){

            @Override
            public int getIndicatorColor(int position) {
                return Color.YELLOW;
            }

            @Override
            public int getDividerColor(int position) {
                return Color.BLUE;
            }


        });


    }
}
