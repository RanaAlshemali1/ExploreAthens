package edu.uga.cs.exploreathens;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Parent Class with the main options
 *
 * @author Rana Alshemali
 * @version Android Studio version 3.1
 */
public
class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    /**
     * Create TextView, Spinner, and two buttons
     */
    public static final String REST_TYPE = "edu.uga.cs.exploreathens.REST_TYPE";
    private Button descB;
    private Button resB;
    private Spinner spinner;
    private String restType;
    private TextView overview;

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        /**
         * Call parent constructor
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Display the app overview
         */
        overview = (TextView) findViewById(R.id.textView5);
        try {
            Resources res = getResources();
            InputStream input = res.openRawResource(R.raw.overview);
            byte[] b = new byte[input.available()];
            input.read(b);
            overview.setText(new String(b));
        } catch (IOException e) {
            overview.setText("Error: can't show info text.");
        }

        /**
         * define the buttons
         */
        descB = (Button) findViewById(R.id.button);
        resB = (Button) findViewById(R.id.button2);

        descB.setOnClickListener(new ButtonClickListener());
        resB.setOnClickListener(new ButtonClickListener());

        /**
         * Create the spinner
         */
        spinner = (Spinner) findViewById(R.id.Spinner01);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cuisines, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setPrompt("Please Select a Cuisine");
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public
    void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public
    void onNothingSelected(AdapterView<?> parent) {

    }

    /**
     * Create Button listener for each of the buttons to call chid
     */
    private
    class ButtonClickListener implements View.OnClickListener {

        @Override
        public
        void onClick(View view) {
            /**
             * call the corresponding child for each button
             */
            restType = spinner.getSelectedItem().toString();
            if (view.getId() == descB.getId()) {
                Intent desIntent = new Intent(view.getContext(), Description.class);
                desIntent.putExtra(REST_TYPE, restType);
                view.getContext().startActivity(desIntent);
            } else if (view.getId() == resB.getId()) {
                Intent resIntent = new Intent(view.getContext(), Restaurants.class);
                resIntent.putExtra(REST_TYPE, restType);
                view.getContext().startActivity(resIntent);
            }
        }
    }
}
