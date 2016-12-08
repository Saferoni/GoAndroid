package com.safercrypt.dz5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/* Нужно
*Вывести в консоль строку из каждого метода жизненного цикла Activity.
* сделайте с помощью Shared Preferences такой функционал: если пользователь еще не авторизовался,
* то отправить его на логин скрин, в ином случае оставить его на главном скрине
*
*/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
