package com.stoxalpha;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
	public static void main(String[] args) {
		Anagram anagram = new Anagram();
		boolean isAnagram = anagram.isAnagram("cat", "tac");
		System.out.println(isAnagram);
		boolean isAnagramTest1 = anagram.isAnagram("cat", "tacc");
		System.out.println(isAnagramTest1);
	}

	public boolean isAnagram(String text1, String text2) {
		Map<String, Integer> map1 = anagramMap(text1);
		Map<String, Integer> map2 = anagramMap(text2);
		return map1.equals(map2);
	}

	private Map<String, Integer> anagramMap(String text) {
		Map<String, Integer> map = new HashMap<>();
		char[] textChars = text.toCharArray();
		for (char textChar: textChars) {
			String letter = String.valueOf(textChar);
			if (map.containsKey(letter)) {
				int currentLetterCount = map.get(letter);
				map.put(letter, currentLetterCount + 1);
			} else {
				map.put(letter, 1);
			}
		}

		return map;
	}
}
