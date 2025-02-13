import java.util.*;

class Solution{
    public static boolean checkValidString(int n, String s){
        //write code here
        Stack<Character> stack = new Stack<>();

        if(s.equals("")) return true;

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if(ch == '(') {
                if(stack.size() > 0 && stack.peek() == ')') return false;
                else stack.push(ch);
            }

            else if(ch == '*') {
                if(stack.size() > 0 && (stack.peek() == '(' || stack.peek() == '*')) stack.pop();

                if(stack.size() > 0 && stack.peek() == '(' && s.charAt(i + 1) == '*') stack.push(ch);

                else if(stack.size() == 0 && ch == '*') stack.push(ch);

                else if(stack.size() > 0 && stack.peek() == ')') return false;

                else stack.push(ch);
            }
            else{
                if(stack.size() > 0 && (stack.peek() == '(' || stack.peek() == '*')) stack.pop();

                    // else if(stack.size() == 0 && ch == '*') stack.push(ch);

                else return false;

                // else stack.push(ch);
            }
        }

        if(stack.size() == 0) return true;
        else if(stack.size() == 1 && stack.peek() == '*') return true;

        return false;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        String s = sc.next();
        Solution obj = new Solution();
        boolean ans = obj.checkValidString(n,s);
        if(ans==true){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}