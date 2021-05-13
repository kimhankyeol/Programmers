package level2;

import java.util.Stack;

public class PairDelete {
    static String s = "baabaa";
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i<s.length();i++){
            if(!stack.isEmpty() && stack.peek() == s.charAt(i))
                stack.pop();
            else
                stack.push(s.charAt(i));
        }

        System.out.println(stack.size());

    }
}
