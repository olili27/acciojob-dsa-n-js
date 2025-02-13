import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }

class Solution {
    void findParent(TreeNode  root, HashMap<TreeNode, TreeNode> hm) {
        if(root == null) return;

        if(root.left != null) hm.put(root.left, root);
        if(root.right != null) hm.put(root.right, root);

        findParent(root.left, hm);
        findParent(root.right, hm);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent =  new HashMap<>();

        findParent(root, parent);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);

        HashSet<TreeNode> visited = new HashSet<>();
        visited.add(target);

        List<Integer> list = new ArrayList<>();

        while(q.size() > 0) {
            int size = q.size();

            if(k == 0) {
                while(q.size() > 0) {
                    list.add(q.remove().val);
                }

                return list;
            }

            for(int i = 0; i < size; i++) {
                TreeNode node = q.remove();

                if(node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    q.add(node.left);
                }

                if(node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    q.add(node.right);
                }

                if(parent.getOrDefault(node, null) != null && !visited.contains(parent.get(node))) {
                    visited.add(parent.get(node));
                    q.add(parent.get(node));
                }
            }

            k--;
        }

        return list;

    }
}