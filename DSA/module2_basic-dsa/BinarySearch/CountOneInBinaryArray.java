import java.util.Scanner;

public class CountOneInBinaryArray {
    public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
                Scanner s = new Scanner(System.in);
                int n = s.nextInt();
                int arr [] = new int [n];
                 for(int i = 0; i < n; i++) {
                         arr[i] = s.nextInt();
                 }
                int count = search(arr);
                System.out.println(count);
                
	}

        static int search(int arr []) {
                int l = 0, r = arr.length - 1;
                int ans = 0;

                if(arr[r] == 1) {
                        return r + 1;
                }

                while(l <= r){
                        int mid = (l + r) / 2;
                        if(arr[mid] == 1) {
                                l = mid + 1;
                        }
                        if(arr[mid] == 0) {
                                ans = mid;
                                r = mid - 1;
                        }
                }
                return ans;
        }
}
