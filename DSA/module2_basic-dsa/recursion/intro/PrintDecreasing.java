package intro;
public class PrintDecreasing {

    static void pd(int n) {
        if(n == 0) {
            System.out.println(n);
            return;
        }
        System.out.println(n);;

        pd(n - 1);
    }
    public static void main(String[] args) {
        int n = 6;
        pd(n);
    }
}
