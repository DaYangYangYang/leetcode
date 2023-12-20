package Arithmetic.HashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Happy_Number {
    public static void main(String[] args) {

        System.out.println(isHappy(3));

    }


    public static boolean isHappy(int n) {
        if (n == 0)
            return false;
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        while (!set.contains(n)){
            set.add(n);
            list.clear();
            while (n != 0){
                list.add(n % 10);
                n /= 10;
            }
            n = 0;
            for (Integer i : list) {
                n += (int) Math.pow(i, 2);
            }
            if (n == 1)
                return true;
        }
        return false;
    }
}
