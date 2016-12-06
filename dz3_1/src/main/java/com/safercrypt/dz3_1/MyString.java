package com.safercrypt.dz3_1;

/**
 * Created by pavelsafronov on 05.12.16.
 */

public class MyString {
    private int i = 1;
    private String s;

    public MyString(String s) {
        this.s = s;
    }

    // метод увеличивает занчение i на 1
    public void increaseMyI(){
        i++;
    }
    public void setI(int i) {
        this.i = i;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getS() {

        return s;
    }

    public int getI() {
        return i;
    }

    @Override
    public String toString() {
        return  i + " " + s + "\n";
    }
}
