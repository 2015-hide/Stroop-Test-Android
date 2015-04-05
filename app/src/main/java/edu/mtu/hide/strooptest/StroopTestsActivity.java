/**
 * @author Eric Kosovec, Stephen Radachy, Neil Culbertson, Brian Berg, Kyle Timmerman.
 * March 28, 2015
 */
package edu.mtu.hide.strooptest;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.content.Context;

import java.util.ArrayList;

import edu.mtu.humaneinterfacedesignenterprise.strooptest.R;

/**
 *  This class creates a menu for the user to initiate the 40 or 60
 *  km/hr stroop test activity.
 */
public class StroopTestsActivity extends ActionBarActivity {

    // initialize Arraylist for the stroop cards
    private ArrayList<Integer> cards;
    // the transparent card counter to keep trakc number of transparent cards
    private int transparentCard;
    // the imageview for the menu
    private ImageView stroopView;
    final Context context = this;
    @Override
    /**
     * Creates menu for the stroop test by displaying two buttons marked
     * 40 km/hr and 60 km/hr and the hide logo.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroop_tests);

        // Hides the action bar that displays the activity title.
        getSupportActionBar().hide();

        transparentCard = R.drawable.transparent;

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        Intent intent = getIntent();

        if (intent != null) {
            boolean test = intent.getBooleanExtra(StroopActivity.class.getName(), true);

            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT);

            transparentCard = R.drawable.transparent;
            stroopView = (ImageView) findViewById(R.id.stroopView);
            generateCardsList();

            if (test) {
                test40KM();
            }

            else {
                test60KM();
            }
        }
    }

    /**
     * The 40 km/hr specified timings version for the stroop test.
     */
    private void test40KM() {
        final Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            int i = 0;

            //
            public void run() {
                if (i == 25) {
                    // goes back to main menu
                    startActivity(new Intent(context, StroopActivity.class));
                    return;
                }
                
                stroopView.setImageResource(cards.get(i));

                // timing variable
                int timing;

                // Up until card 1, will wait 35 seconds to display first card.
                if (i == 0) {
                    timing = 35000;
                }

                // At the 12th card, there will be a timing delay of 15 seconds.
                else if (i == 12) {
                    timing = 15000;
                }

                // the even cards with a stop of 11seconds.
                else if ((i & 1) == 0) { // even - sets up time for next stroop card
                    timing = 11000;
                }

                // Every other card will appear every three seconds.
                else { // odd
                    timing = 3000;
                }

                // increment card position
                i++;

                handler.postDelayed(this, timing); // Set up next card to appear at the determined time.
            }
        };

        handler.postDelayed(runnable, 0); // Initial delay before the start - 0 ms.
    }

    /**
     * The 60 km/hr timings version for the stroop test.
     */
    private void test60KM() {
        final Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            int i = 0;

            public void run() {
                if (i == 25) {
                    startActivity(new Intent(context, StroopActivity.class));
                    return;
                }
                
                stroopView.setImageResource(cards.get(i));

                // timing variable.
                int timing;

                // Up until card 1, will wait 23.5 seconds to display first card.
                if (i == 0) {
                    timing = 23500;
                }

                // At the 12th card, there will be a timing delay of 7.5 seconds.
                else if (i == 12) {
                    timing = 7500;
                }

                // the even cards with a stop of six seconds.
                else if ((i & 1) == 0) { // even
                    timing = 6000;
                }

                // Every other card will appear every three seconds.
                else {
                    timing = 3000;
                }

                // increment card position
                i++;

                handler.postDelayed(this, timing); // Set up next card to appear at the determined time.
            }
        };

        handler.postDelayed(runnable, 0); // Initial delay before the start - 0 ms.
    }

    /**
     * Generates card list consisting of twelve different cards for the
     * Stroop activity. YEAH!
     */
    private void generateCardsList() {
        cards = new ArrayList<Integer>();

        // add cards to arraylist.
        cards.add(transparentCard);
        cards.add(R.drawable.one);
        cards.add(transparentCard);
        cards.add(R.drawable.two);
        cards.add(transparentCard);
        cards.add(R.drawable.three);
        cards.add(transparentCard);
        cards.add(R.drawable.four);
        cards.add(transparentCard);
        cards.add(R.drawable.five);
        cards.add(transparentCard);
        cards.add(R.drawable.six);
        cards.add(transparentCard);
        cards.add(R.drawable.seven);
        cards.add(transparentCard);
        cards.add(R.drawable.eight);
        cards.add(transparentCard);
        cards.add(R.drawable.nine);
        cards.add(transparentCard);
        cards.add(R.drawable.ten);
        cards.add(transparentCard);
        cards.add(R.drawable.eleven);
        cards.add(transparentCard);
        cards.add(R.drawable.twelve);
        cards.add(transparentCard);
    }


}
