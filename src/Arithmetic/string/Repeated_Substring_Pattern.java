package Arithmetic.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntFunction;

public class Repeated_Substring_Pattern {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern2("abcabc"));
        System.out.println(get(8));
    }

    public static boolean repeatedSubstringPattern(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() / 2; i++) {
            sb.append(s.charAt(i));
            if (substring(s, sb.toString()))
                return true;
        }
        return false;
    }

    public static boolean substring(String s, String sub){
        if (s.length() - sub.length() < sub.length())
            return false;
        for (int i = sub.length(); i < s.length(); i += sub.length()) {
            int j = i;
            for (int k = 0; k < sub.length(); k++) {
                if (j >= s.length() || s.charAt(j) != sub.charAt(k))
                    return false;
                else j++;
            }
        }
        return true;
    }

    public static boolean repeatedSubstringPattern2(String s){
        if (s.length() == 1)
            return true;
        Integer[] nums = get(s.length());
        for (int i = 0; i < nums.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < nums[i]; j++) {
                sb.append(s.charAt(j));
            }
            String str = sb.toString();
            if (judge(s, str))
                return true;

        }
        return false;
    }
    public static boolean judge(String s, String str){
        for (int i = str.length(); i < s.length(); i+= str.length()){
            int j = i;
            for (int q = 0; q < str.length(); q++, j++) {
                if (s.charAt(j) != str.charAt(q))
                    return false;
            }
        }
        return true;
    }
    public static Integer[] get(int number){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < number; i++) {
            if (number % i == 0)
                list.add(i);
        }
        Integer[] nums = list.stream().toArray(new IntFunction<Integer[]>() {
            @Override
            public Integer[] apply(int value) {
                return new Integer[value];
            }
        });
        return nums;
    }
}
