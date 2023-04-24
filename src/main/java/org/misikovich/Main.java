package org.misikovich;

public class Main {
    public static void main(String[] args) {
        RomanToIntegerConverter converter = new RomanToIntegerConverter();
        String roman = "LVIII";
        System.out.println(converter.convertRoman(roman));
    }
}