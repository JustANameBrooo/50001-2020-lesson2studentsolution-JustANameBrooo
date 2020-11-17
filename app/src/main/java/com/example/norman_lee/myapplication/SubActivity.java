package com.example.norman_lee.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {

    Button buttonBackToCalculator;
    EditText editTextSubValueOfHome;  //A --> Home
    EditText editTextSubValueOfForeign;  //B --> Foreign
    public final static String INTENT_EXCH_RATE = "Exchange Rate";
    private SharedPreferences mPreferences;
    private String sharedPrefFile = "com.example.android.subsharedprefs";
    public final static String HOME_KEY = "HOME_KEY"; //A --> Home
    public final static String FOREIGN_KEY = "FOREIGN_KEY"; //B --> Foreign

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);


        //TODO 4.9 Implement saving to shared preferences for the contents of the EditText widget

        //TODO 3.5 ***Get references to the editText widgets
        //TODO 3.6 ***Get a reference to the Back To Calculator Button
        //TODO 3.7 ***Set up setOnClickListener
        //TODO 3.8 ***Obtain the values stored in the editTextWidgets

        editTextSubValueOfHome = findViewById(R.id.editTextSubValueHome);
        editTextSubValueOfForeign = findViewById(R.id.editTextSubValueForeign);
        buttonBackToCalculator = findViewById(R.id.buttonBackToCalculator);
        buttonBackToCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String home = editTextSubValueOfHome.getText().toString();
                    String foreign = editTextSubValueOfForeign.getText().toString();
                    //TODO 3.9, 3.12 (DO 3.11 yourself)-----------------
                    Utils.checkValidString(home);
                    Utils.checkValidString(foreign);
                    //TODO 3.10, skip 3.9, 3.12, 3.13
                    Intent intent = new Intent( SubActivity.this,
                            MainActivity.class);
                    intent.putExtra(HOME_KEY, home);
                    intent.putExtra(FOREIGN_KEY, foreign);
                    startActivity(intent);
                }catch(NumberFormatException ex){
                    Toast.makeText(SubActivity.this,
                            "Please enter a value",
                            Toast.LENGTH_LONG).show();
                }catch(IllegalArgumentException ex){
                    Toast.makeText(SubActivity.this,
                            ex.getMessage(),
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        //TODO 3.9 xCheck that these values are valid --> See the Utils class
        //TODO 3.10 ***Set up an explicit intent and pass the exchange rate back to MainActivity
        //TODO 3.11 xDecide how you are going to handle a divide-by-zero situation or when negative numbers are entered
        //TODO 3.12 xDecide how you are going to handle a situation when the editText widgets are empty

    }

    //TODO 4.10 Don't forget to override onPause()

}
