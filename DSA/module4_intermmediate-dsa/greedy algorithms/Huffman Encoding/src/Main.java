import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int N = S.length();
        Solution ob = new Solution();
        String[] element = br.readLine().trim().split("\\s+");
        int[] f = new int[N];
        for(int i = 0; i < N; i++){
            f[i] = Integer.parseInt(element[i]);
        }
        ArrayList<String> res  = ob.huffmanCodes(S,f,N);
        for(int i = 0; i < res.size(); i++)
        {
            System.out.print(res.get(i)+" ");
        }
        System.out.println();

    }
}

class Solution {
    class Node {
        int freq;
        char ch;
        Node left;
        Node right;

        Node(char ch, int freq) {
            this.freq = freq;
            this.ch = ch;
        }
    }

    void dfs(Node root, ArrayList<String> ans, String psf) {
        if (root.left == null && root.right == null) {
            ans.add(psf);
            return;
        }

        dfs(root.left, ans, psf + "0");
        dfs(root.right, ans, psf + "1");
    }
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        // Code here
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
           return a.freq < b.freq ? -1 : 1;
        });

        for (int i = 0; i < N; i++) {
            int freq = f[i];
            char ch = S.charAt(i);

            pq.add(new Node(ch, freq));
        }

        while (pq.size() > 1) {
            Node smaller = pq.remove();
            Node larger = pq.remove();

            Node parent = new Node('.', smaller.freq + larger.freq);
            parent.left = smaller;
            parent.right = larger;

            pq.add(parent);
        }

        Node root = pq.remove();

        ArrayList<String> ans = new ArrayList<>();
        dfs(root, ans, "");

        return ans;
    }

}