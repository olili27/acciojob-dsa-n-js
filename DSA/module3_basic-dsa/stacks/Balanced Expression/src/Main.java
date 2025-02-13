import java.io.*;
import java.util.*;

class Solution{
    char isSame(char ch){
        if(ch == ')') return '(';
        if(ch == '}') return '{';
        return '[';
    }
    boolean expBalanced(String str){
        // write code here
        Stack <Character> stack = new Stack<>();

        for(int i =0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') stack.push(ch);
            else if(ch == ')' || ch == '}' || ch == ']' ) {
                if(stack.empty()) return false;
                else if(stack.size() > 0 && stack.peek() == isSame(ch)) {
                    stack.pop();
                } else{
                    return false;
                }
            }
        }

        if(stack.empty()) {
            return true;
        }
        return false;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Solution Obj = new Solution();
        System.out.println(Obj.expBalanced(str));
    }
}