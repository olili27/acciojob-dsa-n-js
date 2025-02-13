
import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] trips = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                trips[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();

        Solution obj= new Solution();
        System.out.println(obj.carPooling(trips,k));
    }
}
class Solution{

    public boolean carPooling(int[][] trips, int capacity) {
//your code
        int [] stops = new int [1005];

        for(int i = 0; i < trips.length; i++) {
            int noOfPassengers = trips[i][0];
            int sp = trips[i][1];
            int ep = trips[i][2];

            stops[sp] += noOfPassengers;
            stops[ep + 1] -= noOfPassengers;
        }

        // build prefix sum
        for(int i = 1; i < 1005; i++) {
            stops[i] += stops[i - 1];
        }

        for(int i = 0; i < 1005; i++) {
            if(stops[i] > capacity) return false;
        }

        return true;
    }
}