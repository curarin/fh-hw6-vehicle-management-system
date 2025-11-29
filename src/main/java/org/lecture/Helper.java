package org.lecture;

public class Helper {

    public boolean hasNullValues(String line, String delimiter) {
        String[] fields = line.split(delimiter);
        for (String field : fields) {
            if (field.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCorrectDelimiter(String line, String delimiter) {
        String[] possibleDelimiterValues = {";", ",", "|", "\\t"};
        int countDelimiterFound = 0;

        for (String possibleValue : possibleDelimiterValues) {
            // Source: https://stackoverflow.com/questions/275944/how-do-i-count-the-number-of-occurrences-of-a-char-in-a-string
            int count = line.length() - line.replace(possibleValue, "").length();
            if (count > 0) {
                countDelimiterFound++;
            }
        }
        return countDelimiterFound <= 1;
    }
}
