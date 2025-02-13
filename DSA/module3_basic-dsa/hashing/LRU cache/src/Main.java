import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cap = sc.nextInt(), q = sc.nextInt();
        String[] queries = new String[q];
        for (int i = 0; i < q; i++) {
            String s = sc.next();
            if (s.equals("GET"))
                s += " " + sc.nextInt();
            else
                s += " " + sc.nextInt() + " " + sc.nextInt();
            queries[i] = s;
        }
        sc.close();
        LRUCache lruCache = new LRUCache(cap);
        for (String s : queries) {
            String[] arr = s.split(" ");
            if (arr.length == 3)
                lruCache.set(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
            else
                System.out.println(lruCache.get(Integer.parseInt(arr[1])));
        }
    }
}

class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node() {
        this.key = 0;
        this.val = 0;
    }
    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    // your code here
    Node head;
    Node tail;
    int maxCapacity;
    HashMap<Integer, Node> cache;

    void addNode(Node node) {
        Node nextOfHead = head.next;
        node.next = nextOfHead;
        node.prev = head;

        head.next = node;
        nextOfHead.prev = node;
    }

    void removeNode(Node node) {
        Node after =  node.next;
        Node before = node.prev;

        after.prev = before;
        before.next = after;

        node.next = null;
        node.prev = null;
    }

    void moveToFront(Node node) {
        removeNode(node);;
        addNode(node);;
    }
    public LRUCache(int capacity) {
        // your code here
        this.head = new Node();
        this.tail = new Node();

        this.maxCapacity = capacity;
        this.cache = new HashMap<>();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        // your code here
        if(!cache.containsKey(key)) return -1;

        Node gotKey = cache.get(key);
        moveToFront(gotKey);
         return gotKey.val;
    }

    public void set(int key, int value) {
        // your code here
        if(cache.containsKey(key)) {
            Node gotKey = cache.get(key);
            gotKey.val = value;
            moveToFront(gotKey);
        } else {
            if(cache.size() == maxCapacity) {
                Node lruNode = tail.prev;
                cache.remove(lruNode.key);
                removeNode(lruNode);;
            }

            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
        }
    }

}