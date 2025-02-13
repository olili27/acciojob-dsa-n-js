import java.util.*;
class Node {
    int data;
    Node left, right;
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree
{
    Node constructBST(int[]arr,int start,int end,Node root)
    {
        if(start>end)
            return null;
        int mid=(start+end)/2;

        if(root==null)
            root=new Node(arr[mid]);

        root.left=constructBST(arr,start,mid-1, root.left);
        root.right=constructBST(arr,mid+1,end, root.right);

        return root;

    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[]=new int[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        int k=sc.nextInt();
        Arrays.sort(arr);
        Node root=null;
        BinarySearchTree bst=new BinarySearchTree();
        root=bst.constructBST(arr,0,n-1,root);

        Solution Accio = new Solution();
        int ans=Accio.solve(root,k);
        System.out.println(ans);
        sc.close();

    }
}

class Solution
{

    class Pair {
        Node node;
        int state;

        Pair(Node n, int s) {
            node = n;
            state = s;
        }
    }
    Node getNext(Stack<Pair> stack) {
        while(stack.size() > 0) {
            Pair top = stack.peek();

            if(top.state == 1) {
                if(top.node.right != null) {
                    stack.push(new Pair(top.node.right, 1));
                }

                top.state++;
            } else if(top.state == 2) {
                if(top.node.left != null) {
                    stack.push(new Pair(top.node.left, 1));
                }
                top.state++;
                return top.node;
            } else stack.pop();
        }

        return null;
    }
    int solve(Node node, int k)
    {
        // your cod here
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(node, 1));

        Node curr = getNext(stack);

        while(curr != null && k > 1) {
            curr = getNext(stack);
            k--;
        }

        return curr.data;
    }
}