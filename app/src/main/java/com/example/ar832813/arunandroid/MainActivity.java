package com.example.ar832813.arunandroid;

import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.MenuCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.widget.ShareActionProvider;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "com.example.ar832813.arunandroid.MESSAGE";

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create event listener on button in Main Activity
        // To send the text information to the next activity
        Button buttonsend = (Button)findViewById(R.id.send_button);
        buttonsend.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent
                Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
                // Get the content of Label
                EditText editText = (EditText) findViewById(R.id.edit_message);
                String message = editText.getText().toString();
                // Add message to the intent object
                intent.putExtra(EXTRA_MESSAGE,message);

                //Start the activity
                startActivity(intent);
            }
        });
        // REcreate instance state for EditText view
        if (savedInstanceState != null) {
            //Get char sequence from the bundle;
            CharSequence CharSequenceEditText = savedInstanceState.getCharSequence("EDIT_TEXT_VALUE");

            // Assign the char sequence to the Activity's EditText
            EditText saveInstanceEditText = (EditText) findViewById(R.id.edit_message);
            saveInstanceEditText.setText(CharSequenceEditText);
        }
//        Add dynamic fragment on clicking the button
        Button buttonfragment = (Button)findViewById(R.id.fragment_button);
//        buttonfragment.setOnClickListener(new OnClickListener(){
//            // Provide an implemention for onClick to add fragment
//
//            @Override
//            public void onClick(View view){
//              //  Log.v("Fragment", "Fragment Created");
//                if (findViewById(R.id.frame_fragment) != null) {
//                    //check if the view is not already
//                    if(savedInstanceState != null){
//
//                        return;
//                    }
//
//                    // Create new fragment
//
//                    ARListFragment firstFragment = new ARListFragment();
//
//                    ArrayList flagArrayList = new ArrayList<Integer>(Arrays.asList(R.drawable.flag_india,R.drawable.flag_us));
//                    ArrayList countryArrayList = new ArrayList<String>(Arrays.asList("India","US"));
//                    ArrayList currencyArrayList = new ArrayList<String>(Arrays.asList( "Rupee","US Dollar"));
//                    Bundle argsBundle = new Bundle();
//
//
//                    argsBundle.putIntegerArrayList("flaglist",flagArrayList);
//                    argsBundle.putStringArrayList("countryname",countryArrayList);
//                    argsBundle.putStringArrayList("currencylist",currencyArrayList);
//                    firstFragment.setArguments(argsBundle);
//
//                    //Add details from Intent to the Fragment
//                    //firstFragment.setArguments(getIntent().getExtras());
//                    if( R.id.frame_fragment == 0){
//                        //Log.v("Fragment","Invalid fragment id");
//                        return;
//                    }
//                    /*android.app.FragmentManager fragmentManager = getFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    */
//
//                    int commit = getSupportFragmentManager().beginTransaction().add(R.id.frame_fragment, firstFragment).commit();
//                   // Log.v("Fragment","Committed Fragment");
//                }
//              //  Log.v("Fragment","I went throuhg");
//                return;
//
//            }
//        });

        // Create adapter for viewpager
        ViewPager tabViewPager = (ViewPager)findViewById(R.id.countrypager);
        ARTabFragmentStateAdapter arTabFragmentStateAdapter = new ARTabFragmentStateAdapter(getSupportFragmentManager());
        tabViewPager.setAdapter(arTabFragmentStateAdapter);

        }

//  Save Activity instance

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate menu resource file
        getMenuInflater().inflate(R.menu.menu_main,menu);

        //Create intent for Share menu;
        Intent intentShare = new Intent();
        intentShare.setAction(Intent.ACTION_SEND);
        intentShare.putExtra(Intent.EXTRA_TEXT,"Intent to Share");
        intentShare.setType("text/plain");

        //Get menuitem for the selected menu item
        MenuItem itemShare = menu.findItem(R.id.share_main_activity);

        ShareActionProvider shareActionProviderIntent = new ShareActionProvider(this);
        if ( MenuItemCompat.getActionProvider(itemShare) == null) {
          //  Log.v("Activity","Share Action Provider not returned");
        }
        shareActionProviderIntent = (ShareActionProvider) MenuItemCompat.getActionProvider(itemShare);
        if (shareActionProviderIntent == null ){
          //  Log.v("Activity","Null share Action Provider");
            return true;
        }

        shareActionProviderIntent.setShareIntent(intentShare);
       // Log.v("Activity","Share Intent set");
        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){

        //Get the char sequence of the EditText field;
        EditText saveInstanceEditText = (EditText)findViewById(R.id.edit_message);
        CharSequence CharSequenceEditText = saveInstanceEditText.getText();
        System.out.println(CharSequenceEditText);
        // put the charsequence in the Bundle
        savedInstanceState.putCharSequence("EDIT_TEXT_VALUE", CharSequenceEditText);

        //Call the parent method
        super.onSaveInstanceState(savedInstanceState);

    }

    //Recreate the activity with values for EditText
    public void onRestoreInstanceState(Bundle savedInstanceState){

        // Call super class method
        super.onRestoreInstanceState(savedInstanceState);

        //Get char sequence from the bundle;
        CharSequence CharSequenceEditText  = savedInstanceState.getCharSequence("EDIT_TEXT_VALUE");

        // Assign the char sequence to the Activity's EditText
        EditText saveInstanceEditText = (EditText)findViewById(R.id.edit_message);
        saveInstanceEditText.setText(CharSequenceEditText);

    }

//    Handle screen touch event
     @Override
  public boolean onTouchEvent(MotionEvent ev){
       // ActionBar actionBarStatus = getSupportActionBar();
        // actionBarActivityCurrent = getSupportActionBar();
         int Action_Received = ev.getActionMasked();
         android.support.v7.app.ActionBar actionBar = getSupportActionBar();
         switch (ev.getActionMasked()) {
             case (MotionEvent.ACTION_DOWN) :
                 if (actionBar.isShowing()) {
                 actionBar.hide();
             } else {
                 actionBar.show();
             }
             default:
                 break;
         }
         return true;//super.onTouchEvent(ev);
     }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()){
            case R.id.action_search :
                openSearch();
                return true;
            case R.id.action_settings :
                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    //Create class sendMessage to create new activity
    public void sendMessage(View view){
        // Create an Intent
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        // Get the content of Label
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        // Add message to the intent object
        intent.putExtra(EXTRA_MESSAGE,message);

        //Start the activity
        startActivity(intent);
    }

    public void openSearch() {
        //Perform actions for Search
    }

    public void openSettings(){
//        Perform actions for Settings

    }

    //Create static class for tab fragments manager
    public static class ARTabFragmentStateAdapter extends android.support.v4.app.FragmentStatePagerAdapter {

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

                 ArrayList flagArrayList = new ArrayList<Integer>(Arrays.asList(R.drawable.flag_india,R.drawable.flag_us));
                 ArrayList countryArrayList = new ArrayList<String>(Arrays.asList("India","US"));
                 ArrayList currencyArrayList = new ArrayList<String>(Arrays.asList( "Rupee","US Dollar"));
                 Bundle argsBundle = new Bundle();


                 argsBundle.putIntegerArrayList("flaglist",flagArrayList);
                 argsBundle.putStringArrayList("countryname",countryArrayList);
                 argsBundle.putStringArrayList("currencylist",currencyArrayList);
                 firstFragmentTab.setArguments(argsBundle);
                 Log.v("countries","Friendly");
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

}
