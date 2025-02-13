import java.util.Scanner;

public class SpiralTraverse {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[][] mat = new int[n][m];
        int tne = m*n;

        int minC = 0, minR = 0;
        int maxC = m-1, maxR = n-1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = s.nextInt();
            }
        }

        int count = 0;

        while (count != tne+1 && tne > count) {

            // top
            for (int i = minR, j = minC; j <= maxC; j++) {
                System.out.print(mat[i][j] + " ");
                count++;
                System.out.println(count);
            }

            minR++;

            // right
            for (int i = minR, j = maxC; i <= maxR; i++) {
                System.out.print(mat[i][j] + " ");
                count++;
                System.out.println(count);
            }

            maxC--;

            // bottom
            for (int i = maxR, j = maxC; j >= minC; j--) {
                System.out.print(mat[i][j] + " ");
                count++;
                System.out.println(count);
            }

            maxR--;

            // left
            for (int i = maxR, j = minC; i >= minR; i--) {
                System.out.print(mat[i][j] + " ");
                count++;
                System.out.println(count);
            }

            minC++;
        }
        System.out.println();
        // System.out.println(count);
        System.out.println(tne);

    }
}
