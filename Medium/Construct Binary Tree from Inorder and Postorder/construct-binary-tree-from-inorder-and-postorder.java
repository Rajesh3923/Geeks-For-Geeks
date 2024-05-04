//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG {
    // Function to return a tree created from postorder and inorder traversals.
    Node buildTree(int in[], int post[], int n) {
        return helper(in, post, 0, n - 1, 0, n - 1);
    }

    static Node helper(int in[], int post[], int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        Node root = new Node(post[postEnd]);

        int inIndex = inStart;
        while (in[inIndex] != root.data)
            inIndex++;

        int leftSubtreeSize = inIndex - inStart;

        root.left = helper(in, post, inStart, inIndex - 1, postStart, postStart + leftSubtreeSize - 1);
        root.right = helper(in, post, inIndex + 1, inEnd, postStart + leftSubtreeSize, postEnd - 1);

        return root;
    }
}

















