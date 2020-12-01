package main.java.com.dark.mode.app;

import main.java.com.dark.mode.utility.Utility;

import static main.java.com.dark.mode.dictionary.Dictionary.*;
import static main.java.com.dark.mode.utility.Utility.convertCase;
import static main.java.com.dark.mode.utility.Utility.separator;

/**
 * Created by DarkModeee
 * User: DRKSDZRN
 * Date: 6/28/2019 | Friday, June 28, 2019
 * Time: 7:45 PM
 * Project: Number To Words
 * "Talk is Cheap, Show me the Code" - Linus Torvalds
 */
public class Number {

    private String convertedWord;
    private Utility.LetterCase letterCase = Utility.LetterCase.LOWER_CASE;

    public Number() {
    }

    public Number(long number) {
        setNumber(number);
    }

    public Number(long number, Utility.LetterCase letterCase) {
        this(number);
        this.letterCase = letterCase;
    }

    public void setNumber(long number) {
        convertedWord = toWords(number);
    }

    public void setLetterCase(Utility.LetterCase letterCase) {
        this.letterCase = letterCase;
    }

    public String getConvertedWord() {
        if (convertedWord == null || convertedWord.equals("")) {
            throw new IllegalArgumentException("value must not be zero or null");
        }
        return convertCase(letterCase, convertedWord);
    }

    private String toWords(long n) {
        if (n == 0L) return "";

        String word;

        if (n < 20L) { //ones
            word = ONES[Math.toIntExact(n - 1)];
        } else if (n < 100L) { //tens
            var round = toWords(n % 10L);
            word = String.format("%s%s%s", TENS[Math.toIntExact((n / 10L) - 2)], separator(round, "-"), toWords(n % 10L));
        } else if (n < 1_000L) { //hundreds
            word = String.format("%s %s %s", toWords(n / 100L), HUNDREDS[0], toWords(n % 100L));
        } else if (n < 1_000_000L) { //thousands
            var round = toWords(n % 1_000L);
            word = String.format("%s %s%s %s", toWords(n / 1_000L), HUNDREDS[1], separator(round, ","), round);
        } else if (n < 1_000_000_000L) { //millions
            var round = toWords(n % 1_000_000L);
            word = String.format("%s %s%s %s", toWords(n / 1_000_000L), HUNDREDS[2], separator(round, ","), round);
        } else if (n < 1_000_000_000_000L) { //billions
            var round = toWords(n % 1_000_000_000L);
            word = String.format("%s %s%s %s", toWords(n / 1_000_000_000L), HUNDREDS[3], separator(round, ","), round);
        } else if (n < 1_000_000_000_000_000L) { //trillions
            var round = toWords(n % 1_000_000_000_000L);
            word = String.format("%s %s%s %s", toWords(n / 1_000_000_000_000L), HUNDREDS[4], separator(round, ","), round);
        } else {
            word = "not supported";
        }

        return word.trim();
    }

    @Override
    public String toString() {
        return "Number{" +
                "convertedWord='" + getConvertedWord() + '\'' +
                '}';
    }
}
