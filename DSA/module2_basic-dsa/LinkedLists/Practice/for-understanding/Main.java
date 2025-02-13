public class Main{
    public static void main(String[] args) {
        LinkedList l1 =  new LinkedList();

        for(int i = 1; i < 6; i++) {
            l1.insertAtEnd(i);
        }

        LinkedList.print(l1.head);
        l1.head = LinkedList.reverseList(l1.head);
        LinkedList.print(l1.head);

        // l1.reversal(l1.head);
        // LinkedList.print(l1.head);
    }
}

class Node{
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

class LinkedList{
    Node head;
    Node tail;

    void insertAtEnd(int val) {
        Node node = new Node(val);

        if(head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        tail = node;
    }

    static void print(Node head) {
        Node node = head;
        while(node != null) {
            System.out.print(node.val + " ");;
            node = node.next;
        }
        System.out.println();
    }

    static Node reverseList(Node head) {

        if(head == null || head.next == null) {
            return head;
        }

        Node temp = head;
        
        Node newStart = reverseList(temp.next);
        temp.next.next = temp;
        temp.next = null;

        head = newStart;

        return head;

    }

    void reversal(Node head) {
        int size = getSize(head);
        int i = 0, j = size - 1;

        while(i < j) {
            Node nodeAtJ = getNodeAt(head, j);
            Node nodeAtI = getNodeAt(head, i);

            int valAtJ = nodeAtJ.val;
            nodeAtJ.val = nodeAtI.val;
            nodeAtI.val = valAtJ;
            i++;
            j--;
        }

    }

    Node getNodeAt(Node head, int idx) {
        if(head == null || head.next == null) {
            return null;
        }

        Node temp = head;
        for(int i = 0; i < idx; i++) {
            temp = temp.next;
        }

        return temp;
    }

    int getSize(Node head) {
        Node temp = head;
        int count = 0;

        while(temp != null) {
            temp = temp.next;
            count++;
        }

        return count;
    }
}