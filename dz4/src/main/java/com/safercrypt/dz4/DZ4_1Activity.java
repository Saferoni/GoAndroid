package com.safercrypt.dz4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by pavelsafronov on 07.12.16.
 *      ГОТОВО
 * 1) Добавить в xml-layout только TableLayout. Дальше добавить в TableLayout програмно
 * (динамически, из кода) пять рядов (TableRow) по пять Button в каждом.
 * Каждому создать рандомный текст и вывести на кнопку (setText()).
 * По нажатию на кнопку выводить во всплывающем сообщении каждый раз разный рандомный текст.
 */

public class DZ4_1Activity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Создам и лайаут из программы а фигли
        final TableLayout tableLayout = new TableLayout(this);
        tableLayout.setLayoutParams(new TableLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        tableLayout.setStretchAllColumns(true);

        // мотод для наполнения TableRow кнопками

        TableRow tableRow1 = new TableRow(this);
        TableRow tableRow2 = new TableRow(this);
        TableRow tableRow3 = new TableRow(this);
        TableRow tableRow4 = new TableRow(this);
        TableRow tableRow5 = new TableRow(this);

        // первый ряд кнопок
        Button button1 = new Button(this);
        buttonSet(button1);
        Button button2 = new Button(this);
        buttonSet(button2);
        Button button3 = new Button(this);
        buttonSet(button3);
        Button button4 = new Button(this);
        buttonSet(button4);
        Button button5 = new Button(this);
        buttonSet(button5);

        tableRow1.addView(button1);
        tableRow1.addView(button2);
        tableRow1.addView(button3);
        tableRow1.addView(button4);
        tableRow1.addView(button5);

        // второй ряд кнопок
        Button button6 = new Button(this);
        buttonSet(button6);
        Button button7 = new Button(this);
        buttonSet(button7);
        Button button8 = new Button(this);
        buttonSet(button8);
        Button button9 = new Button(this);
        buttonSet(button9);
        Button button10 = new Button(this);
        buttonSet(button10);

        tableRow2.addView(button6);
        tableRow2.addView(button7);
        tableRow2.addView(button8);
        tableRow2.addView(button9);
        tableRow2.addView(button10);


        // ну и так далее что их все писать надо подумать на оптимизацией
        Button button11 = new Button(this);
        Button button12 = new Button(this);
        Button button13 = new Button(this);
        Button button14 = new Button(this);
        Button button15 = new Button(this);

        Button button16 = new Button(this);
        Button button17 = new Button(this);
        Button button18 = new Button(this);
        Button button19 = new Button(this);
        Button button20 = new Button(this);

        Button button21 = new Button(this);
        Button button22 = new Button(this);
        Button button23 = new Button(this);
        Button button24 = new Button(this);
        Button button25 = new Button(this);

        tableLayout.addView(tableRow1);
        tableLayout.addView(tableRow2);
        setContentView(tableLayout);

    }
// метод настройки кнопки
    public void buttonSet(final Button button){
        button.setText(generateRandomString(5));
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                button.setText(generateRandomString(5));
            }
        });
    }

// метод геренрации случайной строки
    public static String generateRandomString(int size) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random RANDOM = new SecureRandom();
        String randomString = "";
        for (int i = 0; i < size; i++) {
            int index = (int) (RANDOM.nextDouble() * str.length());
            randomString += str.substring(index, index + 1);
        }
        return randomString;
    }
}
