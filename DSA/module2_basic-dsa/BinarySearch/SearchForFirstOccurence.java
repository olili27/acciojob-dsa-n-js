import java.util.Scanner;

public class SearchForFirstOccurence {
    public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      int k = s.nextInt();
      int [] arr = new int [n];
      

          for(int i=0; i<n; i++){
               arr[i] = s.nextInt(); 
          }
        
      int index = binarySearch(arr, k);
                System.out.println(index);
	}

        static int binarySearch(int arr[], int target) {
                int l = 0, r = arr.length - 1;
                int index = -1;

                while(l <= r) {
                        int mid = (l + r) / 2;
                        if(arr[mid] > target) {
                                r = mid - 1;
                        }
                        if(arr[mid] < target) {
                                l = mid + 1;
                        }
                        if(arr[mid] == target) {
                                index = mid + 1;
                                r = mid -1;
                        }
                }
                return index;
            }    
}
