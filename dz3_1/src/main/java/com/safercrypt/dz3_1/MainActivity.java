package com.safercrypt.dz3_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

// 1)Пользователь имеет возможность вводить текст, который появляется в списке.
// Сделай такую проверку, чтобы в списке были только уникальные строки.
// ГОТОВО

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button buttonSave, buttonView;
    private EditText editText;
    private Set<String>  mySet = new HashSet<>();
    //private List<Bed> newBed = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonView = (Button) findViewById(R.id.buttonView);
        editText = (EditText) findViewById(R.id.editText);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // сдесть будет реализация нажатия кнопки сохранить Сохранение будет в SetList
                // что б не было повторяющихся строк

                if (mySet.add(editText.getText().toString()) && !editText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Елемент добвален", Toast.LENGTH_SHORT).show();
                    textView.setText("в списке " + mySet.size() + "елементов");
                }
                else {
                    textView.setText("вы ничего не ввели или в списке уже есть такой елемент");


                }
            }
        });

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // сдесть будет реализация нажатия кнопки отобразить введенные данные
                textView.setText(mySet.toString());
            }
        });
    }
}
