/**
 * @author Eric Kosovec, Stephen Radachy, Neil Culbertson, Brian Berg, Kyle Timmerman.
 * March 28, 2015
 */
package edu.mtu.hide.strooptest;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;

import edu.mtu.humaneinterfacedesignenterprise.strooptest.R;

/**
 * The stroop activity, which is the stroop test itself.
 */
public class StroopActivity extends ActionBarActivity {

    @Override
    /**
     * Creates the game with the specified button that was clicked
     * by the user.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroop);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(66, 169, 61)));
        actionBar.setTitle(Html.fromHtml("<font color='#FFFFFF'>" + getString(R.string.app_name) + "</font>"));

        // create buttons 40 and 60 km/hr
        Button button40 = (Button) findViewById(R.id.km40button);
        Button button60 = (Button) findViewById(R.id.km60button);

        // creates button listener for when the user clicks the 40km test.
        button40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                to40KMTest();
            }
        });

        // creates button listener for when the user clicks the 60km test.
        button60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                to60KMTest();
            }
        });
    } // end of onCreate method

    /**
     * Begins the stroop test with 40 km/hr settings.
     */
    public void to40KMTest() {
        Intent intent = new Intent(this, StroopTestsActivity.class);
        intent.putExtra(StroopActivity.class.getName(), true);
        startActivity(intent);
    }

    /**
     * Begins the stroop test with 40 km/hr settings.
     */
    public void to60KMTest() {
        Intent intent = new Intent(this, StroopTestsActivity.class);
        intent.putExtra(StroopActivity.class.getName(), false);
        startActivity(intent);
    } // end of to60KMTest
} // end of class
