public class DiffPossible {
    static int diff(int []arr, int target) {
        int n = arr.length;
        int i = 0, j = 1;

        while(i < n & j < n) {

            int diff = arr[j] - arr[i];

            if(diff > target) {
                i++;
            } else if(diff < target) {
                j++;
            } else {
                if(i != j) {
                    return 1;
                } else {
                    j++;
                }
            }
        }

        return 0;
    }
}
