package be.jorenfabre.ceasarscoding.utilities;

import java.util.HashMap;
import java.util.Map;

public class Converter {
    private static final Map<Character, Integer> map = new HashMap<>();
    private static final Map<Integer, Character> reverseMap = new HashMap<>();

    static {
        map.putAll(Map.of(
                'A', 1,
                'B', 2,
                'C', 3,
                'D', 4,
                'E', 5,
                'F', 6,
                'G', 7,
                'H', 8,
                'I', 9,
                'J', 10
        ));
        map.putAll(Map.of(
                'K', 11,
                'L', 12,
                'M', 13,
                'N', 14,
                'O', 15,
                'P', 16,
                'Q', 17,
                'R', 18,
                'S', 19,
                'T', 20
        ));
        map.putAll(Map.of(
                'U', 21,
                'V', 22,
                'W', 23,
                'X', 24,
                'Y', 25,
                'Z', 26,
                '[', 0
        ));

        map.forEach((key, value) -> reverseMap.put(value, key));
    }

    public static int toInt(char c) {
        return map.getOrDefault(c, Integer.MIN_VALUE);
    }

    public static char toChar(int i) {
        return reverseMap.getOrDefault(i, Character.MIN_VALUE);
    }
}
