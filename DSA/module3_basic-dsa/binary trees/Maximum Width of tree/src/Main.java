import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Main {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length)
                break;
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        Node root = buildTree(s);
        Solution tree = new Solution();
        int ans = tree.solve(root);
        System.out.println(ans);

        sc.close();
    }
}

class Solution {

    class Pair {
        Node node;
        int index;
        Pair(Node node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    public int solve(Node root) {
        // your code here
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 1));

        int maxWidth = Integer.MIN_VALUE;

        while(q.size() > 0) {
            int size = q.size();
            int minIndex = Integer.MAX_VALUE;
            int maxIndex = Integer.MIN_VALUE;

            for(int i = 0; i < size; i++) {
                Pair pair = q.remove();

                minIndex = Math.min(minIndex, pair.index);
                maxIndex = Math.max(maxIndex, pair.index);

                if(pair.node.left != null) q.add(new Pair(pair.node.left, 2 * pair.index));
                if(pair.node.right != null) q.add(new Pair(pair.node.right, 2 * pair.index + 1));
            }

            int currentWidth = maxIndex - minIndex + 1;
            maxWidth = Math.max(maxWidth, currentWidth);
        }

        return maxWidth;
    }
}
