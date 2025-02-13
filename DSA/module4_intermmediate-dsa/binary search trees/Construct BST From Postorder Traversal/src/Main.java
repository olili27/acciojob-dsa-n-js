import java.util.Scanner;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }


    static int idx;
    static TreeNode build(int [] post,  int min, int max) {
        if(idx < 0 || post[idx] < min || post[idx] > max) return null;

        TreeNode node = new TreeNode(post[idx]);
        idx--;

        node.right = build(post, node.val, max);
        node.left = build(post, min, node.val);

        return node;
    }

    public static TreeNode CreateTree(int n,int[] postOrder) {
        //write code here
        idx = n - 1;

        return build(postOrder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append("->" + node.val + "<-");
        sb.append((node.right != null ? node.right.val : "."));
        System.out.println(sb.toString());
        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        TreeNode root = CreateTree(n,post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}