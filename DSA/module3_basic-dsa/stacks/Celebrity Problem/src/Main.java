import java.io.*;
import java.util.*;

class Main{
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M[][] = new int[N][N];
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                M[i][j] = sc.nextInt();
        System.out.println(new Solution().findCelebrity(M,N));
    }
}
class Solution
{
    int findCelebrity(int m[][], int n)
    {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            stack.push(i);
        }

        while(stack.size() >= 2) {
            int c2 = stack.pop();
            int c1 = stack.pop();

            // c1 knows c2, hence c1 cant be a celeb
            if(m[c1][c2] == 1) stack.push(c2);

                // c2 knows c1, hence c2 cant be a celeb
            else stack.push(c1);
        }

        int celeb = stack.peek();

        for(int i = 0; i < n; i++) {

            if(m[celeb][i] == 1) return -1;

            if( i != celeb && m[i][celeb] == 0 ) return -1;
        }

        return celeb;
    }

}