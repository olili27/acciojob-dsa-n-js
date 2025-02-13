import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> e = new ArrayList<Integer>();
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            Edges.add(e);
        }
        Solution ob = new Solution();
        if (ob.check(N, M, Edges)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

}

class Solution {
        boolean hamiltonPath(int currNode, boolean [] visited, ArrayList<Integer> psf, ArrayList<ArrayList<Integer>> graph, int ogSrc) {
            int numberOfNodes = graph.size() - 1;

            if (psf.size() == numberOfNodes - 1) {
//                psf.add(currNode);
//                System.out.println(psf);
//                psf.remove(psf.size() - 1);

//                boolean isCycle =  false;
//                for (int nbr: graph.get(currNode)) {
//                    if (nbr == ogSrc) {
//                        isCycle = true;
////                        break;
//                    }
//                }
//
//                if (isCycle) System.out.println(" (cycle)");
//                else System.out.println();

                return true;
            }

            visited[currNode] = true;
            psf.add(currNode);
            boolean ans = false;

            for (int nbr: graph.get(currNode)) {
               if (!visited[nbr]) {
                   boolean isHamilton = hamiltonPath(nbr, visited, psf, graph, ogSrc);
                   if (isHamilton) ans = true;
               }
            }

            visited[currNode] = false;
            psf.remove(psf.size() - 1);

            return ans;
        }
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        // your code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (ArrayList<Integer> edge: Edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            graph.get(v).add(u);
            graph.get(u).add(v);
        }

        boolean [] visited = new boolean[N + 1];
        ArrayList<Integer> psf = new ArrayList<>();
        boolean ans = false;

        for (int i = 1; i <= N; i++) {
            boolean foundPath = hamiltonPath(i, visited, psf, graph, i);
            if (foundPath) ans = true;
        }

        return ans;
    }
}