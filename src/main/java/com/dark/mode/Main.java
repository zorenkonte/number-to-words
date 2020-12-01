package main.java.com.dark.mode.app;

public class Main {
    public static void main(String[] args) {
        long num = 912_231_532_423_123L;
        Number numberToWords = new Number();
        System.out.printf("%s -> %s \n", num, numberToWords.toWords(num));
    }
}
