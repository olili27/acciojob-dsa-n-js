import java.util.*;

class Solution {

    int getSum(int [] arr, int k) {
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            int currMinSum = 0;

            for(int j = i; j < arr.length; j++) {
                currMinSum += arr[j];

                if(currMinSum <= k) ans = Math.max(ans, currMinSum);
            }
        }

        return ans;
    }
    public int maxSumSubmatrix(int[][] matrix, int k) {
        //Write code here
        int maxSum = Integer.MIN_VALUE;

        for(int left = 0; left < matrix[0].length; left++) {

            // make an array with the length == number of rows of the matrix
            int [] columnSum = new int [matrix.length];

            for(int right = left; right < matrix[0].length; right++) {
                for(int i = 0; i < matrix.length; i++) {
                    columnSum[i] += matrix[i][right];
                }

                maxSum = Math.max(maxSum, getSum(columnSum, k));
            }
        }

        return maxSum;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        }
        int k;
        k = sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.maxSumSubmatrix(matrix, k));
        sc.close();
    }
}