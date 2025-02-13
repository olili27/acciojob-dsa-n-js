public class Power {
    public static void main(String[] args) {
        int pow = power(2, 4);
        System.out.println(pow);
    }
    static int power(int x, int n) {
        if(n == 0) { // base case
            return 1;
        }
        return x * power(x, n - 1); // my expectation while keeping faith
    }
}
