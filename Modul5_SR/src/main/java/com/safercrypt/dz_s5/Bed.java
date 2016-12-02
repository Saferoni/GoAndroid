package com.safercrypt.dz_s5;

/**
 * Created by pavelsafronov on 02.12.16.
 */

public class Bed {
    private String weight, type, elements;


    public Bed(String weight, String type, String elements) {
        this.weight = weight;
        this.type = type;
        this.elements = elements;
    }

    public String getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }

    public String getElements() {
        return elements;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setElements(String elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return "Запрашиваемая вами кровать имеет:" + "\n" +
                "Длинну = " + weight + "\n" +
                "Тип = " + type + "\n" +
                "Количество элементов = " + elements + "\n" ;
    }
}
