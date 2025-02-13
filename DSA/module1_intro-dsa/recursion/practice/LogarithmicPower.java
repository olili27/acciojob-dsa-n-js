public class LogarithmicPower {
    public static void main(String[] args) {
        int ans = power(2, 8);
        System.out.println(ans);
    }

    static int power(int x, int n) {
        if(n == 0) { // base case
            return 1;
        }
        int smallProb = power(x, n / 2); // smaller problem
        int ans = 0;

        if(n % 2 == 0) {
            ans = smallProb * smallProb;
        } 
        else {
            ans = x * smallProb * smallProb;
        }

        return ans;
    }
}
