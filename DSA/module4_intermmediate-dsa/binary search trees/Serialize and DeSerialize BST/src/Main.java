import java.util.*;

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

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        //Write code here
        if (root == null) return "";

        StringBuilder res = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                res.append("n ");
                continue;
            }

            res.append(node.val + " ");

            q.add(node.left);
            q.add(node.right);
        }

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String str) {
        //Write code here
        if (str.equals("")) return null;

        String [] arr = str.split(" ");

        Queue<TreeNode> q = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.add(root);

        int idx = 1;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (!arr[idx].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(arr[idx]));
                node.left = left;

                q.add(left);
            }

            if (!arr[++idx].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(arr[idx]));
                node.right = right;

                q.add(right);
            }

            idx++;
        }

        return root;
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        String s = serialize(root);
        display(deserialize(s));
    }

    public static void main(String[] args) {
        solve();
    }
}