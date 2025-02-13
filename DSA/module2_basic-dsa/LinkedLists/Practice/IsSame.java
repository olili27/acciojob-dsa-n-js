import java.util.*;

public class IsSame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        for (int i = 0; i < m; i++) {
            l1.insertAtEnd(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            l2.insertAtEnd(sc.nextInt());
        }
        l1.isSame(l1.head, l2.head);
        // above is same as l2.isSame(l1.head, l2.head);
    }

}



class LinkedList {
    Node head;

    void insertAtEnd(int val) {
        Node n = new Node(val);
        if (head == null) {
            head = n;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = n;
    }

    void isSame(Node head1, Node head2) {
        // We will go inside the while loop if both the LinkedLists
        // are not finished
        while (head1 != null && head2 != null) {
            if (head1.val == head2.val) {
                // Move ahead, and check the value in other Nodes
                head1 = head1.next;
                head2 = head2.next;
            } else { // The values in these 2 nodes aren't equal
                System.out.println(0);
                return;
            }
        }

        
        // At least one of the Linked List has ended
        // If one of the LinkedLists is not finished
        // One of head1 OR head2 will not be null.
        if (head1 != null || head2 != null)
            System.out.println(0);
        else // Both LinkedList got finished
            System.out.println(1);
    }
}
