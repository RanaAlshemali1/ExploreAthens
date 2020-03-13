package edu.uga.cs.exploreathens;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.InputStream;

/**
 * child Class with the description options
 *
 * @author Rana Alshemali
 * @version Android Studio version 3.1
 */
public
class Description extends AppCompatActivity {

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        /**
         * call parent constructor
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        /**
         * define the imageViews
         */
        ImageView img= (ImageView) findViewById(R.id.imageView2);
        ImageView img1= (ImageView) findViewById(R.id.imageView4);

        TextView description = (TextView) findViewById(R.id.textView);
        TextView title = (TextView) findViewById(R.id.textView4);

        /**
         * create intent to get selection value from parent
         */
        Intent intent = getIntent();
        String string = intent.getStringExtra(MainActivity.REST_TYPE);
        description.setMovementMethod(new ScrollingMovementMethod());
        title.setText(string + " Cuisine");

        /**
         * Based on selection display info and images from the resources
         */
        if(string.equals("American")){
            try {
                Resources res = getResources();
                InputStream in_s = res.openRawResource(R.raw.american);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                description.setText(new String(b));
                img.setImageResource(R.drawable.amer1);
                img1.setImageResource(R.drawable.amer2);
            } catch (Exception e) {
                description.setText("Error: can't show info text.");
            }

        }else if(string.equals("Chinese")){
            try {
                Resources res = getResources();
                InputStream in_s = res.openRawResource(R.raw.chinese);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                description.setText(new String(b));
                img.setImageResource(R.drawable.ch1);
                img1.setImageResource(R.drawable.ch2);
            } catch (Exception e) {
                description.setText("Error: can't show info text.");
            }
        }else if(string.equals("Mediterranean")){
            try {
                Resources res = getResources();
                InputStream in_s = res.openRawResource(R.raw.mediterranean);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                description.setText(new String(b));
                img.setImageResource(R.drawable.med1);
                img1.setImageResource(R.drawable.med2);
            } catch (Exception e) {
                description.setText("Error: can't show info text.");
            }
        }else if(string.equals("Mexican")){
            try {
                Resources res = getResources();
                InputStream in_s = res.openRawResource(R.raw.mexican);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                description.setText(new String(b));
                img.setImageResource(R.drawable.mex1);
                img1.setImageResource(R.drawable.mex2);
            } catch (Exception e) {
                description.setText("Error: can't show info text.");
            }
        }else if(string.equals("Thai")){
            try {
                Resources res = getResources();
                InputStream in_s = res.openRawResource(R.raw.thai);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                description.setText(new String(b));
                img.setImageResource(R.drawable.th1);
                img1.setImageResource(R.drawable.th2);
            } catch (Exception e) {
                description.setText("Error: can't show info text.");
            }
        }
    }
}