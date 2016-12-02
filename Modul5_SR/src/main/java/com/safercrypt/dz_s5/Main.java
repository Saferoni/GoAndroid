package com.safercrypt.dz_s5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


//Создать Кровать с полями
// вес
// сколько елементов на кровати
// тип кровати (двухместная одноместная или Роял
// вывесть все в текствью
// использовать енум, масивы, гетеры, спинеры и прочую разную лабуду

public class Main extends AppCompatActivity {

    private TextView textView;
    private Button buttonSave, buttonView;
    private EditText elements ;
    private Spinner weightView, bedType;
    private String[] weight = {"160", "180", "200", "220", "240" };
    private List<Bed> newBed = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonView = (Button) findViewById(R.id.buttonView);
        weightView = (Spinner) findViewById(R.id.weight);
        bedType = (Spinner) findViewById(R.id.bedType);
        elements = (EditText) findViewById(R.id.elements);

        // реализую адаптер для Spiner из масива
        weightView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, weight));

        // реализация адаптера для Spiner зи Enum
        bedType.setAdapter(new ArrayAdapter<BedType>(this, android.R.layout.simple_list_item_1, BedType.values()));

        //обработка кнопки из лиснера
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (newBed != null && !elements.getText().toString().equals("")) {
                    textView.setText(newBed.toString());
                    Toast.makeText(getApplicationContext(), "Та на тебе все формы",Toast.LENGTH_SHORT).show();
                }
                else {
                    textView.setText("Заполните пожалуйста форму или сохраните");
                }
            }
        });
    }
        // обработка кнопки методом, вызывается из кнопки
    public void onClickSave(View view) {
        if (elements.getText().toString().equals("")) textView.setText("Вы не ввели количество элементов");
        else {
            newBed.add(new Bed(
                    weightView.getSelectedItem().toString(),
                    bedType.getSelectedItem().toString(),
                    elements.getText().toString()));

            Toast.makeText(getApplicationContext(), "Ваша форма сохранена",Toast.LENGTH_SHORT).show();
        }
    }

}

