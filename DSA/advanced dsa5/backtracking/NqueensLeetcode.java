import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NqueensLeetcode {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] columnPlacements = new int[n];

        helper(n, 0, columnPlacements, result);

        return result;
    }

    private static void helper(int n, int row, int[] columnPlacements, List<List<String>> result) {
        if (row == n) {
            List<String> ans = new ArrayList<>();
            char[] boardRow = new char[n];
            Arrays.fill(boardRow, '.');

            for (int col : columnPlacements) {
                boardRow[col] = 'Q';
                ans.add(new String(boardRow));
                boardRow[col] = '.';
            }

            result.add(ans);
        } else {
            for (int col = 0; col < n; col++) {
                columnPlacements[row] = col;

                if (isValid(columnPlacements, row)) {
                    helper(n, row + 1, columnPlacements, result);
                }
            }
        }
    }

    private static boolean isValid(int[] columnPlacements, int row) {
        for (int i = 0; i < row; i++) {
            int diff = Math.abs(columnPlacements[i] - columnPlacements[row]);
            if (diff == 0 || diff == row - i) {
                return false;
            }
        }
        return true;
    }
}
