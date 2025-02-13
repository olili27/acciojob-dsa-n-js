import java.util.*;

public class Main {

    static Node getNode(int data) {
        // Allocate memory
        Node newNode = new Node();

        // put in the data
        newNode.data = data;
        newNode.left = newNode.right = null;
        return newNode;
    }

    // function to construct a BST from
    // its level order traversal
    static Node LevelOrder(Node root, int data) {
        if (root == null) {
            root = getNode(data);
            return root;
        }
        if (data <= root.data) root.left =
                LevelOrder(root.left, data); else root.right =
                LevelOrder(root.right, data);
        return root;
    }

    static Node constructBst(int arr[], int n) {
        if (n == 0) return null;
        Node root = null;

        for (int i = 0; i < n; i++) root = LevelOrder(root, arr[i]);

        return root;
    }

//    static int height(Node root) {
//        if(root == null) return 0;
//
//        int lh = height(root.left);
//        int rh = height(root.right);
//
//        return Math.max(lh, rh) + 1;
//    }
//
//
//    public static boolean isBalanced(Node root) {
//        // your code here
//        if(root == null) return true;
//
//        int lh = height(root.left);
//        int rh = height(root.right);
//
//        if(Math.abs(lh - rh) > 1) return false;
//
//        return isBalanced(root.left) && isBalanced(root.right);
//    }

    static class Pair{
        int height;
        boolean isBalanced;

        Pair() {
            isBalanced = true;
            height = 0;
        }

        Pair(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    static Pair balanced(Node root) {
        if(root == null) return new Pair();

        Pair leftSubTree = balanced(root.left);
        Pair rightSubTree = balanced(root.right);

        int diff = Math.abs(leftSubTree.height - rightSubTree.height);

        if(diff > 1 || !leftSubTree.isBalanced || !rightSubTree.isBalanced) {
            return new Pair(Math.max(leftSubTree.height, rightSubTree.height) + 1, false);
        } else return new Pair(Math.max(leftSubTree.height, rightSubTree.height) + 1, true);
    }

    public static boolean isBalanced(Node root) {
        // your code here
       Pair  answer = balanced(root);

       return answer.isBalanced;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tree = new int[n];
        for (int i = 0; i < n; i++) tree[i] = sc.nextInt();
        sc.close();
        Node root = constructBst(tree, n);
        if (isBalanced(root)) System.out.println("true"); else System.out.println(
                "false"
        );
    }
}

class Node {

    int data;
    Node left, right;
}