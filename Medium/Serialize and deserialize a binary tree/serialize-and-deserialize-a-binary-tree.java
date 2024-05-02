//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

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

class GfG {

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

    static void deletetree(Node root) {
        if (root == null) return;
        deletetree(root.left);
        deletetree(root.right);
        root.left = null;
        root.right = null;
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

            Tree tr = new Tree();
            ArrayList<Integer> A = tr.serialize(root);
            deletetree(root);
            root = null;

            Node getRoot = tr.deSerialize(A);
            printInorder(getRoot);
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*Complete the given function
Node is as follows:
class Tree{
    int data;
    Tree left,right;
    Tree(int d){
        data=d;
        left=right=null;
    }
}*/


class Tree {
    // Function to serialize a tree and return a list containing nodes of the tree.
    ArrayList<Integer> serialize(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        serializeHelper(root, result); // Call the helper function to perform serialization
        return result;
    }

    // Helper function for serialization using preorder traversal
    void serializeHelper(Node root, ArrayList<Integer> result) {
        if (root == null) {
            result.add(null); // Add null for representing empty nodes
            return;
        }
        result.add(root.data); // Add the data of the current node
        serializeHelper(root.left, result); // Recur for left subtree
        serializeHelper(root.right, result); // Recur for right subtree
    }

    // Function to deserialize a list and construct the tree.
    Node deSerialize(ArrayList<Integer> A) {
        // Use a pointer to keep track of the index in the list during deserialization
        Pointer pointer = new Pointer();
        pointer.index = 0;
        return deSerializeHelper(A, pointer); // Call the helper function to perform deserialization
    }

    // Helper function for deserialization using preorder traversal
    Node deSerializeHelper(ArrayList<Integer> A, Pointer pointer) {
        // If the current node is null, return null
        if (pointer.index >= A.size() || A.get(pointer.index) == null) {
            pointer.index++; // Increment index for next node
            return null;
        }

        // Create a new node with the current value
        Node root = new Node(A.get(pointer.index++));
        root.left = deSerializeHelper(A, pointer); // Recur for left subtree
        root.right = deSerializeHelper(A, pointer); // Recur for right subtree

        return root; // Return the constructed node
    }

    // Inner class to maintain index pointer during deserialization
    class Pointer {
        int index;
    }
}
