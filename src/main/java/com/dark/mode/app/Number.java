package main.java.com.dark.mode.app;

import static main.java.com.dark.mode.dictionary.Dictionary.*;
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

    public String toWords(long num) {
        if (num == 0L) return "";

        String word;

        if (num < 20L) { //ones
            word = ONES[Math.toIntExact(num - 1)];
        } else if (num < 100L) { //tens
            word = String.format("%s %s", TENS[Math.toIntExact((num / 10L) - 2)], toWords(num % 10L));
        } else if (num < 1_000L) { //hundreds
            word = String.format("%s %s %s", toWords(num / 100L), HUNDREDS[0], toWords(num % 100L));
        } else if (num < 1_000_000L) { //thousands
            var round = toWords(num % 1_000L);
            word = String.format("%s %s%s %s", toWords(num / 1_000L), HUNDREDS[1], separator(round), round);
        } else if (num < 1_000_000_000L) { //millions
            var round = toWords(num % 1_000_000L);
            word = String.format("%s %s%s %s", toWords(num / 1_000_000L), HUNDREDS[2], separator(round), round);
        } else if (num < 1_000_000_000_000L) { //billions
            var round = toWords(num % 1_000_000_000L);
            word = String.format("%s %s%s %s", toWords(num / 1_000_000_000L), HUNDREDS[3], separator(round), round);
        } else if (num < 1_000_000_000_000_000L) { //trillions
            var round = toWords(num % 1_000_000_000_000L);
            word = String.format("%s %s%s %s", toWords(num / 1_000_000_000_000L), HUNDREDS[4], separator(round), round);
        } else {
            word = "not supported";
        }

        return word.trim();
    }

}
