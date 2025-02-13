public class Power {

    static int power(int x, int n) {

        if(n == 0) {
            return 1;
        }

        int smallAns = power(x, n - 1);
        int ans = x * smallAns;

        return ans;
    }
    public static void main(String[] args) {
        int x = 2;
        int n = 2;
        int ans = power(x, n);
        System.out.println(ans);
    }
}
