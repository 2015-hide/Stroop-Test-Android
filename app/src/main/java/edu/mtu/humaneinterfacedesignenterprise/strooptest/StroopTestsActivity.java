package edu.mtu.humaneinterfacedesignenterprise.strooptest;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.content.Context;

import java.util.ArrayList;


public class StroopTestsActivity extends ActionBarActivity {

    private int[] cards;
    private int transparentCard;
    private ImageView stroopView;
    private final Context context = this;
    @Override
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

            transparentCard = R.drawable.transparent;
            stroopView = (ImageView) findViewById(R.id.stroopView);

            if (cards == null) {
                generateCardsList();
            }

            if (test) {
                test40KM();
            }

            else {
                test60KM();
            }
        }
    }

    private void test40KM() {
        System.gc();

        final Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            volatile int i = 0;

            public void run() {
                System.out.println("HERE " + i);

                if (i == 25) {
                    // goes back to main menu
                    startActivity(new Intent(context, StroopActivity.class));
                    finish();
                    return;
                }
                
                stroopView.setImageResource(cards[i]);
                
                int timing;

                if (i == 0) {
                    timing = 35000;
                }

                else if (i == 12) {
                    timing = 15000;
                }

                else if ((i & 1) == 0) { // even - sets up time for next stroop card
                    timing = 11000;
                }

                else { // odd
                    timing = 3000;
                }

                ++i;

                handler.postDelayed(this, timing); // Set up next card to appear at the determined time.
            }
        };

        handler.postDelayed(runnable, 0); // Initial delay before the start - 0 ms.
    }

    private void test60KM() {
        System.gc();

        final Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            volatile int i = 0;

            public void run() {
                if (i == 25) {
                    startActivity(new Intent(context, StroopActivity.class));
                    finish();
                    return;
                }
                
                stroopView.setImageResource(cards[i]);
                
                int timing;

                if (i == 0) {
                    timing = 23500;
                }

                else if (i == 12) {
                    timing = 7500;
                }

                else if ((i & 1) == 0) { // even
                    timing = 6000;
                }

                else {
                    timing = 3000;
                }

                ++i;

                handler.postDelayed(this, timing); // Set up next card to appear at the determined time.
            }
        };

        handler.postDelayed(runnable, 0); // Initial delay before the start - 0 ms.
    }

    private void generateCardsList() {
        cards = new int[25];

        cards[0] = (transparentCard);
        cards[1] = (R.drawable.one);
        cards[2] = (transparentCard);
        cards[3] = (R.drawable.two);
        cards[4] = (transparentCard);
        cards[5] = (R.drawable.three);
        cards[6] = (transparentCard);
        cards[7] = (R.drawable.four);
        cards[8] = (transparentCard);
        cards[9] = (R.drawable.five);
        cards[10] = (transparentCard);
        cards[11] = (R.drawable.six);
        cards[12] = (transparentCard);
        cards[13] = (R.drawable.seven);
        cards[14] = (transparentCard);
        cards[15] = (R.drawable.eight);
        cards[16] = (transparentCard);
        cards[17] = (R.drawable.nine);
        cards[18] = (transparentCard);
        cards[19] = (R.drawable.ten);
        cards[20] = (transparentCard);
        cards[21] = (R.drawable.eleven);
        cards[22] = (transparentCard);
        cards[23] = (R.drawable.twelve);
        cards[24] = (transparentCard);
    }


}
