package com.safercrypt.dz4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


// Сдесь реализовано 4 модуль домашнего задания постараюсь сделать весь в одном приложении как обычно
//
// 1) Добавить в xml-layout только TableLayout. Дальше добавить в TableLayout програмно
//      (динамически, из кода) пять рядов (TableRow) по пять Button в каждом.
//      Каждому создать рандомный текст и вывести на кнопку (setText()).
//      По нажатию на кнопку выводить во всплывающем сообщении каждый раз разный рандомный текст.
//
// 2) Сделай две задачи на массивы. Задачи можно найти тут. (две из кнопок выше будут
// обрабатывать данный запрос масивы будут по 20 значений
//
// 3) Показать пример работы GridLayout. (в 1 задании вместо TableLayout будет GridLayout

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.dz4_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DZ4_1Activity.class));
            }
        });
        findViewById(R.id.dz4_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DZ4_2Activity.class));
            }
        });
        findViewById(R.id.dz4_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(MainActivity.this, DZ4_3Activity.class));
            }
        });
    }








}
