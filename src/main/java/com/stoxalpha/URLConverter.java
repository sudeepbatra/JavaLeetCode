package com.stoxalpha;

public class URLConverter {
    public String urlIfy(String url, int length) {
        char[] result = new char[length];

        url = url.trim();
        char[] urlChars = url.toCharArray();

        int charResultPointer = 0;

        for (int i = 0; i < urlChars.length && charResultPointer < length; i++) {
            if (urlChars[i] != ' ') {
                result[charResultPointer] = urlChars[i];
                charResultPointer++;
            } else {
                if (charResultPointer >= length - 3) {
                    break;
                } else {
                    result[charResultPointer] = '%';
                    result[charResultPointer + 1] = '2';
                    result[charResultPointer + 2] = '0';
                    charResultPointer += 3;
                }
            }
        }

        return String.valueOf(result);
    }
}
