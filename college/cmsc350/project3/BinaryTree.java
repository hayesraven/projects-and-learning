/**
* Title: Project 3 - GUI 
* Name: Cameron Hayes
* Date: 30 APR 2022
* Description: BinaryTree Class
*/
package project3; 

import java.lang.Math;
import java.util.Stack;

public class BinaryTree {
    /* Class Attributes */
    private Node root;
    //private Node node;
    private int proper,
                height,
                nodes;
    private StringBuilder inorder = new StringBuilder();
    private Stack<Character> charStack = new Stack<Character>();


    /* Overloaded Constructor */
    public BinaryTree (String input) {
        /* You're going to want to take -> (A(G(j)(1))(z(5)))
        *  And make it:
        *         A
        *       /   \
        *      G     z
        *     / \   /
        *    j   1 5
        */
        // Note: the input should already be valid so no need to validate it here

        // iterate through string and add each character to the stack
        for (int i = (input.length() - 1); i >= 0; i--) {
            charStack.push(input.charAt(i));
        }
        // Get rid of first paren
        if ((Character.isLetterOrDigit(charStack.peek())) == false) {
            charStack.pop();
        }
        addNode(charStack);
    }
    /* Nested Classes */
    /* Node Class, used for binary tree building */
    class Node {
        // Attributes
        private char value;
        private Node left;
        private Node right;

        // Constructor
        Node(char value) {
            this.value = value;
            right = null;
            left = null;
        }
        // Accessors
        public char getValue() {
            return this.value;
        }
        public Node getLeft() {
            return this.left;
        }
        public Node getRight() {
            return this.right;
        }
        // Mutators
        public void setValue(char value) {
            this.value = value;
        }
        public void setLeft(Node left) {
            this.left = left;
        }
        public void setRight(Node right) {
            this.right = right;
        }
    }
    /* Methods */
    // (A(G(j)(1))(z(5)))
    // Recursively builds the tree by iterating through the input string
    private Node addNode(Node node, Stack<Character> stack) {
        // Make a node
        if (node == null) {
            node = new Node(stack.pop());
        }
        // Signals end to recursion
        if (stack.empty()) {
            return node;
        }
        // Adds data to left subtree first
        if ((stack.empty() == false) && stack.peek() == '(') {
            stack.pop();
            node.left = addNode(node.left, stack);
        }
        if ((stack.empty() == false) && stack.peek() == ')')  {
            stack.pop();
            return node;
        }
        // Adds data to right subtree next
        if ((stack.empty() == false) && stack.peek() == '(')  {
            stack.pop();
            node.right = addNode(node.right, stack);
        }
        if ((stack.empty() == false) && stack.peek() == ')')  {
            stack.pop();
            return node;
        }
        return node;
    }
    // Recursively calculate height of tree
    private int Height(Node node) {
        if (node == null) {
            return -1;
        }
        // uses max function to return the highest value between the left and right subtrees
        return (1 + Math.max(Height(node.left), Height(node.right)));
    }
    // Recursively calculate number of nodes in tree
    private int Nodes(Node node) {
        if (node == null) {
            return nodes;
        }
        else {
            nodes++;
            Nodes(node.left);
            Nodes(node.right);
        }
        return nodes;
    }
    // Recursively determine if an improper node exists
    private int Proper(Node node) {
        if ((node.left == null) && (node.right == null)) {
            return 0;
        }
        else if ((node.left == null) ^ (node.right == null)) {
            proper = 1;
        }
        else {
            Proper(node.left);
            Proper(node.right);
        }
        return proper;
    }
    // Recursively build the inorder output string
    private void InOrder(Node node) {
        if (node == null) {
            return;
        }
        // First go through the left child
        inorder.append("(");
        InOrder(node.left);
        // Add the data to the string
        inorder.append(" " + node.value + " ");
        // Now through the right child
        InOrder(node.right);
        inorder.append(")");
    }
    // Starts building the tree using recursion
    public void addNode(Stack<Character> stack) {
        root = addNode(root, stack);
    }
    // Checks to see if the binary tree is balanced
    // A binary tree is balanced if the absolute difference between the 
    // left and right subtrees is 1 or less.
    public boolean IsBalanced() {
        if ((Math.abs((Height(root.left)) - (Height(root.right)))) <= 1) {
            return true;
        }
        return false;
    }
    // Checks to see if the binary tree is full
    // A binary tree is full is the number of nodes it contains
    // is equal to 1 less 2 raised to the power of height. 
    public boolean IsFull() {
        height = Height();
        // Makes sure the nodes value isn't made twice
        if (nodes == 0) {
            Nodes(root);
        }
        if (nodes != (Math.pow(2, height) - 1)) {
            return false;
        }
        return true;
    }
    // Checks to see if the binary tree is proper
    // A binary tree is proper if each node has either
    // two or zero children.
    public boolean IsProper() {
        if (Proper(root) != 0) {
            return false;
        }
        return true;
    }
    // Calculates height of binary tree, starts recursion
    public int Height() {
        return Height(root);
    }
    // Calculates number of nodes in binary tree
    public int Nodes() {
        if (nodes > 0) {
            return nodes;
        }
        return Nodes(root);
    }
    // Returns inorder traversal of binary tree
    public String toString() {
        /* This -> (A(G(j)(1))(z(5)))
        *  
        *         A
        *       /   \
        *      G     z
        *     / \   /
        *    j   1 5
        */
        // Needs to display as -> ((( j ) G ( 1 )) A (( 5 ) z ))
        if (inorder.isEmpty() == false) {
            return inorder.toString();
        }
        InOrder(root);
		return inorder.toString();
    }
}
