public class FindFirstIndex {
    static int firstIdx(int [] arr, int idx, int target) {
        int count = 0;
        count++;

        if(idx == arr.length) {
            return -1;
        }

        int ans = 0;

        if(arr[idx] == target) {
            ans = idx;
        } else {
            ans = firstIdx(arr, idx + 1, target);
        }
        System.out.println("count: " + count);
        return ans;
    }

    public static void main(String[] args) {
        int [] arr = {2, 3, 1, 7, 2, 4,2, 2};
        int ans = firstIdx(arr, 0, 1);
        System.out.println(ans);
    }
}
