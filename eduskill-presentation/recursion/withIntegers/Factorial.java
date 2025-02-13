public class Factorial {

    static int fact(int n) {
        if(n == 1) {
            return 1;
        }

        int smallAns = fact(n - 1);
        int ans = n * smallAns;

        return ans;
    }
    public static void main(String[] args) {
        int n = 4;
        int fact = fact(n);
        System.out.println(fact);
    }
}
