/**
* Title: Project 1 - Main
* Name: Cameron Hayes
* Date: 23 Mar 2022
* Description: Main class, creates gui for execution
*/
package project1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI implements ActionListener {
    /* Variables */
    private JFrame frame;
    private JButton buttonConvPreToPost, buttonConvPostToPre;
    private JTextField textInput;
    private JLabel lblInput, lblResult;
    private JPanel panel;
    private String validInputs = "0123456789/*-+ ";
    Conversions conversion = new Conversions();

    /* Sets up the GUI */
    public GUI() {

        // Set up the frame
        frame = new JFrame();

        // Set up the text field
        textInput = new JTextField(20);

        // Set up the labels
        lblInput = new JLabel("Enter Expression: ");
        lblResult = new JLabel("Results: ");

        // Set up the buttons
        // This button converts prefix expressions to postfix form
        buttonConvPreToPost = new JButton("Prefix to Postfix");
        buttonConvPreToPost.addActionListener(new ActionListener() {
            // Validates input before calling the conversion methods, throws exception upon invalid input
            public void actionPerformed(ActionEvent e){
                try {
                    validateInput(textInput.getText());
                    lblResult.setText("Results: " + conversion.ConvPreToPost(textInput.getText()));
                }
                catch (SyntaxError f) {
                    JOptionPane.showMessageDialog(null, f.toString());
                }
            }
        });

        // This button converts postfix expressions to prefix form
        buttonConvPostToPre = new JButton("Postfix to Prefix");
        buttonConvPostToPre.addActionListener(new ActionListener() {
            // Validates input before calling the conversion methods, throws exception upon invalid input
            public void actionPerformed(ActionEvent e){
                try {
                    validateInput(textInput.getText());
                    lblResult.setText("Results: " + conversion.ConvPostToPre(textInput.getText()));
                }
                catch (SyntaxError f) {
                    JOptionPane.showMessageDialog(null, f.toString());
                }
            }
        });        
        
        // Set up the panel
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,5,5,5);
        
        //Add the components
        c.gridx = 0;
        c.gridy = 0;
        panel.add(lblInput,c);

        c.gridx = 1;
        c.gridy = 0;
        panel.add(textInput,c);

        c.gridx = -1;
        c.gridy = 2;
        panel.add(buttonConvPreToPost,c);

        c.gridx = 1;
        c.gridy = 2;
        panel.add(buttonConvPostToPre,c);

        c.gridx = 0;
        c.gridy = 4;
        panel.add(lblResult,c);

        // Build out the frame
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Expression Converter");
        frame.pack();
        frame.setSize(450,150);
        frame.setVisible(true);
    }

    /* Main execution */
    public static void main(String[] args) {
        new GUI();
    }

    /* Validates input to throw exception if needed */
    public void validateInput(String string) throws SyntaxError {     
        /* Variables */
        int i;   
        /* Checks if the string is a operator or not */
        for (i = 0; i < string.length(); i++) {
            if (validInputs.contains(Character.toString(string.charAt(i))) == false) {
                throw new SyntaxError(string, validInputs);
            }
        }
    }

    /* Default action listener event */
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "ERROR: Please select one of the above options.");
    }    
}
