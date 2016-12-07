package com.safercrypt.dz4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
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
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        TableRow tableRow1 = addTableRowWichButton(5);
        TableRow tableRow2 = addTableRowWichButton(5);
        TableRow tableRow3 = addTableRowWichButton(5);
        TableRow tableRow4 = addTableRowWichButton(5);
        TableRow tableRow5 = addTableRowWichButton(5);


        tableLayout.addView(tableRow1);
        tableLayout.addView(tableRow2);
        tableLayout.addView(tableRow3);
        tableLayout.addView(tableRow4);
        tableLayout.addView(tableRow5);
        setContentView(tableLayout);

    }
    // метод заполнения TableRow
    public TableRow addTableRowWichButton(int value){
        TableRow tableRaw = new TableRow(this);
        for (int i = 0; i < value; i++){
            tableRaw.addView(buttonSet(new Button(this)));
        }
        return tableRaw;
    }

    // метод настройки кнопки
    public Button buttonSet(final Button button){
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        buttonParams.weight = 1;  //не срабатывает
        //button.setLayoutParams(buttonParams); // почему тоданные параметры не срабатывают
        button.setText(generateRandomString(5));
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                button.setText(generateRandomString(5));
            }
        });
    return button;
    }

    // метод геренрации случайной строки
    public static String generateRandomString(int size) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        Random RANDOM = new SecureRandom();
        String randomString = "";
        for (int i = 0; i < size; i++) {
            int index = (int) (RANDOM.nextDouble() * str.length());
            randomString += str.substring(index, index + 1);
        }
        return randomString;
    }
}
