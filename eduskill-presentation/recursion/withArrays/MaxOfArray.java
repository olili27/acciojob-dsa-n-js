public class MaxOfArray {
    static int getMax(int [] arr, int idx) {

        if(idx == arr.length) {
            return 0;
        }

        int sAns = getMax(arr, idx + 1);
        int max = Math.max(arr[idx], sAns);

        return max;
    }

    public static void main(String[] args) {
        int [] arr = {4, 7,1, 8, 20, 3, 13};
        int max = getMax(arr, 0);
        System.out.println(max);
    }
}
