package com.stoxalpha;

public class Palindromes {
    public static void main(String[] args) {

        Palindromes palindromes = new Palindromes();
        boolean isPalindrome = palindromes.isPalindrome("ACCA");
        System.out.println(isPalindrome);
        boolean isPalindrome1 = palindromes.isPalindrome("ACCB");
        System.out.println(isPalindrome1);
    }

    public boolean isPalindrome(String text) {
        char[] textChars = text.toCharArray();
        int length = textChars.length;

        for (int i = 0; i < length / 2; i++) {
            if (textChars[i] != textChars[length - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}
