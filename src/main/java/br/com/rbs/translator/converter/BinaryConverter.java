package br.com.rbs.translator.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.toBinaryString;
import static java.lang.String.format;
import static java.lang.String.join;
import static java.util.Arrays.stream;

public class BinaryConverter {

    private static final int BLOCK_SIZE = 8;
    private static final String SEPARATOR = " ";

    public static String encode(String input, boolean separator) {
        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(
                    format("%8s", toBinaryString(aChar))
                            .replaceAll(SEPARATOR, "0")
            );
        }

        return separator ? prettyBinary(result.toString()) : result.toString();
    }

    public static String decode(String input) {
        return stream(split(input))
                .map(binary -> Integer.parseInt(binary, 2))
                .map(Character::toString)
                .collect(Collectors.joining());
    }

    private static String[] split(final String input) {
        return prettyBinary(input.replaceAll("\\s", "")).split(SEPARATOR);
    }

    private static String prettyBinary(String binary) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < binary.length()) {
            result.add(binary.substring(index, Math.min(index + BLOCK_SIZE, binary.length())));
            index += BLOCK_SIZE;
        }
        return join(SEPARATOR, result);
    }
}
