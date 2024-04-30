//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node num1 = new Node(val);
            Node tail = num1;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node num2 = new Node(val);
            tail = num2;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
    // Helper function to reverse a linked list
    static Node reverseList(Node head) {
        Node current = head, previous = null;
        
        while(current != null) {
            Node nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        
        return previous;
    }

    // Function to add two linked lists representing numbers
    static Node addTwoLists(Node num1, Node num2) {
        // If one list is empty, return the other list
        if(num1 == null)
            return num2;
        if(num2 == null)
            return num1;
        
        // Reverse both input lists
        num1 = reverseList(num1);
        num2 = reverseList(num2);
        
        // Initialize a dummy node to build the result list
        Node dummy = new Node(-1);
        Node current = dummy;
        
        int carry = 0;
        // Iterate through both lists or carry is still present
        while(num1 != null || num2 != null || carry == 1) {
            int sum = carry;
            // Add values of both nodes if available
            if(num1 != null) {
                sum += num1.data;
                num1 = num1.next;
            }
            if(num2 != null) {
                sum += num2.data;
                num2 = num2.next;
            }
            
            // Calculate the value and carry for the current position
            int value = sum % 10;
            carry = sum / 10;
            
            // Append the new node with calculated value to the result list
            current.next = new Node(value);
            current = current.next;
        }
        
        // Reverse the result list and remove leading zeros if any
        dummy.next = reverseList(dummy.next);
        current = dummy.next;
        while(current != null && current.data == 0)
            current = current.next;
        
        // If the result list is empty, return a single node with value 0
        return current == null ? new Node(0) : current;
    }
}