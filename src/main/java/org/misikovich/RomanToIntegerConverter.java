package org.misikovich;

import java.util.*;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class RomanToIntegerConverter {
    private final Map<String, IntUnaryOperator> actionMap;

    public RomanToIntegerConverter() {
        actionMap = new HashMap<>();
        actionMap.put("I", x -> x + 1);
        actionMap.put("V", x -> x + 5);
        actionMap.put("X", x -> x + 10);
        actionMap.put("L", x -> x + 50);
        actionMap.put("C", x -> x + 100);
        actionMap.put("D", x -> x + 500);
        actionMap.put("M", x -> x + 1000);

        actionMap.put("IV", x -> x + 4);
        actionMap.put("IX", x -> x + 9);
        actionMap.put("XL", x -> x + 40);
        actionMap.put("XC", x -> x + 90);
        actionMap.put("CD", x -> x + 400);
        actionMap.put("CM", x -> x + 900);
    }

    public Integer convertRoman(String roman) {
        roman = roman.toUpperCase();

        return 0;
    }

    private List<String> parseRoman(String roman) {
        String[] romanSplitOnDoubles = roman.toUpperCase().split("(?<=IV|IX|XL|XC|CD|CM)(?!$)");
        List<String> romanDoubles = new ArrayList<>(List.of("IV", "IX", "XL", "XC", "CD", "CM"));
        List<String> romansSplitted = new ArrayList<>();
        for (String s : romanSplitOnDoubles) {
            if (romanDoubles.contains(s)) romansSplitted.add(s);
            else {
                romansSplitted.addAll(Arrays.asList(s.split("")));
            }
        }
        return romansSplitted;
    }
}
