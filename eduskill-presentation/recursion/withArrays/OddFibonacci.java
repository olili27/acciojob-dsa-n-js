public class OddFibonacci {

    static int fib(int n) {
        if(n == 0) {
            return 0;
        }
        
        if(n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);

    }
    static int oddFib(int n) {
        int fib = (3 * n - 1) / 2;

        return fib(fib);
    }

    public static void main(String[] args) {
        for(int i = 1; i <= 4; i++){
            int odd = oddFib(i);
            System.out.print(odd + " ");
        }
    }
}
