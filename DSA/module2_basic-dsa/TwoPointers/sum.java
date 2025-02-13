public class sum {
    static int su(int [] arr) {
        int n = arr.length;
        int s = 0;
        for(int i = 0; i < n; i++){
            s += arr[i];
        }
        return s;
    }

    public static void main(String[] args) {
        int arr [] = {1,2,3,4,5,6};
        int s = su(arr);
        System.out.println(s);
    }
}
