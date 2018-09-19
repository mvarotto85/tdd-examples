package it.quid.tdd;

import javafx.util.Pair;

public class Calculator {
 
    int valueDisplayed;
 
    public Calculator() {
        this.valueDisplayed = 0;
    }
 
    public void add(int x) {
        this.valueDisplayed += x;
    }
 
    public int getResult() {
        return this.valueDisplayed;
    }

    public static Pair<Integer,Integer> integerDivision(int a, int b){
        return new Pair<>(a / b, a % b);
    }
}