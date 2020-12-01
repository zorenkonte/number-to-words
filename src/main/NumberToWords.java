package main;

/**
 * Created by DarkModeee
 * User: DRKSDZRN
 * Date: 6/28/2019 | Friday, June 28, 2019
 * Time: 7:45 PM
 * Project: Number To Words
 * "Talk is Cheap, Show me the Code" - Linus Torvalds
 */
public class NumberToWords {

    private final String[] ones = {"one", "two", "three", "four",
            "five", "six", "seven", "eight",
            "nine", "ten", "eleven", "twelve",
            "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen",
            "nineteen"
    };
    private final String[] tens = {"twenty", "thirty", "forty",
            "fifty", "sixty", "seventy", "eighty",
            "ninety"
    };
    private final String[] hundreds = {"hundred", "thousand", "million", "billion", "trillion"};

    public String toWords(long num) {
        if (num == 0L) return "";

        String word;

        if (num < 20L) { //ones
            word = ones[Math.toIntExact(num - 1)];
        } else if (num < 100L) { //tens
            word = String.format("%s %s", tens[Math.toIntExact((num / 10L) - 2)], toWords(num % 10L));
        } else if (num < 1_000L) { //hundreds
            word = String.format("%s %s %s", toWords(num / 100L), hundreds[0], toWords(num % 100L));
        } else if (num < 1_000_000L) { //thousands
            var round = toWords(num % 1_000L);
            word = String.format("%s %s%s %s", toWords(num / 1_000L), hundreds[1], separator(round), round);
        } else if (num < 1_000_000_000L) { //millions
            var round = toWords(num % 1_000_000L);
            word = String.format("%s %s%s %s", toWords(num / 1_000_000L), hundreds[2], separator(round), round);
        } else if (num < 1_000_000_000_000L) { //billions
            var round = toWords(num % 1_000_000_000L);
            word = String.format("%s %s%s %s", toWords(num / 1_000_000_000L), hundreds[3], separator(round), round);
        } else if (num < 1_000_000_000_000_000L) { //trillions
            var round = toWords(num % 1_000_000_000_000L);
            word = String.format("%s %s%s %s", toWords(num / 1_000_000_000_000L), hundreds[4], separator(round), round);
        } else {
            word = "not supported";
        }

        return word.trim();
    }

    private String separator(String s) {
        return s.isEmpty() ? "" : ",";
    }
}
