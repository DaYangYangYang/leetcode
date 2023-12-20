package Arithmetic.string;

public class LCR_182 {
    public static void main(String[] args) {
        System.out.println(dynamicPassword("aasdda", 2));
    }

    public static String dynamicPassword(String password, int target) {
        if (target <= 0)
            return password;
        String prex = password.substring(0, target);
        String tail = password.substring(target, password.length());
        return tail + prex;
    }
}
