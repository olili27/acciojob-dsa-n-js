public class Test {
    public static void main(String[] args) {
        int [] arr = {-1, -4, -8, -2, -9, -26, -30};

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println(max);
    }
}
