package Arithmetic.string;

public class Reverse_String {
    public static void main(String[] args) {

    }
    public static void reverseString(char[] s){
        if (s.length <= 1)
            return;

        int i = 0;
        int j = s.length - 1;
        while (i < j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
