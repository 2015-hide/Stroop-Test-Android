package edu.mtu.humaneinterfacedesignenterprise.strooptest;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;


public class StroopTestsActivity extends ActionBarActivity {

    private ArrayList<Integer> cards;
    private int transparentCard;
    private int currentCard;
    private ImageView stroopView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroop_tests);

        transparentCard = R.drawable.transparent;
        currentCard = 0;

        generateCardsList();

        // TODO: Get the intent and figure out from what it sent which test it is, then call that method.

        stroopView = (ImageView) findViewById(R.id.stroopView);
    }

    private void fourtyKMPerHour() {
        if (cards == null) {
            generateCardsList();
        }

        double[] times = new double[12];

        times[0] = 48.115; // time from start of simulator to the middle of first 2 signs

        /* Generate times from start stroop cards should appear. */
        for (int inc = 1; inc < times.length; ++inc) {
            if (inc == 6) {
                times[inc] = times[inc - 1] + 16.95; // To get cards closer to sign
            }
            else {
                times[inc] = times[inc - 1] + 12.95; // Time between each sign
            }
        }

        Handler mHandler = new Handler();

        // Set up events to run to display the cards in succession after a
        // period of time.
        for (int i = 0; i < times.length; ++i) {
            // Stroop card.
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    updateDisplay();
                }
            }, (int)(times[i] * 1000.));

            // Transparent card
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    updateDisplay();
                }
            }, (int)((times[i] + 3) * 1000.));
        }
    }

    private void sixtyKMPerHour() {
        if (cards == null) {
            generateCardsList();
        }

        double[] times = new double[12];

        times[0] = 23.5;

        /* Generate times from start stroop cards should appear. */
        for (int inc = 1; inc < times.length; ++inc) {
            if (inc == 6) {
                times[inc] = times[inc - 1] + 10.5;
            }
            else {
                times[inc] = times[inc - 1] + 9;
            }
        }

        Handler mHandler = new Handler();

        // Set up events to run to display the cards in succession after a
        // period of time.
        for (int i = 0; i < times.length; ++i) {
            // Stroop card.
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    updateDisplay();
                }
            }, (int)(times[i] * 1000.));

            // Transparent card
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    updateDisplay();
                }
            }, (int)((times[i] + 3) * 1000.));
        }
    }

    private void updateDisplay() {
        if (cards == null || stroopView == null) {
            return;
        }

        if (currentCard == cards.size() || currentCard < 0) {
            currentCard = 0;
        }

        stroopView.setImageResource(cards.get(currentCard));
    }

    private void generateCardsList() {
        cards = new ArrayList<Integer>();

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
