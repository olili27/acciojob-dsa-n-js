public class RobHouse {
    static int rob(int [] arr, int idx, int end) {
        if(idx > end) {
            return 0;
        }

        // rob current
        int current = rob(arr, idx + 2, end) + arr[idx];

        // skip current
        int skip_current = rob(arr, idx + 1, end);

        return Math.max(current, skip_current);
    }

    static int robHouse(int [] arr) {
        int n = arr.length;

        int rob_current = rob(arr, 0, n - 2);
        int skip_current = rob(arr, 0, n - 1);

        return Math.max(rob_current, skip_current);
    }

    public static void main(String[] args) {
        int [] arr = { 2,7, 8,3, 9, 11};

        int rob = robHouse(arr);
        System.out.println(rob);
    }
}
