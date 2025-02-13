import java.util.*;

public class Main {
    public static boolean SearchA2DMatrix(int[][] matrix, int target) {
        //Write your code here
        // Return true or false
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0, j = m - 1;

        while(i < n && j >= 0) {
            if(matrix[i][j] > target) {
                j--;
            }
            else if(matrix[i][j] < target) {
                i++;
            }
            else {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for(int i = 0; i< m; i++) {
            for(int j = 0; j<n; j++)
                mat[i][j] = sc.nextInt();
        }
        int x = sc.nextInt();
        if(SearchA2DMatrix(mat, x))
            System.out.println("true");
        else
            System.out.println("false");
    }
}