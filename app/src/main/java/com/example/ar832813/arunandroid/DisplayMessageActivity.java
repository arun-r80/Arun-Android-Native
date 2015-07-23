package com.example.ar832813.arunandroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;


public class DisplayMessageActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_display_message);

        //Get the intent which created the activity;
        Intent intentparent = getIntent();
        String MessageInIntent = intentparent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //Create a new TextView to show the message;
       /* TextView textbox = new TextView(this);
        textbox.setTextSize(40);
        textbox.setText(MessageInIntent);
*/

        // Set the new text message in
        //Set Text View as Content Layout;
        setContentView(R.layout.activity_display_message);

        // Give the new text message in the activity layout
        TextView textbox = (TextView) findViewById(R.id.newactivitytextview);
        textbox.setText(MessageInIntent);




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
