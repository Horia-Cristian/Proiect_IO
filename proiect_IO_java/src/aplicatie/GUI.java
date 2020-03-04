package aplicatie;

import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.util.Scanner;




class GUI extends JFrame implements ActionListener {

    static JLabel l;
    static JLabel l2;
    static JTextField tf;
    static JButton b;


    // a default constructor
    GUI() {
    }


    public static void main(String args[]) {

        JTextArea ta = new JTextArea(20,30);
        // Now create a new aplicatie.TextAreaOutputStream to write to our JTextArea control and wrap a
        // PrintStream around it to support the println/printf methods.
        PrintStream out = new PrintStream( new TextAreaOutputStream( ta ) );

        // redirect standard output stream to the aplicatie.TextAreaOutputStream
        System.setOut( out );

        // redirect standard error stream to the aplicatie.TextAreaOutputStream
        System.setErr( out );

        System.out.println("Ultima linie din intrare ce contine cuvantul dat este:\n");

        // frame to contains GUI elements 
        JFrame f = new JFrame("Alege fisier");

        // set the size of the frame 
        f.setSize(400, 400);

        // set the frame's visibility 
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // button to open save dialog 
        JButton button1 = new JButton("Alege");

        tf = new JTextField(16);

        // make an object of the class filechooser 
        GUI p1 = new GUI();

        // add action listener to the button to capture user 
        // response on buttons 
        button1.addActionListener(p1);

        // make a panel to add the buttons and labels 
        JPanel p = new JPanel();

        // add buttons to the frame 
        p.add(button1);

        // set the label to its initial value 
        l = new JLabel("Nu a fost selectat nici un fisier");



        // create a label to display text
        l2 = new JLabel("Introduceti cuvantul");

        // create a new button
        b = new JButton("OK");

        // create a object of the text class
        GUI pr = new GUI();

        // addActionListener to button
        b.addActionListener(pr);

        // create a object of JTextField with 16 columns
        tf = new JTextField(16);




        // add panel to the frame 
        p.add(l);
        p.add(tf);
        p.add(b);
        p.add(l2);
        p.add(ta);

        f.add(p);

        f.show();

    }

}
