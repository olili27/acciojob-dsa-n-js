public class Sum{

    // it was similar to this one
    static int add(int [] arr) {
        // int idx = 0;
        // int sum = sum(arr, idx);
        // return sum;

        int n = arr.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }

        return sum;
        
    }

    static int sum(int arr [], int idx) {
        if(idx == arr.length) {
            return 0;
        }

        int sAns = sum(arr, idx + 1) + arr[idx];
        return sAns;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        int sum = add(arr);
        System.out.println(sum);
    }
}