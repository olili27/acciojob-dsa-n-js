import java.util.*;

class Solution {

    @SuppressWarnings("unchecked")

    public int[] canFinish(int n, int[][] prerequisites) {
        //Write your code here
        int [] indegrees = new int[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int [] edges: prerequisites) {
            int ai = edges[0];
            int bi = edges[1];

            graph.get(bi).add(ai);
            indegrees[ai]++;
        }

        int [] ans = new int[n];
        int idx = 0;

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) if(indegrees[i] == 0) q.add(i);

        while (q.size() > 0) {
            int front = q.remove();
            ans[idx] = front;
            idx++;

            for (int nbr: graph.get(front)) {
                indegrees[nbr]--;

                if(indegrees[nbr] == 0) q.add(nbr);
            }
        }

        if (idx != n) return new int[0];

        return ans;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int prerequisites[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                prerequisites[i][j]= sc.nextInt();
        }

        Solution Obj = new Solution();
        int []ans=Obj.canFinish(N,prerequisites);
        if(ans.length==0)
            System.out.println(-1);
        else{
            for(int i=0; i<ans.length; i++){
                System.out.print(ans[i]+" ");
            }

            System.out.println("");
        }

    }
}