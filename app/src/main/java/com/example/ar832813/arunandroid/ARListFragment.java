package com.example.ar832813.arunandroid;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ar832813 on 7/23/2015.
 */
public class ARListFragment extends ListFragment {
    //inflate the fragment during onAttach()

    public View OnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState){
        // inflate the fragment
        return layoutInflater.inflate(R.layout.list_fragment_layout, viewGroup, false);

    }
}
