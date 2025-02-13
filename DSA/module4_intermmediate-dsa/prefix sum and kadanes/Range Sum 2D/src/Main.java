import java.util.*;

class Pair {
    int row1;
    int row2;
    int col1;
    int col2;
}

class Solution {

    void build(int [][] pref, int matrix[][]) {
        // prefix sum builder
        for(int i = 0; i < pref.length; i++) {
            for(int j = 0; j < pref[0].length; j++) {
                int a = matrix[i][j];
                int b = j - 1 >= 0 ? pref[i][j - 1] : 0;
                int c = i - 1 >= 0 ? pref[i - 1][j] : 0;
                int d = i - 1 >= 0 && j - 1 >= 0 ? pref[i - 1][j - 1] : 0;

                pref[i][j] = a + b + c - d;
            }
        }
    }
    public List<Integer> solve(int matrix[][], Pair query[]) {
        // Your code here
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> ans = new ArrayList<>();

        int [][] pref = new int [n][m];

        // build the prefix sum matrix
        build(pref, matrix);

        for(int i = 0; i < query.length; i++) {
            int r1 = query[i].row1;
            int c1 = query[i].col1;
            int r2 = query[i].row2;
            int c2 = query[i].col2;

            int a = pref[r2][c2];
            int b = c1 - 1 >= 0 ? pref[r2][c1 - 1] : 0;
            int c = r1 - 1 >= 0 ? pref[r1 - 1][c2] : 0;
            int d = r1 - 1 >= 0 && c1 - 1 >= 0 ? pref[r1 - 1][c1 - 1] : 0;

            int myQuery = a - b - c + d;
            ans.add(myQuery);
        }

        return ans;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int matrix[][] = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                matrix[i][j]=sc.nextInt();
        }
        int q = sc.nextInt();
        Pair query[] = new Pair[q];

        Solution obj = new Solution();
        for (int i = 0; i < q; i++) {
            Pair p=new Pair();
            p.row1 = sc.nextInt();
            p.col1 = sc.nextInt();
            p.row2 = sc.nextInt();
            p.col2 = sc.nextInt();
            query[i]=p;
        }
        List<Integer> ans = obj.solve(matrix, query);
        for(int x: ans)
            System.out.println(x);
        sc.close();
    }
}