import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        sc.close();
        System.out.println(numEnclaves(grid));
    }

    static void destroy(int i, int j, int [][] grid) {
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0)
            return;

        grid[i][j] = 0;
        destroy(i - 1, j, grid);
        destroy(i , j - 1, grid);
        destroy(i + 1, j, grid);
        destroy(i, j + 1, grid);
    }
    public static int numEnclaves(int[][] grid) {
        // your code here
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            if (i == 0) for (int j = 0; j < m; j++) destroy(i, j, grid);
            else if (i == n - 1) for (int j = 0; j < m; j++) destroy(i, j, grid);
            else{
                destroy(i, 0, grid);
                destroy(i, m - 1, grid);
            }
        }

        int count  = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count += grid[i][j];
            }
        }

        return count;
    }
}