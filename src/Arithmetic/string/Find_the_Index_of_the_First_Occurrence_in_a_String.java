package Arithmetic.string;

import java.util.Arrays;

public class Find_the_Index_of_the_First_Occurrence_in_a_String {
    public static void main(String[] args) {
        System.out.println(KMP("leetcode", "leeto"));
        System.out.println(Arrays.toString(getNext("aabaaf")));
    }

    public static int strStr(String haystack, String needle){
        for (int i = 0; i < haystack.length(); i++) {
            int index = i;
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(index) == needle.charAt(j)){
                    index++;
                    if (index >= haystack.length() && j < needle.length() - 1)
                        return -1;
                }else break;
            }
            if (j >= needle.length())
                return i;
        }

        return -1;
    }

    public static int KMP(String haystack, String needle){
        if (needle.length() == 1){
            return haystack.indexOf(needle);
        }

        int[] next = getNext(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()){
            if (haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if (j == needle.length())
                    return i - needle.length();
            }else {
                if (j > 0)
                    j = next[j - 1];
                else i++;
            }
        }
        return -1;
    }


    public static int[] getNext(String needle){
        int len = needle.length();
        int[] next = new int[len];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < len; i++){
            while (j > 0 && needle.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)){
                j++;
            }

            next[i] = j;
        }

        return next;
    }
}
