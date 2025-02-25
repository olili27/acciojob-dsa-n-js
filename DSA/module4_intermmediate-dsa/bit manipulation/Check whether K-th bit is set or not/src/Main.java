import java.io.*;
import java.util.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K=sc.nextInt();


        Solution obj=new Solution();
        Boolean ans=obj.solve(N,K);

        if(ans==true)
            System.out.println("YES");
        else
            System.out.println("NO");

    }
}

class Solution{

    public static Boolean solve(int n,int k)
    {
        // Your code here
        int bitMask = 1 << k;

        if ((n & bitMask) > 0) return true;

        return false;
    }
}