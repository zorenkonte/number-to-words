package main.java.com.dark.mode.utility;

public final class Utility {
    private Utility() {
    }

    public static String separator(String s, String c) {
        return s.isEmpty() ? "" : c;
    }

    public static String lowerCase(String s) {
        return s.toLowerCase();
    }

    public static String upperCase(String s) {
        return s.toUpperCase();
    }

    public static String sentenceCase(String s) {
        return Character.toTitleCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

    public static String titleCase(String s) {
        StringBuilder converted = new StringBuilder();
        boolean convertNext = true;
        for (char ch : s.toCharArray()) {
            if (!Character.isJavaIdentifierPart(ch)) {
                convertNext = true;
            } else if (convertNext) {
                ch = Character.toTitleCase(ch);
                convertNext = false;
            } else {
                ch = Character.toLowerCase(ch);
            }
            converted.append(ch);
        }

        return converted.toString();
    }

    public static String convertCase(LetterCase letterCase, String s) {
        String wordCase = "";
        switch (letterCase) {
            case UPPER_CASE:
                wordCase = upperCase(s);
                break;
            case TITLE_CASE:
                wordCase = titleCase(s);
                break;
            case SENTENCE_CASE:
                wordCase = sentenceCase(s);
                break;
            case LOWER_CASE:
                wordCase = lowerCase(s);
                break;
        }
        return wordCase;
    }

    public static String stringFormat(String format, Object... values) {
        return String.format(format, values);
    }

    public enum LetterCase {
        LOWER_CASE,
        UPPER_CASE,
        TITLE_CASE,
        SENTENCE_CASE
    }
}
