//{ Driver Code Starts
// Contributed by Sudarshan Sharma
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
            Solution ob = new Solution();
            System.out.println(ob.treePathsSum(root));
            // System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/*Complete the function below.
Node is as follows:
class Tree
{
      int data;
      Tree left,right;
      Tree(int d){
          data=d;
          left=null;
          right=null;
}
}*/


class Solution {
    private static int gsum = 0; // Global sum to store the sum of all root-to-leaf numbers

    // Main function to calculate the sum of all root-to-leaf numbers
    public static int treePathsSum(Node root) {
        gsum = 0; // Reset global sum
        ArrayList<Integer> path = new ArrayList<>(); // List to store path nodes
        findPaths(root, path);
        return gsum;
    }

    // Helper function to find all paths from root to leaf
    public static void findPaths(Node root, ArrayList<Integer> path) {
        // Base case: if the node is null, return
        if (root == null) {
            return;
        }

        // Add the current node's data to the path list
        path.add(root.data);

        // If it's a leaf node, calculate the path number and add to global sum
        if (root.left == null && root.right == null) {
            gsum += calculatePathSum(path);
        } else {
            // Recur for left and right children
            findPaths(root.left, path);
            findPaths(root.right, path);
        }

        // Backtrack: remove the last element after visiting left and right children
        path.remove(path.size() - 1);
    }

    // Function to calculate the number represented by the current path
    public static int calculatePathSum(ArrayList<Integer> path) {
        int pathSum = 0;
        for (int value : path) {
            pathSum = pathSum * 10 + value; // Shift left and add the current node's value
        }
        return pathSum;
    }
}
