package br.com.rbs.translator.converter;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.util.StringUtils.isEmpty;

public class MorseConverter {

    private static final String SEPARATOR = " ";
    private static final Map<Character, String> encode;
    private static final Map<String, String> decode;

    static {
        encode = encode();
        decode = decode();
    }

    public static String encode(String text) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toUpperCase().toCharArray()) {
            result.append(encode.get(character));
        }

        return result.toString().trim();
    }

    public static String decode(String text) {
        StringBuilder result = new StringBuilder();
        for (String character : text.split(SEPARATOR)) {
            String code = decode.get(character);
            result.append(isEmpty(code) ? SEPARATOR : code);
        }

        return result.toString().trim();
    }

    private static Map<Character, String> encode() {
        Map<Character, String> encode = new HashMap<>();
        encode.put('A', " .-");
        encode.put('B', " -...");
        encode.put('C', " -.-.");
        encode.put('D', " -..");
        encode.put('E', " .");
        encode.put('F', " ..-.");
        encode.put('G', " --.");
        encode.put('H', " ....");
        encode.put('I', " ..");
        encode.put('J', " .---");
        encode.put('K', " -.-");
        encode.put('L', " .-..");
        encode.put('M', " --");
        encode.put('N', " -.");
        encode.put('O', " ---");
        encode.put('P', " .--.");
        encode.put('Q', " --.-");
        encode.put('R', " .-.");
        encode.put('S', " ...");
        encode.put('T', " -");
        encode.put('U', " ..-");
        encode.put('V', " ...-");
        encode.put('W', " .--");
        encode.put('X', " -..-");
        encode.put('Y', " -.--");
        encode.put('Z', " --..");
        encode.put('0', " -----");
        encode.put('1', " .----");
        encode.put('2', " ..---");
        encode.put('3', " ...--");
        encode.put('4', " ....-");
        encode.put('5', " .....");
        encode.put('6', " -....");
        encode.put('7', " --...");
        encode.put('8', " ---..");
        encode.put('9', " ----.");
        encode.put('.', " .-.-");
        encode.put(',', " --..--");
        encode.put('?', " ..--..");
        encode.put(' ', " ");
        return encode;
    }

    private static Map<String, String> decode() {
        Map<String, String> decode = new HashMap<>();
        decode.put(".-", "A");
        decode.put("-...", "B");
        decode.put("-.-.", "C");
        decode.put("-..", "D");
        decode.put(".", "E");
        decode.put("..-.", "F");
        decode.put("--.", "G");
        decode.put("....", "H");
        decode.put("..", "I");
        decode.put(".---", "J");
        decode.put("-.-", "K");
        decode.put(".-..", "L");
        decode.put("--", "M");
        decode.put("-.", "N");
        decode.put("---", "O");
        decode.put(".--.", "P");
        decode.put("--.-", "Q");
        decode.put(".-.", "R");
        decode.put("...", "S");
        decode.put("-", "T");
        decode.put("..-", "U");
        decode.put("...-", "V");
        decode.put(".--", "W");
        decode.put("-..-", "X");
        decode.put("-.--", "Y");
        decode.put("--..", "Z");
        decode.put("-----", "0");
        decode.put(".----", "1");
        decode.put("..---", "2");
        decode.put("...--", "3");
        decode.put("....-", "4");
        decode.put(".....", "5");
        decode.put("-....", "6");
        decode.put("--...", "7");
        decode.put("---..", "8");
        decode.put("----.", "9");
        decode.put(".-.-", ".");
        decode.put("--..--", ",");
        decode.put("..--..", "?");
        return decode;
    }
}
