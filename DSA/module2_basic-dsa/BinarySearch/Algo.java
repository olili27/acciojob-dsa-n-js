public class Algo {
    static int binarySearch(int arr[], int target) {

        int index = -1;

        int low = 0; // lowest index in the array or data set
        int high = arr.length - 1; // highest index in the array or data set

        while (low <= high) {
            int mid = (low + high) / 2; // the middle element in the array or data set

            if (arr[mid] > target) {
                high = mid - 1; // ignore the middle element and every other element to the right of the middle
                                // element
            }
            if (arr[mid] < target) {
                low = mid + 1; // ignore the middle element and every other element to the left of the middle
                               // element
            }
            if (arr[mid] == target) {
                return mid; // ignore the middle element and every other element to the left of the middle
                  // element
            }
        }

        return index;
    }
}
