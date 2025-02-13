
import java.util.*;

class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
class BST{
    Node root = null;
    BST(){

    }
    BST(Node root){
        root=root;
    }
    Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.val == val)
            return root;
        if(val < root.val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    void print(Node root){
        System.out.print(root.val + " ");
        if(root.left != null){
            print(root.left);
        }
        if(root.right != null){
            print(root.right);
        }
    }
}

class Solution{

    int getMin(Node root) {
        if(root.left == null) return  root.val;

        return getMin(root.left);
    }
    public Node deleteNode(Node root, int val){
        // WRITE YOUR CODE HERE

        // if root is null
        if(root == null) return null;


        if(root.val == val) {
            // if root does not have a child
            if(root.left == null && root.right == null) return null;

            // if has only right child
            if(root.left == null && root.right != null) return root.right;

            // if has only left child
            if(root.left != null && root.right == null) return root.left;

            // if has both right and left
            if(root.left != null && root.right != null) {
                // get the minValue from the right subtree
                int minValue = getMin(root.right);

                //overwrite the root value  with the minValue;
                root.val = minValue;

                // delete minValue from the right subtree
                root.right = deleteNode(root.right, minValue);
            }
        }

        else if(root.val < val) {
            root.right = deleteNode(root.right, val);
        } else {
            root.left = deleteNode(root.left, val);
        }

        return root;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        BST t = new BST();
        for(int i = 0; i < n; i++){
            t.root = t.insert(t.root, input.nextInt());
        }
        Solution obj=new Solution();
        t.root= obj.deleteNode(t.root, k);
        t.print(t.root);
    }
}