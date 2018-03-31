package kata.romannumber;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class RomanNumberConverter {

    private static final List<RomanDigit> ROMAN_DIGITS;

    static {
        ROMAN_DIGITS = new LinkedList<>();
        ROMAN_DIGITS.add(new RomanDigit(1000, "M"));
        ROMAN_DIGITS.add(new RomanDigit(900, "CM"));
        ROMAN_DIGITS.add(new RomanDigit(500, "D"));
        ROMAN_DIGITS.add(new RomanDigit(400, "CD"));
        ROMAN_DIGITS.add(new RomanDigit(100, "C"));
        ROMAN_DIGITS.add(new RomanDigit(90, "XC"));
        ROMAN_DIGITS.add(new RomanDigit(50, "L"));
        ROMAN_DIGITS.add(new RomanDigit(40, "XL"));
        ROMAN_DIGITS.add(new RomanDigit(10, "X"));
        ROMAN_DIGITS.add(new RomanDigit(9, "IX"));
        ROMAN_DIGITS.add(new RomanDigit(5, "V"));
        ROMAN_DIGITS.add(new RomanDigit(4, "IV"));
        ROMAN_DIGITS.add(new RomanDigit(1, "I"));
    }

    public static String convert(int number) {
        StringBuilder roman = new StringBuilder(20);
        Iterator<RomanDigit> iterator = ROMAN_DIGITS.iterator();
        while (number > 0) {
            RomanDigit digit = iterator.next();
            while (number >= digit.decimalValue()) {
                roman.append(digit.romanDigit());
                number -= digit.decimalValue();
            }
        }
        return roman.toString();
    }

    private static class RomanDigit {
        private final int decimalValue;
        private final String romanDigit;

        RomanDigit(int decimalValue, String romanDigit) {
            this.decimalValue = decimalValue;
            this.romanDigit = romanDigit;
        }

        int decimalValue() {
            return decimalValue;
        }

        String romanDigit() {
            return romanDigit;
        }
    }

}
