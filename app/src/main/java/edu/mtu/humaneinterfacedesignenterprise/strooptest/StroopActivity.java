package edu.mtu.humaneinterfacedesignenterprise.strooptest;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;


public class StroopActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroop);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(66, 169, 61)));
        actionBar.setTitle(Html.fromHtml("<font color='#FFFFFF'>" + getString(R.string.app_name) + "</font>"));

        Button button40 = (Button) findViewById(R.id.km40button);
        Button button60 = (Button) findViewById(R.id.km60button);

        button40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                to40KMTest();
            }
        });

        button60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                to60KMTest();
            }
        });
    }

    public void to40KMTest() {
        Intent intent = new Intent(this, StroopTestsActivity.class);
        intent.putExtra(StroopActivity.class.getName(), true);
        startActivity(intent);
    }

    public void to60KMTest() {
        Intent intent = new Intent(this, StroopTestsActivity.class);
        intent.putExtra(StroopActivity.class.getName(), false);
        startActivity(intent);
    }


}
