package edu.mtu.humaneinterfacedesignenterprise.strooptest;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;


public class StroopTestsActivity extends ActionBarActivity {

    private ArrayList<Integer> cards;
    private int transparentCard;
    private ImageView stroopView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroop_tests);

        getSupportActionBar().hide();

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        Intent intent = getIntent();

        if (intent != null) {
            boolean test = intent.getBooleanExtra(StroopActivity.class.getName(), true);

            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

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

    private void test40KM() {
        final Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            int i = 0;

            public void run() {
                stroopView.setImageResource(cards.get(i));
                int timing;

                if (i == 0) {
                    timing = 35000;
                }

                else if (i == 24) {
                    return;
                }

                else if (i == 12) {
                    timing = 15000;
                }

                else if ((i & 1) == 0) { // even
                    timing = 11000;
                }

                else { // odd
                    timing = 3000;
                }

                i++;

                handler.postDelayed(this, timing); // Set up next card to appear at the determined time.
            }
        };

        handler.postDelayed(runnable, 0); // Initial delay before the start - 0 ms.
    }

    private void test60KM() {
        final Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            int i = 0;

            public void run() {
                stroopView.setImageResource(cards.get(i));
                int timing;

                if (i == 0) {
                    timing = 23500;
                }

                else if (i == 24) {
                    return;
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

                i++;

                handler.postDelayed(this, timing); // Set up next card to appear at the determined time.
            }
        };

        handler.postDelayed(runnable, 0); // Initial delay before the start - 0 ms.
    }

    private void generateCardsList() {
        cards = new ArrayList<Integer>();

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
