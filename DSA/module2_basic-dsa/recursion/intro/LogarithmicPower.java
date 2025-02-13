package intro;
public class LogarithmicPower {
    static int power(int x, int n) {
        if(n == 0) {
            return 1;
        }

        int sAns = power(x, n / 2);

        int ans = 0;
        if(n % 2 == 0) {
            ans = sAns * sAns;
        } else {
            ans = x * sAns * sAns;;
        }

        return ans;
    }

    public static void main(String[] args) {
        int pow = power(4, 8);
        System.out.println(pow);
    }
}
