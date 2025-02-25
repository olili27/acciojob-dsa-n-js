import java.util.*;

class Solution{
    char isSame(char ch) {
        if(ch == ')') return '(';
        if(ch == '}') return '{';
        return '[';
    }
    public void balancedBrackets(String s, int n) {
        // write code here
        Stack <Character> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else {
                if(stack.empty()) {
                    System.out.println("NO");
                    return;
                }
                else {

                    if(stack.peek() == isSame(ch)) {
                        stack.pop();
                    } else {
                        System.out.println("NO");
                        return;
                    }
                }
            }


        }
        if(stack.empty()) {
            System.out.println("YES");
        } else System.out.println("NO");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        Solution Obj = new Solution();
        Obj.balancedBrackets(s, n);
    }
}