public class Test {
   public static void main(String[] args) {
    Node dummy = new Node(30);
    Node temp = dummy;
    Node node = new Node(10);
    temp = node.next;
   }
    
}

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}
