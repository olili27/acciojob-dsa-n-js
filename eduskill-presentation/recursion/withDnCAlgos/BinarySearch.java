public class BinarySearch {
    static int binarySearch(int [] arr, int start, int end, int target) {
        if(start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if(arr[mid] == target) {
            // return arr[mid]
            return mid;
        }

        if(arr[mid] > target)  {
            return binarySearch(arr, start, mid - 1, target);
        }

        return binarySearch(arr, mid + 1, end, target);


    }

    public static void main(String[] args) {
        int [] arr = {1,3,6,8,13,16,14,27};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 6));
    }
}
