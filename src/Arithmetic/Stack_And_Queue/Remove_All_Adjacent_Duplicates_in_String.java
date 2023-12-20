package Arithmetic.Stack_And_Queue;

import java.util.Stack;

public class Remove_All_Adjacent_Duplicates_in_String {
    public static void main(String[] args) {

    }

    public static String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!st.isEmpty() && st.peek() == c) {
                while (!st.isEmpty() && st.peek() == c)
                    st.pop();
            } else {
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < st.size(); i++) {
            sb.append(st.get(i));
        }
        return sb.toString();
    }
}
