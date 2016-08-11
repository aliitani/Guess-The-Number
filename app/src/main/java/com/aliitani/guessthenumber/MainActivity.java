package com.aliitani.guessthenumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button startButton, valueButton, higher, lower;
    TextView titleScreen;
    int max = 1000, min = 1, guess = 500;
    String title = "Guess a number between 1 to 1000, and I will guess it!";
    String startButtonString = "START";
    boolean checkVisible = false;

    public void getStringonRestore(String t) {
        titleScreen = (TextView) findViewById(R.id.TitleScreen);
        titleScreen.setText(title);
    }
    public void setStartButtonString(String t) {
        startButton = (Button) findViewById(R.id.startButton);
        startButton.setText(t);
    }

    public void checkNumber(View view){
        valueButton = (Button) view;
        titleScreen =(TextView) findViewById(R.id.TitleScreen);

        if (valueButton.getText().toString().equals("Higher")) {
            min = guess;
            getStringonRestore(title);
            NextGuess();
        }else if (valueButton.getText().toString().equals("Lower")) {
            max = guess;
            getStringonRestore(title);
            NextGuess();
        }else if(valueButton.getText().toString().equals("Correct")) {
            lower = (Button) findViewById(R.id.downButton);
            higher = (Button) findViewById(R.id.upButton);
            title = "Play Again?";
            getStringonRestore(title);
            lower.setVisibility(View.GONE);
            higher.setVisibility(View.GONE);
            checkVisible = false;
            startButton = (Button) findViewById(R.id.startButton);
            startButtonString = "Play again?";
            setStartButtonString(startButtonString);
            startButton.setVisibility(View.VISIBLE);
        }
    }
    public void NextGuess() {
        titleScreen = (TextView) findViewById(R.id.TitleScreen);
        guess = (max + min) /2;
        title = "Higher or Lower than " + guess + "?";
        getStringonRestore(title);
    }
    public void startButton(View view){
        startButton = (Button) findViewById(R.id.startButton);
        if (startButton.getText().toString().equals("Correct")) {
            checkNumber(startButton);
        } else {
            lower = (Button) findViewById(R.id.downButton);
            higher = (Button) findViewById(R.id.upButton);

            lower.setVisibility(View.VISIBLE);
            higher.setVisibility(View.VISIBLE);
            checkVisible = true;
            max = 1001;
            min = 1;
            guess = 500;

            titleScreen = (TextView) findViewById(R.id.TitleScreen);
            title = "Is the number higher or lower than " + guess + "?";
            getStringonRestore(title);
            startButtonString = "Correct";
            setStartButtonString(startButtonString);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("max", max);
        outState.putInt("min", min);
        outState.putInt("guess", guess);
        outState.putString("title", title);
        outState.putString("startButton",  startButtonString);
        outState.putBoolean("checkVisible", checkVisible);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        max = savedInstanceState.getInt("max");
        min = savedInstanceState.getInt("min");
        guess = savedInstanceState.getInt("guess");
        checkVisible = savedInstanceState.getBoolean("checkVisible");
        if (checkVisible == true) {
            higher = (Button) findViewById(R.id.upButton);
            lower = (Button)findViewById(R.id.downButton);
            higher.setVisibility(View.VISIBLE);
            lower.setVisibility(View.VISIBLE);
        }

        startButtonString = savedInstanceState.getString("startButton");
        setStartButtonString(startButtonString);
        title = savedInstanceState.getString("title");
        getStringonRestore(title);

        System.out.println(guess + ""+ max + min + checkVisible+startButtonString);
    }
}
