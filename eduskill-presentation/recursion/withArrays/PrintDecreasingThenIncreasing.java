public class PrintDecreasingThenIncreasing {
    static void pd(int n) {
        if(n == 0) {
            System.out.println(n);
            return;
        }
        System.out.println(n);

        pd(n - 1);

        System.out.println(n);
    }
    public static void main(String[] args) {
        int n = 6;
        pd(n);
    }
}
