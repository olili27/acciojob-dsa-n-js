public class LinkedListReversal {

    static class Node {
        private int val;
        private Node next;

        Node(int val) {
            this.val = val;
        }

        void setNext(Node node) {
            this.next = node;
        }

        Node getNext() {
            return next;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);

        printList(n1);
        Node reverse = reverseList(n1);
        printList(reverse);
        printList(n1);
    }

    static Node reverseList(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node newHead = reverseList(node.next);

        node.next.next = node;
        node.next = null;

        return newHead;
    }

    public Node mergeSort(Node node1, Node node2) {
        if(node1 == null) {
            return node2;
        }

        if(node2 == null) {
            return node1;
        }

        if(node1.val < node2.val) {
            node1.next = mergeSort(node1.next, node2);
            return node1;
        } else {
            node2.next = mergeSort(node1, node2.next);
            return node2;
        }
    }
    
    static void printList(Node node) {
        Node temp = node;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.getNext();
        }

        System.out.println();
    }
}
