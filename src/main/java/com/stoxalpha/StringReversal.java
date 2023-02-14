package com.stoxalpha;

public class StringReversal {
    public static void main(String[] args) {
        StringReversal stringReversal = new StringReversal();
        String reversedStringInBuilt = stringReversal.reverseStringInBuilt("skdlfjlksdjf");
        System.out.println(reversedStringInBuilt);
        String reversedString = stringReversal.reverseString("jik");
        System.out.println(reversedString);
    }

    public String reverseStringInBuilt(String stringToReverse) {
        StringBuilder sb = new StringBuilder(stringToReverse);
        return sb.reverse().toString();
    }

    public String reverseString(String stringToReverse) {
        char[] chars = stringToReverse.toCharArray();

        int left;
        int right = chars.length - 1;

        for (left = 0; left < right; left++, right--) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
        }

        return String.valueOf(chars);
    }
}
