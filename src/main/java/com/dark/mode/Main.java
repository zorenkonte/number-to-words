package main.java.com.dark.mode;

import main.java.com.dark.mode.app.Number;

public class Main {
    public static void main(String[] args) {
        long num = 912_231_532_423_123L;
        Number number = new Number();
        System.out.printf("%s -> %s \n", num, number.toWords(num));
    }
}
