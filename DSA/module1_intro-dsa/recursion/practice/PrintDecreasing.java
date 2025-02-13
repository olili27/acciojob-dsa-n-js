public class PrintDecreasing {
    public static void main(String[] args) {
        int n = 5;
        PrintDecreasing p = new PrintDecreasing();
        p.pd(n);
    }

    void pd(int n) {
        if(n == 0) {
            return;
        }

        System.out.println(n); // reducing
        pd(n-1);
        System.out.println(n); // increasing
    }
}
