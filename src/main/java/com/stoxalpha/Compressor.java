package com.stoxalpha;

public class Compressor {
    public String compress(String stringToCompress) {
        StringBuilder compressed = new StringBuilder();
        int charCounter = 0;
        for (int i = 0; i < stringToCompress.length(); i++) {
            charCounter++;

            if (i + 1 >= stringToCompress.length() || stringToCompress.charAt(i) != stringToCompress.charAt(i + 1)) {
                compressed.append(stringToCompress.charAt(i));
                compressed.append(charCounter);
                charCounter = 0;
            }
        }

        return compressed.toString();
    }
}
