package com.pavelsafronov.dz1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView, textViewF;
    Button button;
    EditText editText, editTextF;
    int i = 1;
    long index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        textViewF = (TextView) findViewById(R.id.textViewF);
        editTextF = (EditText) findViewById(R.id.editTextF);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

    }

    public void onClick(View view) {

        if (isMore12()){textView.setText((i = i + 2) +  " ");}
        if (i >= 23){textView.setText("I love GoIT so much");}
        else {
            textView.setText(i++ + " ");
        }
        if (editTextF.getText().toString().equals("")) {textViewF.setText("введите индекс Фибоначи");}
        else {
            fibonachi();
        }
    }

    public boolean isMore12(){
            return editText.getText().length() > 11;
    }

    public void fibonachi(){
        long lastIndex = 0;
        long nextIndex = 1;
        long fi = Long.parseLong(editTextF.getText().toString());

        if (fi == 2){textViewF.setText("1");}
        if (fi == 1){textViewF.setText("0");}
        if (fi <= 0){textViewF.setText("Нулевого и отрецательного индекса нету");}
        if (fi >= 3)
        {
            for (int i = 2; i < fi; i++) {
                index = nextIndex + lastIndex;
                lastIndex = nextIndex;
                nextIndex = index;
            }
            textViewF.setText(index + "");
        }
    }
}

