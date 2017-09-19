package com.example.egor.guessthenumber;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HardMode extends AppCompatActivity {
    private TextView tvInfo2;
    private EditText etInput2;
    private Button bControl2;
    int guess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hard_mode);
        tvInfo2 = (TextView)findViewById(R.id.textView);
        etInput2 = (EditText)findViewById(R.id.editText3);
        bControl2 = (Button)findViewById(R.id.button2);
        guess = (int)(Math.random()*100);
        gameFinished = false;
    }

    public void onClick(View v) {
        if (etInput2.getText().toString().isEmpty() || !etInput2.getText().toString().matches("[01]+")) {
            tvInfo2.setText((getResources().getString(R.string.error)));
        } else if (!gameFinished){
            int inp = Integer.parseInt(etInput2.getText().toString(), 2);
            System.out.println(tvInfo2);
            if (inp > guess)
                tvInfo2.setText(getResources().getString(R.string.ahead));
            if (inp < guess)
                tvInfo2.setText(getResources().getString(R.string.behind));
            if (inp == guess)
            {
                tvInfo2.setText(getResources().getString(R.string.hit));
                bControl2.setText(getResources().getString(R.string.play_more));
                gameFinished = true;
            }
        } else {
            guess = (int)(Math.random()*100);
            bControl2.setText(getResources().getString(R.string.input_value));
            tvInfo2.setText(getResources().getString(R.string.try_to_guess));
            gameFinished = false;
        }
        etInput2.setText("");
    }

    public void easyMode(View v) {
        startActivity(new Intent(HardMode.this, MainActivity.class));
    }
}
