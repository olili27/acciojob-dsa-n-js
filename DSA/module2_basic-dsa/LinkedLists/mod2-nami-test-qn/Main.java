public class Main {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int treasure(Node head) {
        int len = size(head);
        int i = 0;
        int j = len - 1;

        int max = 0;

        while(i < j) {
            int sum = 0;

            Node n1 = getAt(head, i);
            Node n2 = getAt(head, j);

            sum = n1.data + n2.data;

            if(sum > max) {
                max = sum;
            }

            i++;
            j--;
        }

        return max;
    }

    // i used this method to get the size of the linked list
    static int size(Node head) {
        Node temp = head;
        int len = 0;

        while (temp != null) {
            temp = temp.next;
            len++;
        }

        return len;
    }

    // i used this method to get at particular node
    static Node getAt(Node head, int idx) {
        if (head == null) {
            return null;
        }

        Node temp = head;

        for (int i = 0; i < idx; i++) {

            if (temp == null) {
                return null;
            }

            temp = temp.next;
        }

        return temp;
    }
}

class List {
    Node head;

    // i used this method to get the size of the linked list
    // static int size(Node head) {
    //     Node temp = head;
    //     int len = 0;

    //     while(temp != null) {
    //         temp = temp.next;
    //         len++;
    //     }

    //     return len;
    // }

    // i used this method to get at particular node
    // static Node getAt(Node head, int idx) {
    //     if(head == null) {
    //         return null;
    //     }

    //     Node temp = head;

    //     for(int i = 0; i < idx; i++) {

    //         if(temp == null) {
    //             return null;
    //         }

    //         temp = temp.next;
    //     }

    //     return temp;
    // }
}

class Node {
    int data;
    Node next;

    Node(int val) {
        this.data = val;
    }
}