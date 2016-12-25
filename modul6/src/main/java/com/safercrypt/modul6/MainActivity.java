package com.safercrypt.modul6;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    int MY_INTENT = 1;
    Button button1, button2,button3, button4;
    EditText editText, editText2, editText3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);


        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Test.class);
                startActivityForResult(intent, MY_INTENT);
            }
        });


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri number = Uri.parse("tel:" + editText.getText().toString());
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_DIAL);
                sendIntent.setData(number);
                //sendIntent.putExtra(Intent.EXTRA_TEXT, number);
                //sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("http://" + editText3.getText().toString());
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

                    startActivity(intent);

            }
        });
    }
}
