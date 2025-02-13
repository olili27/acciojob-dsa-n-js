import java.util.Arrays;

public class GetAllIndices {
    static int [] getAll(int [] arr, int idx, int target, int count) {

        if(idx == arr.length) {
            int [] base_array = new int [count];
            return base_array;
        }

        int [] ans;

        if(arr[idx] == target) {
            ans = getAll(arr, idx + 1, target, count + 1);
        } else {
            ans = getAll(arr, idx + 1, target, count);
        }

        if(arr[idx] == target) {
            ans[count] = idx;
        }

        return ans;
    }

    public static void main(String[] args) {
        int [] arr ={7,3,3,0,3,4};
        int [] ans = getAll(arr, 0, 3, 0);
        System.out.println(Arrays.toString(ans));
    }
}
