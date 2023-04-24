package org.misikovich;

import java.util.*;
import java.util.function.IntUnaryOperator;

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
        List<String> parsed = parseRoman(roman);
        int prev = 0;
        for (String s : parsed) {
            prev = actionMap.get(s).applyAsInt(prev);
        }
        System.gc();
        return prev;
    }

    public List<String> parseRoman(String roman) {
        String[] romanSplitEvery = roman.toUpperCase().split("");
        List<String> romanSplitOnDoubles = new ArrayList<>();
        List<String> romanDoubles = new ArrayList<>(List.of("IV", "IX", "XL", "XC", "CD", "CM"));
        for (int i = 0; i < romanSplitEvery.length - 1 ; i++) {
            String d = romanSplitEvery[i] + romanSplitEvery[i + 1];
            if (romanDoubles.contains(d)) {
                romanSplitEvery[i] = "";
                romanSplitEvery[i + 1] = "";
                romanSplitOnDoubles.add(d);
                i++;
            }
        }
        List<String> romansSplitted = new ArrayList<>();
        int i = 0;
        for (String s : romanSplitEvery) {
            if (s.equals("")) {
                if (i > 0 && i % 2 != 0) {
                    i++;
                    continue;
                }
                romansSplitted.add(romanSplitOnDoubles.get((i + 1) / 2));
                i++;
            } else {
                romansSplitted.add(s);
            }
        }
        return romansSplitted;
    }
}
