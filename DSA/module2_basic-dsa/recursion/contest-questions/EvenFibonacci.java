public class EvenFibonacci {
    static int evenFib(int n) {
        if(n == 0) {
            return 0;
        }

        if(n == 1) {
            return 2;
        }

        return 4 *evenFib(n - 1) +evenFib(n - 2);
    }

    public static void main(String[] args) {
        for(int i = 0; i <= 4; i++) {
            int ans = evenFib(i);
            System.out.print(ans + " ");
        }
    }
}
