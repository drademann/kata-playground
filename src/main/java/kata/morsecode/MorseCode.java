package kata.morsecode;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public final class MorseCode {

    private static final Map<String, String> CODES = new HashMap<>();

    static {
        CODES.put(".-", "A");
        CODES.put("-...", "B");
        CODES.put("-.-.", "C");
        CODES.put("_..", "D");
        CODES.put(".", "E");
        CODES.put("..-.", "F");
        CODES.put("--.", "G");
        CODES.put("....", "H");
        CODES.put("..", "I");
        CODES.put(".---", "J");
        CODES.put("-.-", "K");
        CODES.put(".-..", "L");
        CODES.put("--", "M");
        CODES.put("-.", "N");
        CODES.put("---", "O");
        CODES.put(".--.", "P");
        CODES.put("--.-", "Q");
        CODES.put(".-.", "R");
        CODES.put("...", "S");
        CODES.put("-", "T");
        CODES.put("..-", "U");
        CODES.put("...-", "V");
        CODES.put(".--", "W");
        CODES.put("-..-", "X");
        CODES.put("-.--", "Y");
        CODES.put("--..", "Z");

        CODES.put(".----", "1");
        CODES.put("..---", "2");
        CODES.put("...--", "3");
        CODES.put("....-", "4");
        CODES.put(".....", "5");
        CODES.put("-....", "6");
        CODES.put("--...", "7");
        CODES.put("---..", "8");
        CODES.put("----.", "9");
        CODES.put("-----", "0");

        CODES.put(".--.-", "Å");
        CODES.put(".-.-", "Ä");
        CODES.put(".-..-", "È");
        CODES.put("..-..", "É");
        CODES.put("---.", "Ö");
        CODES.put("..--", "Ü");
        CODES.put("...--..", "ß");
        CODES.put("----", "CH");
        CODES.put("--.--", "Ñ");
        CODES.put(".-.-.-", ".");
        CODES.put("--..--", ",");
        CODES.put("---...", ":");
        CODES.put("-.-.-.", ";");
        CODES.put("..--..", "?");
        CODES.put("-....-", "-");
        CODES.put("..--.-", "_");
        CODES.put("-.--.", "(");
        CODES.put("-.--.-", ")");
        CODES.put(".----.", "'");
        CODES.put("_..._", "=");
        CODES.put(".-.-.", "+");
        CODES.put("-..-.", "/");
        CODES.put(".--.-.", "@");
    }

    public static String get(String code) {
        if (CODES.containsKey(code)) {
            return CODES.get(code);
        }
        throw new IllegalArgumentException(format("unknown morse code '%s'", code));
    }
}
