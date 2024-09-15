//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}
class BT_To_DLL
{
    
    static Node buildTree(String str)throws IOException{
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    

	void inorder(Node node)
	{
		if(node==null)
			return ;
		else
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
	}
	public static void printList(Node head) 
    {
		Node prev = head;
        while (head != null) 
        {
            System.out.print(head.data + " ");
			prev = head;
            head = head.right;
        }
		
		System.out.println();
		while(prev != null)
		{
			System.out.print(prev.data+" ");
			prev = prev.left;
		}
    }
	public static void main(String args[])  throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
			    
			    Node ans = g.bToDLL(root);
			    printList(ans);
                t--;
                System.out.println();
	        }
			
		
	}
}

// } Driver Code Ends


//User function Template for Java

/* class Node
class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}*/

//This function should return head to the DLL
class Solution {
    // Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root) {
        if (root == null) {
            return null;
        }
        
        // Stack for in-order traversal
        Stack<Node> stack = new Stack<>();
        Node current = root;
        Node head = null; // Head of the DLL
        Node prev = null; // To track the previous node in DLL

        // In-order traversal using stack
        while (current != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current subtree
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Pop the node from stack
            current = stack.pop();

            // If this is the first node (leftmost node), it becomes the head of the DLL
            if (prev == null) {
                head = current;
            } else {
                // Adjust pointers to link current node with previous node in DLL
                prev.right = current;
                current.left = prev;
            }

            // Update prev to the current node
            prev = current;

            // Move to the right subtree
            current = current.right;
        }

        // Return the head of the constructed DLL
        return head;
    }
}
