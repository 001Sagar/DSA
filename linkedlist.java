import java.util.*;

public class linkedlist {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to Pring the Input
    public static Node takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the head data");
        int data = sc.nextInt();
        Node head = null, tail = null;

        while (data != -1) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
            data = sc.nextInt();
        }
        return head;
    }

    // Function to print the LinkedList
    public static void print(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Function to find the length of the LinkedList
    public static int length(Node head) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    // Function to Reverse LinkedList
    public static Node reverse(Node head) {
        Node prev = null;
        Node next = null;
        Node curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Function to print the middle of a LinkedList
    public static Node midLNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Function to check the LinkedList is palindrom or not
    public static boolean ispalindrom(Node head) {
        Node midelement = midLNode(head);
        Node revmid = reverse(midelement);
        Node temp = head;
        while (revmid != null) {
            if (revmid.data != temp.data) {
                return false;
            }
            temp = temp.next;
            revmid = revmid.next;
        }

        return true;

    }

    // Function to insert a NewNode in the LinkedList
    public static Node insertNode(Node head, int pos, int val) {
        Node newNode = new Node(val);
        Node temp = head;

        if (pos == 0) {
            newNode.next = head;
            return newNode;
        }
        int count = 0;
        while(temp != null){
            if(count == pos-1){
                newNode.next = temp.next;
                temp.next = newNode;
                return head;
            }
            temp = temp.next;
        }

        return head;
    }

    // Delete a Node from a LinkedList
    public static Node delNode(Node head, int pos) {
        Node temp = head;
        if (pos == 0) {
            return temp.next;
        }
        int count = 0;
        while (temp != null) {
            if (count == pos - 1) {
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
            count++;
        }

        return head;
    }

    public static void main(String[] args) {
        // Take a Input LinkedList
        Node head = takeInput();
        print(head);
        // Print the length of the linkedlist
        // int length = length(head);
        // System.out.println("The Length of the LinkedList " + length);

        // // Print the Reverse of a LinkedList
        // Node reverse = reverse(head);
        // print(reverse);

        // // The middle of the LinkedList
        // Node mid = midLNode(head);
        // print(mid);

        // check the LinkedList is Palindrom or not
        // System.out.println("The List is Palindrom " + ispalindrom(head));

        Node inerted = insertNode(head, 3, 30);
        print(inerted);
    }
}
