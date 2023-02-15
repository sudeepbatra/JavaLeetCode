package com.stoxalpha;

import java.util.HashMap;
import java.util.Map;

public class RansomNote  {
    public static void main(String[] args) {
        RansomNote ransomNote = new RansomNote();
        boolean canWrite = ransomNote.canWrite("Pay", "yaP");
        System.out.println(canWrite);
        boolean canWrite1 = ransomNote.canWrite("Payt", "yaP");
        System.out.println(canWrite1);
    }

    private boolean canWrite(String ransomNote, String lettersAvailable) {
        String ransomNoteNoSpaces = ransomNote.replaceAll("\\s+", "");

        Map<String, Integer> ransomNoteMap = createMap(ransomNoteNoSpaces);
        Map<String, Integer> lettersAvailableMap = createMap(lettersAvailable);

        return canWriteRansom(ransomNoteMap, lettersAvailableMap);
    }

    private Map<String, Integer> createMap(String text) {
        Map<String, Integer> map = new HashMap<>();
        char[] chars = text.toCharArray();
        for (char textChar: chars) {
            String letter = String.valueOf(textChar);

            if (map.containsKey(letter)) {
                int letterCount = map.get(letter);
                map.put(letter, letterCount + 1);
            } else {
                map.put(letter, 1);
            }
        }
        return map;
    }

    private boolean canWriteRansom(Map<String, Integer> ransomNoteMap, Map<String, Integer> letterAvailableMap) {
        for (String letterInRansomNote: ransomNoteMap.keySet()) {
            if (!letterAvailableMap.containsKey(letterInRansomNote)) {
                return false;
            }

            if (letterAvailableMap.get(letterInRansomNote) < ransomNoteMap.get(letterInRansomNote)) {
                return false;
            }
        }

        return true;
    }
}
