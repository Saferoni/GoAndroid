package com.safercrypt.dz3_1;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

// в данном примере постараюсь реализовать сразу все тербования ниже

// 1)Пользователь имеет возможность вводить текст, который появляется в списке.
// Сделай такую проверку, чтобы в списке были только уникальные строки. ГОТОВО
//
// 2) Пользователь имеет возможность вводить текст, который появляется в списке. Каждой строке
// должно соответствовать число, которое будет обозначать частоту ввода этой строки пользователем.
// При вводе строки, которая уже есть в списке, надо увеличивать такое число только для этой строки.
// Вывести все строки без повторений и числа, которые к ним относятся. Проверить, что при вводе
// числа напротив этих строк увеличиваются.ГОТОВО

// 3) Показать пример работы с WebView, ScrollView ГОТОВО.

public class MainActivity extends AppCompatActivity {

    private TextView textView, textView2;
    private Button buttonSave, buttonView;
    private EditText editText;
    private TreeSet<String> mySet = new TreeSet<>();
    private ArrayList<MyString> myList = new ArrayList<>();
    //private boolean truAdd = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonView = (Button) findViewById(R.id.buttonView);
        editText = (EditText) findViewById(R.id.editText);
        textView2 = (TextView) findViewById(R.id.textView2);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // сдесть будет реализация задания 1 нажатия кнопки сохранить Сохранение будет в hashSet или TreeSet
                // что б не было повторяющихся строк
                if (mySet.add(editText.getText().toString()) && !editText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Елемент добвален", Toast.LENGTH_SHORT).show();

                    textView.setText("в списке " + mySet.size() + "елементов");
                }
                else {
                    textView.setText("вы ничего не ввели или в списке уже есть такой елемент");
                    Snackbar.make(findViewById(android.R.id.content), "сделано", Snackbar.LENGTH_SHORT).show();


                }
                // тут реализация задания 2 на той же кнопке толко через  ArrayList
                if (!editText.getText().toString().equals("") && myList.size() >= 0) {
                    boolean truAdd = true;
                    if (myList.size() == 0) {
                        myList.add(new MyString(editText.getText().toString()));
                    }else {
                        for (int i = 0; i < myList.size(); i++){
                            if (myList.get(i).getS().equals(editText.getText().toString())) {
                                myList.get(i).increaseMyI();
                                truAdd = false;
                                break;
                            }
                        }
                    }
                    if (truAdd) myList.add(new MyString(editText.getText().toString()));
                }


            }
        });

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // сдесть будет реализация нажатия кнопки отобразить введенные данные
                // испрользую iterator для прозода по сету и выводу каждого елемента на новой строке
                Iterator <String> iterator = mySet.iterator();
                textView.setText(" ");
                while (iterator.hasNext()) {
                    textView.setText(textView.getText() + iterator.next() + "\n ");
                }
                // старая реализация просто вывода елементов
                //textView.setText(mySet.toString());

                //вывожу myList
                //textView2.setText(myList.toString());
                textView2.setText("");
                for (int i = 0; i < myList.size(); i++){
                   textView2.setText(textView2.getText() + myList.get(i).toString());
                }
            }
        });
    }
}
