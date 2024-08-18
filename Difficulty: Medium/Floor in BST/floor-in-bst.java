//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class Node {
    int data;
    Node right;
    Node left;

    Node(int val) {
        data = val;
        right = null;
        left = null;
    }
}

class GFG {

    public static Node insert(Node tree, int val) {
        Node temp = null;
        if (tree == null) {
            return new Node(val);
        }

        if (val < tree.data) {
            tree.left = insert(tree.left, val);
        } else if (val > tree.data) {
            tree.right = insert(tree.right, val);
        }

        return tree;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            Node root = null;
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int k = sc.nextInt();
                root = insert(root, k);
            }

            int s = sc.nextInt();

            Solution obj = new Solution();
            int ans = obj.floor(root, s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int floor(Node root, int x) {
        int floor = -1;

        // Traverse the tree until root is null
        while (root != null) {
            if (root.data == x) {
                // If the current node's dataue is equal to the key, return it as the floor
                return root.data;
            } else if (x > root.data) {
                // If the key is greater than the current node's dataue,
                // the current node could be a potential floor candidate
                floor = root.data;
                // Move to the right subtree to find a larger or equal floor
                root = root.right;
            } else {
                // If the key is smaller than the current node's dataue,
                // move to the left subtree to find a potential floor
                root = root.left;
            }
        }
        
        return floor;
    }
}