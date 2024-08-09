//{ Driver Code Starts
// Initial Template for Java

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


// } Driver Code Ends
/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/

class Solution {
    // Function to rotate a linked list.
   public Node rotate(Node head, int k) {
        // add code here
        
        Node curr = head;
        while(curr.next != null) curr = curr.next;
        
        curr.next = head;
        Node temp = head, prev = null;
        
        int count = 0;
        while(temp != null) {
            if (count == k) {
                prev.next = null;
                break;
            }
            else {
                prev = temp;
                temp = temp.next;
            }
            count++;
        }
        
        head = temp;
        return head;
    }
}




    // public Node rotate(Node head, int k) {
    //     if (head == null || k == 0) {
    //         return head; // No rotation needed
    //     }
        
    //   int kkk=0;
    //   Node start=head;
    // //   Node kk;
    //   Node curr=head;
    //   while(kkk<k-1 && curr!=null){
    //       curr=curr.next;
    //       kkk++;
    //   }
    //   Node  kk=curr.next;
    //   curr.next=null;
    //   Node curr1=kk;
    //   while(curr1.next!=null){
    //       curr1=curr1.next;
    //   }
    //   curr1.next=start;
    //   return kk;
       
       
    // }


//{ Driver Code Starts.

public class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            if (!input.isEmpty()) {
                String[] numbers = input.split("\\s+");
                for (String num : numbers) {
                    if (!num.isEmpty()) {
                        arr.add(Integer.parseInt(num));
                    }
                }
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); ++i) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            head = ob.rotate(head, k);
            printList(head);
        }
    }
}

// } Driver Code Ends