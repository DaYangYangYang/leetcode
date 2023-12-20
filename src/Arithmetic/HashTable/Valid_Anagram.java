package Arithmetic.HashTable;

import com.sun.jdi.Value;

import java.awt.font.NumericShaper;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Valid_Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram2("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t){
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!m.containsKey(c))
                m.put(c, 1);
            else m.put(c, m.get(c) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!m.containsKey(c))
                return false;
            m.put(c, m.get(c) - 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (m.get(c) != 0)
                return false;
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t){
        int[] number = new int[26];
        for (int i = 0; i < s.length(); i++) {
            number[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            number[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < number.length; i++) {
            if (number[i] != 0)
                return false;
        }

        return true;
    }
}
