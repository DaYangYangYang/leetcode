package Arithmetic.string;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Reverse_Words_in_a_String {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
    public static String reverseWords(String s){
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.setLength(0);
            char c = s.charAt(i);
            while ((c <= 'Z' && c >= 'A') || (c <= 'z' && c >= 'a') || (c >= '0' && c <= '9')){
                sb.append(c);
                if (++i < s.length())
                    c = s.charAt(i);
                else break;
            }
            if (sb.length() > 0) {
                i--;
                list.add(sb.toString());
            }
        }

        sb.setLength(0);
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
            if (i > 0)
                sb.append(' ');
        }
        return sb.toString();
    }
}
