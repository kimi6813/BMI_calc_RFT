package com.example.link.bmi_calc_rft;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button_calc = (Button) findViewById(R.id.bt_calc);
        final EditText field_weight = (EditText) findViewById(R.id.field_weight);
        final EditText field_height = (EditText) findViewById(R.id.field_height);
        final TextView view_result = (TextView) findViewById(R.id.view_result);
        final TextView view_msg = (TextView) findViewById(R.id.view_msg);

        button_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);

                double weight;
                double height;
                double bmi;
                String msg = "";

                if(field_height.getText().toString().equals("") || field_weight.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "No invalid values!", Toast.LENGTH_LONG);
                }
                else
                {
                    weight = Double.parseDouble(field_weight.getText().toString());
                    height = Double.parseDouble(field_height.getText().toString());

                    bmi = height * height;
                    bmi = weight / bmi;

                    view_result.setText(String.valueOf(bmi));

                    if (bmi < 18.5) {
                        msg = "Underweight!";
                    } else if (bmi > 18.5 && bmi < 24.9) {
                        msg = "Healthy weight!";
                    } else if (bmi > 25.0 && bmi < 29.9) {
                        msg = "Overweight!";
                    } else if (bmi > 30.0) {
                        msg = "Obese!";
                    }
                    view_msg.setText(msg);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
