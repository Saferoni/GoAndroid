package com.safercrypt.ofline1;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    EditText editText;

    double x;
    int oststok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
    }

    public void onClick (View view) {
        if (editText.getText().toString().equals("")) {
            textView.setText("введите число");
        } else {
            x = Double.parseDouble(editText.getText().toString());
            textView.setText("остаток деления числа на 10 = " + x % 10);
            //Выводим тоаст
            int a = (int) x / 10;
            //выводим тоаст
            Toast.makeText(MainActivity.this, "" + a, Toast.LENGTH_SHORT).show();

            // Выводим в лог(консоль)
            Log.d(MainActivity.class.getName(), "" + (x * 1234));
            // выводим в снекбар
            Snackbar.make(findViewById(android.R.id.content), "" + 23, Snackbar.LENGTH_SHORT).show();
        }
    }
}


