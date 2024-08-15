//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
// import java.math.BigInteger;
class Solution {
    

public Node addOne(Node head) {
        // Reverse the linked list
        head = reverseList(head);

        Node curr = head;
        int carry = 1; // We start with a carry of 1 because we're adding one

        // Traverse the reversed list and add the carry
        while (curr != null) {
            curr.data += carry;

            if (curr.data < 10) {
                carry = 0; // No carry forward if the sum is less than 10
                break; // No need to continue if there's no carry
            } else {
                curr.data = 0; // Reset the current node to 0 if it was 9 and caused a carry
                carry = 1; // Carry forward to the next digit
            }

            curr = curr.next;
        }

        // If carry is still 1 after processing all nodes, add a new node at the end
        if (carry == 1) {
            Node newNode = new Node(1);
            curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }

        // Reverse the list back to its original order
        head = reverseList(head);

        return head;
    }

    // Helper function to reverse a linked list
    private Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

}
