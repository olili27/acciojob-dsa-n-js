import java.io.*;
import java.util.*;


class Solution{
    public String smallestNumber(String str){
        // create an empty stack to store integers
        Stack<Integer> stack = new Stack<>();

        // empty string to store the output
        String result = "";

        // run n+1 times, n -> length of the input string
        for(int i = 0; i <= str.length(); i++){
            // 1. push the number i+1 to the stack
            stack.push(i + 1);

            // 2. if char being scanned is at index == str length or char is I
            if(i == str.length() || str.charAt(i) == 'i'){
                // add the peek to result str and pop until stack is empty
                while(!stack.empty()) {
                    result += stack.pop();
                }
            }
        }
        // return result str
        return result;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Solution Obj = new Solution();
        System.out.print(Obj.smallestNumber(str));
    }
}