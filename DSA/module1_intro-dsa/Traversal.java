import java.util.Scanner;

public class Traversal {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        for (int i = 1; i <= N; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    static boolean isPrime(int n) {
        if (n == 1 || n == 0)
            return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
