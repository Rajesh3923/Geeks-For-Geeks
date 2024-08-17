//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

class SortedStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0) s.push(sc.nextInt());
            GfG g = new GfG();
            Stack<Integer> a = g.sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends




/*Complete the function below*/
class GfG {
     public Stack<Integer> sort(Stack<Integer> s) {
        if (!s.isEmpty()) {
            // Pop the top element
            int temp = s.pop();
            
            // Recursively sort the remaining stack
            sort(s);
            
            // Insert the popped element in sorted order
            sortedInsert(s, temp);
        }
        return s;// here if we wont write this return it still works 
    }

    // Function to insert the element in sorted order
    private void sortedInsert(Stack<Integer> s, int element) {
        // Base case: if stack is empty or top element is smaller, push the element
        if (s.isEmpty() || element > s.peek()) {
            s.push(element);
            return;
        }
        
        // Otherwise, pop the top element and recursively insert
        int temp = s.pop();
        sortedInsert(s, element);
        
        // Push the popped element back
        s.push(temp);
    }

}