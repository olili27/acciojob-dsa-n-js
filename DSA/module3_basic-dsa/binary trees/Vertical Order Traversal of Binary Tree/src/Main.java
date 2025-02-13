import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.lang.*;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Solution {

    int minLevel = 0;
    int maxLevel = 0;

    static class Pair implements Comparable<Pair>{
        TreeNode node;
        int vlevel;

        Pair(TreeNode node, int vlevel) {
            this.node = node;
            this.vlevel = vlevel;
        }

        @Override
        public int compareTo(Pair other) {
            if(this.vlevel == other.vlevel) return this.node.data - other.node.data;

            return this.vlevel - other.vlevel;
        }
    }

    void verticalLevels(TreeNode root, int level) {
        if(root == null) return;

        verticalLevels(root.left, level - 1);
        verticalLevels(root.right, level + 1);

        minLevel = Math.min(minLevel, level);
        maxLevel = Math.max(maxLevel, level);
    }
    List<List<Integer>> VerticalTraversal(TreeNode root) {
        //Write your code here
        verticalLevels(root, 0);

        int width = maxLevel - minLevel;
        int numberOfLevels =  width + 1;

        List<List<Integer>> verticalOrders = new ArrayList<>();
        for(int i = 0; i < numberOfLevels; i++) {
            verticalOrders.add(new ArrayList<>());
        }

        PriorityQueue<Pair> parentPQ = new PriorityQueue<>();
        parentPQ.add(new Pair(root, -minLevel));

        while(parentPQ.size() > 0) {
            int size = parentPQ.size();

            PriorityQueue<Pair> childPQ = new PriorityQueue<>();

            for(int i = 0; i < size; i++) {
                Pair pair = parentPQ.remove();

                verticalOrders.get(pair.vlevel).add(pair.node.data);

                if(pair.node.left != null) childPQ.add(new Pair(pair.node.left, pair.vlevel - 1));
                if(pair.node.right != null) childPQ.add(new Pair(pair.node.right, pair.vlevel + 1));
            }

            parentPQ = childPQ;
        }

        return verticalOrders;
    }
}

class Main {

    static TreeNode buildTree(String str) {
        if(str.length()==0 || str.charAt(0)=='N')
            return null;

        String ip[] = str.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            TreeNode currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t > 0){
            String s = br.readLine();
            TreeNode root = buildTree(s);
            Solution ob = new Solution();
            List<List<Integer>> ans = ob.VerticalTraversal(root);
            for(int i = 0; i < ans.size(); i++) {
                for(int a : ans.get(i)) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
            System.out.println();
            t--;
        }
    }
}