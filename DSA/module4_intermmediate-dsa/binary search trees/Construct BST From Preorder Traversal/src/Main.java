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

    static TreeNode construct(int n, int [] pre, int min, int max) {
        if(idx == n) return null;

        if(pre[idx] <= min || pre[idx] >= max) return null;

        TreeNode node = new TreeNode(pre[idx]);
        idx++;

        node.left = construct(n, pre, min, node.val);
        node.right = construct(n, pre, node.val, max);

        return node;
    }

    public static TreeNode CreateTree(int n,int[] preOrder) {
        // Write Your Code here
        idx = 0;

        return construct(n, preOrder, Integer.MIN_VALUE, Integer.MAX_VALUE);
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
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = CreateTree(n,pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}