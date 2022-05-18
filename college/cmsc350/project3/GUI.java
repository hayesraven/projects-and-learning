/**
* Title: Project 3 - GUI 
* Name: Cameron Hayes
* Date: 30 APR 2022
* Description: Main execution class for Binary Tree program
*/
package project3; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Creates the GUI and sets up everything for main
public class GUI {
    /* Variables */
    private JFrame frame;           // JFrame to add stuff to
    private JButton btnMakeTree,    // Button that creates the binary tree
                    btnIsBalanced,  // Button that calls IsBalanced()
                    btnIsFull,      // Button that calls IsFull()
                    btnIsProper,    // Button that calls IsProper()
                    btnHeight,      // Button that calls Height()
                    btnNodes,       // Button that calls Nodes()
                    btnInOrder;     // Button that calls InOrder()
    private JTextField txtInput,    // User inputs stuff into this text field
                        txtOutput;  // Program outputs stuff into this text field
    private JLabel lblInput,        // Label for txtInput
                    lblOutput;      // Label for txtOutput
    private JPanel panel;           // JPanel, gets added to frame
    private String input,           // Used to capture user input into a string
                    noBinary = "Please make a binary tree first!",  // Error string
                    tmpStr;         // Temp string for whatever you need
    private boolean tmpBool = false;    // Temp bool for whatever you need
    private int tmpInt = 0;         // Temp Int for whatever you need
    private BinaryTree binaryTree = null;   // BinaryTree object

    /* Sets up the GUI */
    public GUI() {

        // Set up the frame
        frame = new JFrame();

        // Set up the text field
        txtInput = new JTextField(25);
        txtOutput = new JTextField(25);

        // Set up the labels
        lblInput = new JLabel("Enter Tree: ");
        lblOutput = new JLabel("Output: ");

        // Set up the btns
        btnMakeTree = new JButton("Make Tree");
        btnIsBalanced = new JButton("Is Balanced?");
        btnIsFull = new JButton("Is Full?");
        btnIsProper = new JButton("Is Proper?");
        btnHeight = new JButton("Height");
        btnNodes = new JButton("Nodes");
        btnInOrder = new JButton("In Order");

        // Button - Creates the binary tree from input within the text field
        btnMakeTree.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    txtOutput.setText("");
                    input = txtInput.getText();
                    validateInput(input);
                    binaryTree = new BinaryTree(input);
                    if (binaryTree != null) {
                        JOptionPane.showMessageDialog(null, "The binary tree has been built!");
                    }
                    // Realistically, this should never execute, because the catch statement should grab all errors
                    else {
                        JOptionPane.showMessageDialog(null, "Something went wrong; please try again");
                    }
                }
                catch (InvalidTreeSyntax f) {
                    JOptionPane.showMessageDialog(null, f.toString());
                }
            }
        });

        // Button - Checks the last binary tree for balance
        btnIsBalanced.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (binaryTree != null) {
                    txtOutput.setText("");
                    tmpBool = binaryTree.IsBalanced();
                    txtOutput.setText("Binary tree is balanced: " + tmpBool);
                }
                else {
                    JOptionPane.showMessageDialog(null, noBinary);
                }
            }
        });

        // Button - Checks the last binary tree to check if its full
        btnIsFull.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (binaryTree != null) {
                    txtOutput.setText("");
                    tmpBool = binaryTree.IsFull();
                    txtOutput.setText("Binary tree is full: " + tmpBool);
                }
                else {
                    JOptionPane.showMessageDialog(null, noBinary);
                }
            }
        });
        
        // Button - Checks the last binary tree to see if it is considered proper
        btnIsProper.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (binaryTree != null) {
                    txtOutput.setText("");
                    tmpBool = binaryTree.IsProper();
                    txtOutput.setText("Binary tree is proper: " + tmpBool);
                }
                else {
                    JOptionPane.showMessageDialog(null, noBinary);
                }
            }
        });

        // Button - Returns the height of the last binary tree
        btnHeight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (binaryTree != null) {
                    txtOutput.setText("");
                    tmpInt = binaryTree.Height();
                    txtOutput.setText("Height of binary tree: " + tmpInt);
                }
                else {
                    JOptionPane.showMessageDialog(null, noBinary);
                }
            }
        });

        // Button - Returns the number of nodes of the last binary tree
        btnNodes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (binaryTree != null) {
                    txtOutput.setText("");
                    tmpInt = binaryTree.Nodes();
                    txtOutput.setText("Number of nodes within binary tree: " + tmpInt);
                }
                else {
                    JOptionPane.showMessageDialog(null, noBinary);
                }
            }
        });

        // Button - Returns an inorder traversal of the last binary tree
        btnInOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (binaryTree != null) {
                    txtOutput.setText("");
                    tmpStr = binaryTree.toString();
                    txtOutput.setText(tmpStr);
                }
                else {
                    JOptionPane.showMessageDialog(null, noBinary);
                }
            }
        });

        // Set up the panel
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,0,5,0);
        c.gridwidth = 1;
        c.gridheight = 1;
        
        //Add the components
        c.anchor = GridBagConstraints.LINE_END;
        c.gridx = 1;
        c.gridy = 0;
        panel.add(lblInput,c);

        c.gridy = 4;
        panel.add(lblOutput,c);

        c.insets = new Insets(5,5,5,1);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 2;
        panel.add(btnMakeTree,c);

        c.insets = new Insets(5,1,5,1);
        c.gridx = 1;
        panel.add(btnIsBalanced,c);

        c.gridx = 2;
        panel.add(btnIsFull,c);

        c.gridx = 3;
        panel.add(btnIsProper,c);

        c.gridx = 4;
        panel.add(btnHeight,c);

        c.gridx = 5;
        panel.add(btnNodes,c);

        c.insets = new Insets(5,1,5,5);
        c.gridx = 6;
        panel.add(btnInOrder,c);

        c.insets = new Insets(5,0,5,0);
        c.weightx = 1.0;
        c.gridwidth = 4;
        c.gridx = 2;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        panel.add(txtInput,c);

        c.gridy = 4;
        panel.add(txtOutput,c);

        // Build out the frame
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Binary Tree Magic");
        frame.pack();
        frame.setSize(650,150);
        frame.setVisible(true);
    }
    // Main execution
    public static void main(String[] args) {
        new GUI();
    }

    // Validates input, throws exceptions if issues arise
    private void validateInput(String input) throws InvalidTreeSyntax {
        // Variables
        int parentheses = 0;
        int values = 0;
        char tmpChar;

        // Check for null/blank/empty input.
        if (input == null || input.isBlank() || input.isEmpty()) {
            throw new InvalidTreeSyntax(input);
        }
        
        /** Iterate through input, if character at i is not a:
        *      - letter
        *      - number
        *      - '('
        *      - ')'
        * throw an error */
        for (int i = 0; i < input.length(); i++) {
            tmpChar = input.charAt(i);
            if (Character.isLetterOrDigit(tmpChar) == false) {
                if ((tmpChar != '(') && (tmpChar != ')')) {
                    throw new InvalidTreeSyntax(tmpChar);
                }
            }
            // Used to check for values added
            else {
                values++;
            }
            // Used to check for proper number of parentheses
            if (tmpChar == '(') {
                parentheses++;
            }
            else if (tmpChar == ')') {
                parentheses--;
            }
        }
        // If parentheses is anything but 0, it means there was at least
        // one extra parenthese add to the string
        if (parentheses != 0) {
            throw new InvalidTreeSyntax(parentheses);
        }
        // Thrown if no values were found
        if (values == 0) {
            throw new InvalidTreeSyntax(values, 'x');
        }
    }
}
