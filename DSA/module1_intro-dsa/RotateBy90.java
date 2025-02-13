import java.util.Scanner;

public class RotateBy90 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = s.nextInt();
            }
        }

        // get transpose
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // swap to rotate by 90
        for (int i = 0; i < n; i++) {
            int k = m - 1;

            for (int j = 0; j < k; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][k];
                mat[i][k] = temp;
                k--;
            }
        }

        System.out.println();
        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}





