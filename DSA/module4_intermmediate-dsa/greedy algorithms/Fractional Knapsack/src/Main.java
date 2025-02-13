import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class Main {

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        Item arr[] = new Item[n];
        for(int i=0;i<n;i++) {
            int value = sc.nextInt();
            arr[i] = new Item(value,0);
        }
        for(int i=0;i<n;i++) {
            arr[i].weight = sc.nextInt();
        }
        double ans = (new Solution()).fractionalKnapsack(w,arr,n);
        System.out.println(String.format("%.2f",ans));
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/


class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int capacity, Item arr[], int n)
    {
        // Write your code here
        Arrays.sort(arr, (a, b) -> {
            double pwra = (double) 1.0 * a.value / a.weight;
            double pwrb = (double) 1.0 * b.value / b.weight;

            return (pwra > pwrb) ? -1 : 1;
        });

        double ans = 0;
        for (int i = 0; i < n; i++) {
            if (capacity >= arr[i].weight) {
                ans += arr[i].value;
                capacity -= arr[i].weight;
            } else {
                ans += (double) (1.0 * arr[i].value / arr[i].weight) * 1.0 * capacity;
                capacity = 0;
                break;
            }
        }

        return ans;
    }
}