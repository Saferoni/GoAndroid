package com.safercrypt.modul8;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image);
        image(getBaseContext());
    }
    public void image(Context c){

        Picasso.with(c)
                .load(R.drawable.photo_2016_10_15_11_17_06)
                .resize(200, 100)
                .centerCrop()
                .into(imageView);
    }
}
