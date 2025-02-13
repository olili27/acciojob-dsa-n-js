public class FindLastIndex {
    static int lastIdx(int[] arr, int idx, int target) {
        int count = 0;
        count++;

        if (idx == -1) {
            return -1;
        }

        int ans = 0;

        if (arr[idx] == target) {
            ans = idx;
        } else {
            ans = lastIdx(arr, idx - 1, target);
        }
        System.out.println("count: " + count);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 7, 2, 4, 2, 2 };
        int ans = lastIdx(arr, arr.length - 1, 1);
        System.out.println(ans);
    }
}
