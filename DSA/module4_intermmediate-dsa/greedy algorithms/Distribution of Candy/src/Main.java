import java.io.*;
import java.util.*;

class Main {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        ArrayList<Integer> arr= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int x=sc.nextInt();
            arr.add(x);
        }

        Solution ob=new Solution();
        System.out.println(ob.candies(arr,n));

    }
}


class Solution {
    public int candies(ArrayList<Integer> list,int n) {
        //Write code here
        int [] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if(list.get(i) > list.get(i - 1)) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (list.get(i) > list.get(i + 1)) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int total = 0;
        for (int candy: candies) total += candy;

        return total;
    }
}
