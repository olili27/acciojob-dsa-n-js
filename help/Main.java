// import java.util.ArrayList;
// import java.util.List;
import java.util.Stack;

class Encode{
    String encode(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
       

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(stack.size() == 0 && c == '(') {
                stack.push(c);
                stack2.push(1);
            }
            else if(stack.peek() == '(' && c == '(') {
                stack.push(c);
                int code = stack2.peek();
                stack2.push(code + 1);
            }
            else if(stack.peek() == ')' && c == '(' || stack.peek() == '(' && c == ')') {
                stack.push(c);
                int code = stack2.peek();
                stack2.push(code);
            } else {
                int code = stack2.peek();
                stack2.push(code - 1);
            }
        }

        String ans = "";

        while(stack2.size() > 0) {
            int el = stack2.pop();
            ans = String.valueOf(el) + ans;
        }

        return ans;
    }
}

public class Main{
    public static void main(String[] args) {
        Encode obj = new Encode();
        String ans = obj.encode("(()())");
        System.out.println(ans);
    }
}

