public class Main {
    Node head;
    Node tail;

     void addLast(int val) {
        Node node = new Node(val);

        if(this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
    }

    void addFirst(int val) {
        Node node = new Node(val);

        if(this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    static void print(Node head) {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.val);
            temp = temp.next;
        }
        System.out.println();
    }

    void removefirst() {
        if(this.head == null) {
            System.out.println("there is nothing to be removed");
            return;
        }

        if(head == tail) {
            head = null;
            tail = null;
            return;
        }

        head = head.next;
    }

    Node getAt(int position) {
        if(position < 0) {
            System.out.println("given position is below range");
            return null;
        }

        Node temp = this.head;

        for(int i = 0; i < position; i++) {

            if(temp == null) {
                System.out.println("given position was above the range");
                return null;
            }

            temp = temp.next;
        }

        return temp;
    }

    void addAt(int idx, int val) {
        if(idx == 0) {
            addFirst(val);
            return;
        }

        Node node = new Node(val);

        Node temp = getAt(idx - 1);
        Node nextOfTemp = temp.next;

        temp.next = node;
        node.next = nextOfTemp;
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

    Node getMiNode(Node head) {
        int size = getSize(head);
        Node mid = getAt(size / 2);
        return mid;
    }

    Node getMid2(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    boolean hasACycle(Node head) {
        Node tort = head;
        Node hare = head;

        while(hare != null && hare.next != null) {
            hare = hare.next.next;
            tort = tort.next;
            
            if(hare == tort) {
                return true;
            }
        }

        return false;
    }

    Node getStartOfCycle(Node head) {
        if(head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast) {
                break;
            }
        }

        if(slow != fast) { // no cycle
            return null;
        }

        // let slow refer to head;
        slow = head;

        // keep moving at the same pace
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    Node reverseList(Node head) {
        int n = getSize(head);

        int i = 0;
        int j = n - 1;

        while(i < j) {
            Node nodeAtI = getAt(i);
            Node nodeAtJ = getAt(j);

            int valAtI = nodeAtI.val;
            int valAtJ = nodeAtJ.val;

            nodeAtI.val = valAtJ;
            nodeAtJ.val = valAtI;

            i++;
            j--;
        }
        return head;
    }

    Node reverseList2(Node head) {
        Node prev = null;
        Node curr = head;

        while(curr != null) {
            // save next pointer
            Node nextOfCurr = curr.next;

            // reverse  the next  to point to prev
            curr.next = prev;


            // update prev to point to curr, curr to point to next of curr
            prev = curr;
            curr = nextOfCurr;
        }

        // head is now at prev
        head = prev;
        return head;
    }

    Node merge(Node p1, Node p2) {
        Node dummy = new Node(-1);
        Node temp = dummy;

        while(p1 != null && p2 != null) {
            
            if(p1.val < p2.val) {
                temp.next = p1;
                p1 = p1.next;
            } else {
                temp.next = p2;
                p2 = p2.next;
            }

            temp = temp.next;
        }

        if(p1 == null) {
            temp.next = p2;
        }

        if(p2 == null) {
            temp.next = p1;
        }

        return dummy.next;
    }

    void deleteNode(Node node) {
        Node nextOfNode = node.next;

        node.val = nextOfNode.val;

        Node nextOfNextOfNode = nextOfNode.next;

        node.next = nextOfNextOfNode;
    }

    Node getIntersectionNode(Node head1, Node head2) {
        Node temp = head1;

        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = head1;

        Node intersectNode = getStartOfCycle(head2);

        temp.next = null;
        return intersectNode;
    }
}
