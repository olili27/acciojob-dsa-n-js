import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.lang.*;

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

public class Main {

    static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Node ans = Obj.bstFromLevel(arr, n);
        printLevelOrder(ans);
        sc.close();
    }
}

class Solution {

    class PotentialParent {
        int min, max;
        Node parent;

        PotentialParent(Node p, int low, int high) {
            parent = p;
            min = low;
            max = high;
        }
    }
    Node bstFromLevel(int arr[], int n) {
        // write code here
        Node root = new Node(arr[0]);

        Queue<PotentialParent> q = new LinkedList<>();
        q.add(new PotentialParent(root, Integer.MIN_VALUE, root.data));
        q.add(new PotentialParent(root, root.data, Integer.MAX_VALUE));

        int idx = 1;

        while(q.size() > 0) {
            PotentialParent front = q.remove();

            if(idx == n) break;

            if(arr[idx] <= front.min || arr[idx] >= front.max) continue;

            Node child = new Node(arr[idx]);
            idx++;

            if(child.data < front.parent.data) {
                front.parent.left = child;
            } else front.parent.right = child;

            q.add(new PotentialParent(child, front.min, child.data));
            q.add(new PotentialParent(child, child.data, front.max));
        }

        return root;
    }
}