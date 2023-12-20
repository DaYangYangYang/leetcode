package Arithmetic.string;

import java.util.Arrays;

public class Reverse_String2 {
    public static void main(String[] args) {
        char[] ch = {'a', 'b', 'c', 'd'};
        System.out.println(ToString(ch));
    }

    public static String reverseStr(String s, int k) {
        if (s.length() <= 1)
            return s;
        char[] ch = new char[s.length()];
        s.getChars(0, s.length(), ch, 0);
        for (int i = 0; i < ch.length; i++) {
            System.out.print(ch[i] + " ");
        }
        int slow = 0;
        int fast = k - 1;
        while (fast + k < ch.length){
            reverse(ch, slow, fast);
            slow = fast + k + 1;
            fast = slow + k - 1;
        }
        if (slow >= ch.length){
            return ToString(ch);
        }
        if (fast < ch.length){
            reverse(ch, slow, fast);
            return ToString(ch);
        }
        reverse(ch, slow, ch.length - 1);
        return ToString(ch);
    }

    public static void reverse(char[] ch, int i, int j){
        while (i < j){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
    }

    public static String ToString(char[] ch){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            sb.append(ch[i]);
        }
        return sb.toString();
    }

}
