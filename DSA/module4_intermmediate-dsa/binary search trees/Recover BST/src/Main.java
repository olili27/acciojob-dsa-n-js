import com.sun.source.tree.Tree;

import java.util.Scanner;
import java.util.Stack;

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

    static class Pair {
        TreeNode node;
        int state;

        Pair(TreeNode n, int s) {
            node = n;
            state = s;
        }
    }

    static TreeNode getNext(Stack<Pair> stack) {
        while(stack.size() > 0) {
            Pair top = stack.peek();

            if(top.state == 1) {
                top.state++;

                if(top.node.left != null) {
                    stack.push(new Pair(top.node.left, 1));
                }
            }
            else if(top.state == 2) {
                top.state++;

                if(top.node.right != null) {
                    stack.push(new Pair(top.node.right, 1));
                }

                return top.node;
            }

            else {
                stack.pop();
            }
        }

        return null;
    }

    public static void recoverTree(TreeNode root) {
        //Write code here
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        TreeNode point1 = null, point2 = null;
        TreeNode prev = null, current = getNext(stack);

        while(current != null) {
            if(prev != null && prev.val > current.val) {
                if(point1 == null) {
                    point1 = prev;
                    point2 = current;
                } else {
                    point2 = current;
                }
            }

            prev = current;
            current = getNext(stack);
        }

        int temp = point1.val;
        point1.val = point2.val;
        point2.val = temp;
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
        recoverTree(root);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}