import java.util.LinkedList;
import java.util.Queue;
import java.io.*;



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
            if (i >= ip.length) break;
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
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        Node root1 = buildTree(s1);
//        Solution g = new Solution();
        System.out.println(Solution.diameter(root1));
    }
}


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

class Solution {

//    static int height(Node root) {
//        if(root == null) return 0;
//
//        int left = height(root.left);
//        int right = height(root.right);
//
//        return Math.max(left, right) + 1;
//    }
//
//    public static int diameter(Node root) {
//        // Your code here
//        if(root == null) return 0;
//
//        int leftDiameter = diameter(root.left);
//        int rightDiameter = diameter(root.right);
//
//        int leftHeight = height(root.left);
//        int rightHeight = height(root.right);
//        int diameterThruRoot = leftHeight + rightHeight + 1;
//
//        return Math.max(diameterThruRoot, Math.max(leftDiameter, rightDiameter));
//    }

    static class Pair{
        int height;
        int diameter;

        Pair() {}

        Pair(int h, int d) {
            height = h;
            diameter = d;
        }
    }

    static Pair getDiameter(Node root) {
        if(root == null) return new Pair();

        // get diameter, height of the left subtree
        Pair leftPair = getDiameter(root.left);

        // get diameter, height of the right-subtree
        Pair rightPair = getDiameter(root.right);

        // get the diameter through the root
        int diameterThruRoot = rightPair.height + leftPair.height + 1;

        // get the height of the tree -> root to last node
        int treeHeight = Math.max(rightPair.height, leftPair.height) + 1;

        // return the maximum btn diameter through the root and max btn the left-diameter and right diameter
        int diameter = Math.max(diameterThruRoot, Math.max(leftPair.diameter, rightPair.diameter));

        return new Pair(treeHeight, diameter);
    }

    public static int diameter(Node root) {
        // Your code here
        if(root == null) return 0;

        Pair ans = getDiameter(root);

        return ans.diameter;
    }
}