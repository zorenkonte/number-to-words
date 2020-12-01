package main;

public class Main {
    public static void main(String[] args) {
        long num = 912_231_532_423_123L;
        NumberToWords numberToWords = new NumberToWords();
        System.out.printf("%s -> %s \n", num, numberToWords.toWords(num));
    }
}
