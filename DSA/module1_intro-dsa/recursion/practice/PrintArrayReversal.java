public class PrintArrayReversal {
    public static void main(String[] args) {
        int arr [] = {1,2,4,5};
        int index = arr.length - 1;
        reverseArray(index, arr);
    }

    static void reverseArray(int index, int arr []) {
        if(index < 0) {
            return;
        }

        System.out.println(arr[index]);
        reverseArray( index - 1, arr);

        // or use this logic 
        // reverseArray( index + 1, arr);
        // System.out.println(arr[index]);
    }
}
