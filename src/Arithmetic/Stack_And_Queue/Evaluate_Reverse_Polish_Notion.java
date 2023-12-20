package Arithmetic.Stack_And_Queue;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notion {
    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int number2 = nums.pop();
                int number1 = nums.pop();
                if (token.equals("+")){
                    nums.push(number1 + number2);
                }else if (token.equals("-")){
                    nums.push(number1 - number2);
                }else if (token.equals("*")){
                    nums.push(number1 * number2);
                }else if (token.equals("/")){
                    nums.push(number1 / number2);
                }
            }else{
                boolean sign = false;
                int sum = 0;
                for (int j = 0; j < token.length(); j++) {
                    if (j == 0 && token.charAt(j) == '-')
                        sign = true;
                    else {
                        sum  = sum * 10 + (token.charAt(j) - '0');
                    }
                }
                if (sign)
                    sum = -sum;
                nums.push(sum);
            }
        }
        return nums.pop();
    }
}
