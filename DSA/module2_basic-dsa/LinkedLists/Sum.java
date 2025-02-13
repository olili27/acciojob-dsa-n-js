public class Sum {
    static int sum(int [] arr, int idx) {
        if(idx == arr.length) {
            return 0;
        }

        int sAns = sum(arr, idx + 1) + arr[idx];
        return sAns;
    }

    public static void main(String[] args) {
        int arr [] = {1,2,3,4,5,6};;
        int sum = sum(arr, 0);
        System.out.println(sum);
    }
}
