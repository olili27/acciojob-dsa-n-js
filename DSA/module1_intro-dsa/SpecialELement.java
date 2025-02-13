import java.util.Arrays;

public class SpecialELement {
    public static void main(String[] args) {
        int [][] mat = { {1,0,0}, {0,0,1}, {1,0,0} };
        int [] row = new int [mat.length];
        int [] col = new int [mat[0].length];
        int count = 0;

        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j] == 1 && row[i] == 1 && col[i] == 1 ){
                    count = mat[i][j];
                }
            }
        }
        System.out.println(Arrays.toString(row) + " " + Arrays.toString(col));
        System.out.println(count);
    }
}
