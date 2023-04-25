package org.misikovich;


class RomanConverter {
    private final CharShortMap valueMap =
            new CharShortMap(
                    new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'},
                    new short[]{1, 5, 10, 50, 100, 500, 1000});

    public Integer convertToInteger(String roman) {
        char[] chars = roman.toCharArray();

        int totalValue = 0;
        short possiblyStacked;
        short curr;
        for (int i = 0; i < chars.length; i++) { // iter through every character
            curr = valueMap.get(chars[i]);
            if (i + 1 < chars.length) {
                if ((possiblyStacked = tryToStack(curr, valueMap.get(chars[i + 1]))) != -1) {
                    totalValue += possiblyStacked;
                    i++;
                    continue;
                }
            }
            totalValue += curr;
        }
        return totalValue;
    }

    private short tryToStack(short s1, short s2) {
        if (s1 == 1) {
            if (s2 == 5) return 4;
            if (s2 == 10) return 9;
        } else if (s1 == 10) {
            if (s2 == 50) return 40;
            if (s2 == 100) return 90;
        } else if (s1 == 100) {
            if (s2 == 500) return 400;
            if (s2 == 1000) return 900;
        }
        return -1;
    }
}