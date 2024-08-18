//{ Driver Code Starts

// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Gfg {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
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
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            int k = Integer.parseInt(br.readLine());
            Node[] pre = new Node[1];
            Node[] suc = new Node[1];
            Solution.findPreSuc(root, pre, suc, k);
            if (pre[0] != null) {
                System.out.print(pre[0].data + " ");
            } else {
                System.out.print("-1 ");
            }
            if (suc[0] != null) {
                System.out.println(suc[0].data);
            } else {
                System.out.println("-1 ");
            }
        }
    }
}
// } Driver Code Ends




class Solution {
    static Node maxl = null; // To store the maximum node in left subtree (predecessor)
    static Node maxr = null; // To store the minimum node in right subtree (successor)

    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        findPredecessor(root, key);
        findSuccessor(root, key);
        pre[0] = maxl;
        suc[0] = maxr;
        
        // Reset for the next query
        // maxl = null;
        maxr = null;
    }

    private static void findPredecessor(Node root, int key) {
        if (root == null) {
            return;
        }

        if (root.data >= key) {
            findPredecessor(root.left, key);
        } else { // root.data < key
            if (maxl == null || root.data > maxl.data) {
                maxl = root; // Update predecessor
            }
            findPredecessor(root.right, key);
        }
    }

    private static void findSuccessor(Node root, int key) {
        if (root == null) {
            return;
        }

        if (root.data <= key) {
            findSuccessor(root.right, key);
        } else { // root.data > key
            if (maxr == null || root.data < maxr.data) {
                maxr = root; // Update successor
            }
            findSuccessor(root.left, key);
        }
    }
}


