package org.misikovich;

public class CharShortMap {
    private final char[] keys;
    private final short[] values;

    public CharShortMap(char[] keys, short[] values) {
        this.keys = keys;
        this.values = values;
    }

    public short get(char key) {
        for (int i = 0; i < keys.length; i++) {
            if (key == keys[i]) {
                return values[i];
            }
        }
        return Short.MIN_VALUE;
    }
}