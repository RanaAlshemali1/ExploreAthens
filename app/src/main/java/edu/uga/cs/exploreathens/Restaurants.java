package edu.uga.cs.exploreathens;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;

import java.io.InputStream;

public
class Restaurants extends AppCompatActivity {

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        /**
         * call parent constructor
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        /**
         * create intent to get selection value from parent
         */

        Intent intent = getIntent();
        TextView textView = (TextView) findViewById(R.id.textView2);
        String string = intent.getStringExtra(MainActivity.REST_TYPE);
        textView.setText(string + " Cuisine");

        TextView options = (TextView) findViewById(R.id.textView3);
        options.setMovementMethod(new ScrollingMovementMethod());

        /**
         * Based on selection display restaurants options for resources
         */

        if (string.equals("American")) {
            try {
                Resources res = getResources();
                InputStream in_s = res.openRawResource(R.raw.am_res);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                options.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                options.setText("Error: can't show info text.");
            }

        } else if (string.equals("Chinese")) {
            try {
                Resources res = getResources();
                InputStream in_s = res.openRawResource(R.raw.ch_res);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                options.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                options.setText("Error: can't show info text.");
            }
        } else if (string.equals("Mediterranean")) {
            try {
                Resources res = getResources();
                InputStream in_s = res.openRawResource(R.raw.med_res);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                options.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                options.setText("Error: can't show info text.");
            }
        } else if (string.equals("Mexican")) {
            try {
                Resources res = getResources();
                InputStream in_s = res.openRawResource(R.raw.mex_res);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                options.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                options.setText("Error: can't show info text.");
            }
        } else if (string.equals("Thai")) {
            try {
                Resources res = getResources();
                InputStream in_s = res.openRawResource(R.raw.th_res);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                options.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                options.setText("Error: can't show info text.");
            }
        }
    }
}
