package com.safercrypt.dz5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/* Нужно
*Вывести в консоль строку из каждого метода жизненного цикла Activity. ГОТОВО
* сделайте с помощью Shared Preferences такой функционал: если пользователь еще не авторизовался,
* то отправить его на логин скрин, в ином случае оставить его на главном скрине
*
*/
public class MainActivity extends AppCompatActivity {
    private Button buttonLogin, buttonLogOut;
    private EditText editViewFirstName, editViewLastName;
    private TextView textViewInfo;
    private LinearLayout layoutLogin, layoutApp;
    private SharedPrefLogin sharedPrefLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPrefLogin = new SharedPrefLogin(this);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogOut = (Button) findViewById(R.id.buttonLogOut);
        editViewFirstName = (EditText) findViewById(R.id.editViewFirstName);
        editViewLastName = (EditText) findViewById(R.id.editViewLastName);
        textViewInfo = (TextView) findViewById(R.id.textViewInfo);
        layoutLogin = (LinearLayout) findViewById(R.id.layoutLogin);
        layoutApp = (LinearLayout) findViewById(R.id.layoutApp);

        layoutApp.setVisibility(View.GONE);
        layoutLogin.setVisibility(View.GONE);

        if (sharedPrefLogin.getFirstName().isEmpty()){
            needLogin();
            Toast.makeText(this, "Вы не вошли в систему", Toast.LENGTH_SHORT).show();
        } else {
            isLogin();
        }
    }
    //обработка логина
    public void needLogin(){
        layoutLogin.setVisibility(View.VISIBLE);
        editViewLastName.setText("");
        editViewFirstName.setText("");
        textViewInfo.setText("привет Залогинтесь");
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editViewFirstName.getText().toString().equals("") ||
                        !editViewLastName.getText().toString().equals("")) {
                    sharedPrefLogin.setFirstName(editViewFirstName.getText().toString());
                    sharedPrefLogin.setLastName(editViewLastName.getText().toString());
                    layoutLogin.setVisibility(View.GONE);
                    isLogin();
                } else {
                    textViewInfo.setText("Вы не заполнили доно из полей, просьба заполнить");
                }
            }
        });
    }
    // Залогинениый пользователь
    public void isLogin(){
        layoutApp.setVisibility(View.VISIBLE);
        textViewInfo.setText("Вы вошли как: " +
                sharedPrefLogin.getFirstName() + " " +
                sharedPrefLogin.getLastName());
        buttonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    layoutApp.setVisibility(View.GONE);
                    sharedPrefLogin.setFirstName("");
                    sharedPrefLogin.setLastName("");
                    needLogin();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Домашнее задание 5","Это onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Домашнее задание 5","Это onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Домашнее задание 5","Это onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Домашнее задание 5","Это onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Домашнее задание 5","Это onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Домашнее задание 5","Это onDestroy");
    }
}
