package CtCi;

import java.util.HashMap;
import java.util.Map;

public class ArraysChallenge {
    public static void main(String[] args) {
        boolean permutation = isPermutation("unique", "uniqeu");
        System.out.println(permutation);
        System.out.println("unique".toCharArray());
    }

    static boolean isUnique(String input) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int pointer = 0; pointer < input.length() - 1; pointer++) {
            int val = input.charAt(pointer);
            System.out.println(val);
            if (frequency.get(input.charAt(pointer)) == null) {
                frequency.put(input.charAt(pointer), 1);
            } else {
                return false;
            }
        }
        return true;
    }

    static boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();

        for (int i = 0; i < str1.length(); i++) {
            Character character = str1.charAt(i);
            if (!frequency.containsKey(character)) {
                frequency.put(character, 1);
            } else {
                frequency.put(character, frequency.get(character) + 1);
            }
        }

        for (int i = 0; i < str2.length(); i++) {
            Character character = str2.charAt(i);
            if (frequency.containsKey(character)) {
                frequency.put(character, frequency.get(character) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
