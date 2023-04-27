package org.misikovich;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RomanConverter converter = new RomanConverter();
        List<String> romanSequence = List.of("III", "LVIII", "MCMXCIV", "DCXXI");
        romanSequence.forEach(s -> System.out.println(s + " - " + converter.convertToInteger(s)));
    }
}