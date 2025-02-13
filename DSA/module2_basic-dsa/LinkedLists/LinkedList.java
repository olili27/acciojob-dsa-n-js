public class LinkedList {
    Node head; // reference variable to the first Node

    // function to insert a new Node at the end of the linked list
    void insertAtEnd(int val) {
        // 1. create a node with the value 'val', whose next has a value = null
        Node n = new Node(val);

        // 2. check if the linked list is empty
        if (this.head == null) {
            this.head = n;
            return;
        }

        // 3. make a variable, 'temp' to refer to the last node of the linked list =>
        // last node's next = null
        Node temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // 4. now insert new node 'n', after the node referenced by 'temp'
        temp.next = n;
    }

    // delete a node in the middle or at the end
    void deleteNode(int position) {

        // delete a head node
        if (position == 0) {
            this.head = this.head.next;
            return;
        }

        // delete any other node i.e any middle node pr last node
        Node prev = this.head;
        for (int i = 1; i < position; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }

    // function to print the linked list
    void print() {
        Node temp = this.head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    
    static int getSize(Node head) {
        int size = 0;

        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            size++;
        }

        return size;
    }

}
