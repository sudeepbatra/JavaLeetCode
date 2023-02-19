package com.stoxalpha;

public class UniqueCharDetector {

    public boolean isUnique(String inputText) {
        if (inputText.length() > 128) return false;

        //Array representing all 128 characters in ASCII
        //https://www.ascii-code.com/
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < inputText.length(); i++) {
            int val = inputText.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }

        return true;
    }
}
