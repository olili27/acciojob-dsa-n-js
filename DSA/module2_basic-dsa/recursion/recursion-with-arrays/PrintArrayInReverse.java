public class PrintArrayInReverse {
    static void print(int [] arr, int idx) {
        if(idx == arr.length) {
            return;
        }

        print(arr, idx + 1);
        System.out.print(arr[idx] + " ");
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7};
        print(arr, 0);
    }
}
