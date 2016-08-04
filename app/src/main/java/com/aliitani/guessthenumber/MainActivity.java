package com.aliitani.guessthenumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button startButton, valueButton, higher, lower, correct;
    TextView titleScreen;
    int max = 1000, min = 1, guess = 500;

    public void checkNumber(View view){
        valueButton = (Button) view;
        titleScreen =(TextView) findViewById(R.id.TitleScreen);

        if (valueButton.getText().toString().equals("Higher")) {
            min = guess;
            NextGuess();
        }
        if (valueButton.getText().toString().equals("Lower")) {
            max = guess;
            NextGuess();
        }
        if(valueButton.getText().toString().equals("Correct")) {
            titleScreen.setText("You won!");
            correct = (Button) findViewById(R.id.CorrectButton);
            lower = (Button) findViewById(R.id.downButton);
            higher = (Button) findViewById(R.id.upButton);
            titleScreen.setText("Play Again?");
            correct.setVisibility(View.GONE);
            lower.setVisibility(View.GONE);
            higher.setVisibility(View.GONE);
            startButton = (Button) findViewById(R.id.startGame);
            startButton.setText("Play Again?");
            startButton.setVisibility(View.VISIBLE);
        }
    }
    public void NextGuess() {
        titleScreen = (TextView) findViewById(R.id.TitleScreen);
        guess = (max + min) /2;
        titleScreen.setText("Higher or Lower than " + guess + "?");

    }
    public void startButton(View view){
        startButton = (Button) findViewById(R.id.startGame);
        correct = (Button) findViewById(R.id.CorrectButton);
        lower = (Button) findViewById(R.id.downButton);
        higher = (Button) findViewById(R.id.upButton);         startButton.setVisibility(View.GONE);
        correct.setVisibility(View.VISIBLE);
        lower.setVisibility(View.VISIBLE);
        higher.setVisibility(View.VISIBLE);
        titleScreen = (TextView) findViewById(R.id.TitleScreen);
        max = 1001;
        min = 1;
        guess = 500;

        titleScreen.setText("Is the number higher or lower than " + guess + "?");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }
}
