import java.util.*;

public class Missing{
    List<Integer> missingFromRange(int [] balance) {
        Map<Integer, Integer> hm = new HashMap<>();
        int n  = balance.length;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int ele = balance[i];

            if(hm.containsKey(ele)) {
                list.add(i);
            } else {
                int val = hm.getOrDefault(ele, 0);

                hm.put(ele, val + 1);
            }
        }

        // List<Integer> list = new ArrayList<>();
        // for(int i = 0; i < n; i++) {
        //     int ele = balance[i];
        //     if(hm.containsKey(ele)) list.add(i);
        //     else {
        //         continue;
        //     }
        // }
        return list;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = 8;
        int [] arr =  {4,3,7,8,2,3,1};

        Missing obj = new Missing();
        
        List <Integer> ans = obj.missingFromRange(arr);
        for(int i = 0; i < ans.size(); i++) {
            System.out.print(arr[ans.get(i)] + " ");
        }
    }
}