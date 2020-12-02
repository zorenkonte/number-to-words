package main.java.com.dark.mode;

import main.java.com.dark.mode.app.Number;
import main.java.com.dark.mode.utility.Utility;

public class Main {
    public static void main(String[] args) {
        Number number = new Number(5123123L);
        number.setLetterCase(Utility.LetterCase.LOWER_CASE);
        System.out.println(number.getConvertedWord());
        number.setLetterCase(Utility.LetterCase.UPPER_CASE);
        System.out.println(number.getConvertedWord());
        number.setLetterCase(Utility.LetterCase.TITLE_CASE);
        System.out.println(number.getConvertedWord());
        number.setLetterCase(Utility.LetterCase.SENTENCE_CASE);
        System.out.println(number.getConvertedWord());
    }
}
