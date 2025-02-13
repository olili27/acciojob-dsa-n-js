import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class Main {
    static Node buildTree(String str){
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-- > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Solution tree = new Solution();
            ArrayList<Integer> arr = tree.topView(root);
            for(int x : arr)
                System.out.print(x +" ");
            System.out.println();
        }
    }
}


class qObj
{
    Node node;
    int level;
    qObj(Node n,int l)
    {
        node=n;
        level=l;
    }
}

class Solution
{

    class Pair {
        Node node;
        int level;

        Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public ArrayList<Integer> topView(Node root){
        //Write Code here
        ArrayList<Integer> answer = new ArrayList<>();

        if(root == null) return answer;

        Map<Integer, Integer> map = new HashMap<>();
        Queue<Pair> q =  new LinkedList<>();

        q.add(new Pair(root, 0));

        int maxLevel = Integer.MIN_VALUE;
        int minLevel = Integer.MAX_VALUE;

        while(q.size() > 0) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                Pair pair = q.remove();

                Node pairNode = pair.node;
                int currLevel = pair.level;

                maxLevel = Math.max(maxLevel, currLevel);
                minLevel = Math.min(minLevel, currLevel);

                if(!map.containsKey(currLevel)) map.put(currLevel, pairNode.data);

                if(pairNode.left != null) q.add(new Pair(pairNode.left, currLevel - 1));
                if(pairNode.right != null) q.add(new Pair(pairNode.right, currLevel + 1));

            }
        }

        for(int i = minLevel; i <= maxLevel; i++) {
            answer.add(map.get(i));
        }

        return answer;

    }
}

