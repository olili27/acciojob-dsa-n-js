import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public boolean ExtraBrackets(String exp) {
        // Write your code here
        Stack <Character> stack = new Stack<>();

        for(int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            // if ch is equal ')'
            if(ch != ')') {
                stack.push(ch);
            }

            // check if there is sth btn the brackets
            else {

                // if nothing is btn the brackets
                if(stack.size() > 0 && stack.peek() == '(') {
                    return true;
                }

                // if sth is btn the brackets
                else {
                    while(stack.size() > 0 && stack.peek() != '(') {
                        stack.pop();
                    }

                    stack.pop();
                }
            }
        }

        return false;

    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        Solution Obj = new Solution();
        if(Obj.ExtraBrackets(exp))
            System.out.println("true");
        else
            System.out.println("false");
    }
}