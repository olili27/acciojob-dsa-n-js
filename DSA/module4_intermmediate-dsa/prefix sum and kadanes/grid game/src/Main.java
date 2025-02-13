import java.util.*;

class Solution {

    long range(long [] pref, int l, int r) {

        if(r < 0) return 0;

        if(l == 0) return pref[r];

        return pref[r] - pref[l - 1];
    }

        public long solve(int grid[][]) {
        // Your code here
        int n  = grid[0].length;
        long [] row1 = new long [n];
        long [] row2 = new long [n];

        long ans = Long.MAX_VALUE;

// prefix sum for row1
        row1[0] = grid[0][0];
        for(int i = 1; i < n; i++) row1[i] = grid[0][i] + row1[i - 1];

// prefix sum for row2
        row2[0] = grid[1][0];
        for(int i = 1; i < n; i++) row2[i] = grid[1][i] + row2[i - 1];

        for(int i = 0; i < n; i++) {
            long option1 = range(row1, i + 1, n - 1);
            long option2 = range(row2, 0, i - 1);

            long max = Math.max(option1, option2);
            ans = Math.min(max, ans);
        }

        return ans;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int grid[][]=new int[2][n];
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<n;j++)
                grid[i][j]=sc.nextInt();

        }

        Solution obj=new Solution();
        System.out.println(obj.solve(grid));
        sc.close();
    }
}