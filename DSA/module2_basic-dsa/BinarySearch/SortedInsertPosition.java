import java.util.Scanner;

public class SortedInsertPosition {
    public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      int [] arr = new int [n];

      for(int i=0; i<n; i++) {
        arr[i] = s.nextInt();
      }

                int k = s.nextInt();

                int index = insert(arr, k);
                System.out.println(index);
	}

        static int insert(int arr [], int target) {
                int l = 0, r = arr.length - 1;
                while(l <= r) {
                        int mid = (l + r) / 2;
                        if(arr[mid] > target) {
                                r = mid - 1;
                        }
                        if(arr[mid] < target) {
                                l = mid + 1;
                        }
                        if(arr[mid] == target) {
                                return mid;
                        }
                }
                return r + 1;
        }
}
