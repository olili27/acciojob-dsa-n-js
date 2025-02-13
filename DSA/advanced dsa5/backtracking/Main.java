import java.util.*;

public class Main {
    public static int totalNQueens(int n) {
        // write code here
        List<List<String>> result = new ArrayList();
        List<String> columnPlacements = new ArrayList();

        helper(n, 0, columnPlacements, result);

        return result.size();
    }

    private static void helper(int n, int row, List<String> columnPlacements, List<List<String>> result) {
        if(row == n) {
            result.add(new ArrayList<>(columnPlacements));
        } else {
            for(int column = 0; column < n; column++) {
                columnPlacements.add(column + "");

                if(isValid(columnPlacements)) {
                    helper(n, row + 1, columnPlacements, result);
                }

                columnPlacements.remove(columnPlacements.size() - 1);
            }
        }
    }

    private static boolean isValid(List<String> columnPlacements) {
        int rowId = columnPlacements.size() - 1;

        for(int i = 0; i < rowId; i++) {
            int absoluteDifference = Math.abs(Integer.parseInt(columnPlacements.get(i)) - Integer.parseInt(columnPlacements.get(rowId)));

            if(absoluteDifference == 0 || absoluteDifference == rowId - i) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(totalNQueens(n));
    }
}