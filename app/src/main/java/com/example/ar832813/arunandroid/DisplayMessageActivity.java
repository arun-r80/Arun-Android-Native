package com.example.ar832813.arunandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;


public class DisplayMessageActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_display_message);

        //Get the intent which created the activity;
        Intent intentparent = getIntent();
        String MessageInIntent = intentparent.getStringExtra(ARListFragment.LIST_MESSAGE);

        //Create a new TextView to show the message;
       /* TextView textbox = new TextView(this);
        textbox.setTextSize(40);
        textbox.setText(MessageInIntent);
*/
        // Set the new text message in
        //Set Text View as Content Layout;
        setContentView(R.layout.activity_display_message);


        // Give the new text message in the activity layout
//        TextView textbox = (TextView) findViewById(R.id.newactivitytextview);
//        textbox.setText(MessageInIntent);

        //Create the view for view pager

        Fragment slidingTabFragment = new ARSlidingTabFragment();

        FragmentTransaction arFragmentTransaction=  getSupportFragmentManager().beginTransaction();
        arFragmentTransaction.replace(R.id.tab_layout_fragment,slidingTabFragment);
        arFragmentTransaction.commit();
//
//        ViewPager arviewPager=(ViewPager) findViewById(R.id.countrypager);
//        ARTabFragmentStateAdapter arTabFragmentStateAdapter = new ARTabFragmentStateAdapter(getSupportFragmentManager());
//        arviewPager.setAdapter(arTabFragmentStateAdapter);





        }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
