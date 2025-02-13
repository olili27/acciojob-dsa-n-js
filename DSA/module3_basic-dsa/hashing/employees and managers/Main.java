import java.io.*;
import java.util.*;

class Solution {

    int countEmployees(String ceo, HashMap<String, ArrayList<String>> hm, TreeMap<String, Integer> ans) {
        if(hm.containsKey(ceo) == false) {
            ans.put(ceo, 0);
            return 1;
        }

        int count = 0;

        for(String emp: hm.get(ceo)) {
            count += countEmployees(emp, hm, ans);
        }
        ans.put(ceo, count);

        return count + 1;
    }

    public void EmpUnderManager(Map<String, String> emp) {
        HashMap<String, ArrayList<String>> hm =  new HashMap<>();
        String ceo = "";

        for(String employee: emp.keySet()) {
            String manager = emp.get(employee);

            if(manager.equals(employee)) {
                ceo = employee;
                continue;
            }

            if(hm.containsKey(manager)) {
                ArrayList<String> list = hm.get(manager);
                list.add(employee);
                hm.put(manager, list);
            } else {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(employee);
                hm.put(manager, newList);
            }
        }


        TreeMap<String, Integer> ans = new TreeMap<>();
        countEmployees(ceo, hm, ans);

        for (String key : ans.keySet()) {
            System.out.println(key + " " + ans.get(key));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Map<String, String> emp = new HashMap<String, String>();
        for (int i = 0; i < n; ++i) {
            emp.put(sc.next(), sc.next());
        }
        Solution Obj = new Solution();
        Obj.EmpUnderManager(emp);
    }
}