import java.util.*;

public class CommonLLMethods {
    public static void LinkedList(String args []) {
                
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        
        // create a linked list object
        LinkedList L1 = new LinkedList();
        
        // feed the linked list with nodes
        while(num > 0) {
            int val = s.nextInt();

            // insert new node at the end of the linked list
            L1.insertAtEnd(val);
            num--;
        }
        
        // print linked list
        LinkedList.print(L1.head);
        

        // insert new node at start of the linked list
        L1.insertAtHead(50);
        
        LinkedList.print(L1.head);
        
        // delete a node at a given position from the linked list
        L1.deleteNode(2);
        
        LinkedList.print(L1.head);
        

        // insert a new node a specific position
        L1.insertAtPosition(80, 2);
        
        LinkedList.print(L1.head);
    }
}

class Node {
    int val;
    Node next;
    
    Node(int val) {
        this.val = val;
    }
}

class LinkedList{
    
    // refernce variable to the first node in the linked list
    Node head;
    
    void insertAtEnd(int val) {
        Node node = new Node(val);
        
        if(this.head == null) {
            this.head = node;
            return;
        }
        
        Node temp = this.head;
        
        while(temp.next != null) {
            temp = temp.next;
        }
        
        temp.next = node;
    }
    
    void insertAtPosition(int val, int position) {
        if(position == 0) {
            this.insertAtHead(val);
            return;
        }
        
        Node node = new Node(val);
        
        Node temp = this.head;
        for(int i = 1; i < position; i++) {
            temp = temp.next;
        }
        
        node.next = temp.next;
        temp.next = node;
    }
    
    void insertAtHead(int val) {
        Node node = new Node(val);

        if(this.head == null) {
            this.head = node;
            return;
        }
        
        node.next = this.head;
        this.head = node;
    }
    
    static void print(Node head) {
        Node temp = head;
        
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    void deleteNode(int positionToBeDeleted) {
        
        if(positionToBeDeleted == 0) {
            this.head = this.head.next;
            return;
        }
        
        Node prev = this.head;
        for(int nodePosition = 1; nodePosition < positionToBeDeleted; nodePosition++) {
            prev = prev.next;
        }
        
        prev.next = prev.next.next;
        
    }
}
