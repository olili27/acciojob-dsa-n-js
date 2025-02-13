public class Mid {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7};
        int length = arr.length;

        if (length % 2 == 0) {
            int index1 = ((arr.length - 1)) / 2;
            int index2 = index1 + 1;

            int mid = (arr[index1] + arr[index2]) / 2;
            System.out.println(mid);
        } else {
            int midIndex = length / 2;
            System.out.println(arr[midIndex]);
        }

    }
}
