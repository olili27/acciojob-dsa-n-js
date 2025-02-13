import java.util.Scanner;

public class SquareRoot {
    public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
                Scanner s = new Scanner(System.in);
                int n = s.nextInt();

                int sq = square(n);
                System.out.println(sq);
	}

        static int square(int n) {
                long ans = 1;
                long l = 0, r = n;

                while(l <= r) {
                        long mid = (l + r) / 2;
                         if(mid * mid > n){
                                 
                                 r = mid - 1;
                         }
                        else if(mid * mid < n) {
                                if((mid + 1) * (mid + 1) > n){
                                        ans = mid;
                                        break;
                                }                 
                                l = mid + 1;
                        }
                        else {
                                ans = mid;
                                break;
                        }
                }
                return (int) ans;
        }
}
