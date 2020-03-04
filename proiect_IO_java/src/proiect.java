import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.filechooser.*;


class proiect extends JFrame implements ActionListener {

    static JLabel l;

    static JTextField tf;
    static JButton b;
    static JLabel l2;


    // a default constructor
    proiect() {
    }


    public static void main(String args[]) {

        JTextArea ta = new JTextArea(20,30);
        // Now create a new TextAreaOutputStream to write to our JTextArea control and wrap a
        // PrintStream around it to support the println/printf methods.
        PrintStream out = new PrintStream( new TextAreaOutputStream( ta ) );

        // redirect standard output stream to the TextAreaOutputStream
        System.setOut( out );

        // redirect standard error stream to the TextAreaOutputStream
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
        proiect p1 = new proiect();

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
        proiect pr = new proiect();

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







    public void actionPerformed(ActionEvent evt) {
        // if the user presses the save button show the save dialog 
        String com = evt.getActionCommand();

        if (com.equals("Alege")) {
            // create an object of JFileChooser class 
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            // invoke the showsSaveDialog function to show the save dialog 
            int r = j.showSaveDialog(null);

            // if the user selects a file 
            if (r == JFileChooser.APPROVE_OPTION) {
                // set the label to the path of the selected file 
                l.setText(j.getSelectedFile().getAbsolutePath());
            }
            // if the user cancelled the operation 
            else
                l.setText("Utilizatorul a anulat operatiunea");
        }

        String s = evt.getActionCommand();
        if (s.equals("OK")) {
            // set the text of the label to the text of the field
            l2.setText(tf.getText());

            // set the text of field to blank
            tf.setText(" ");
        }


    }



    public static boolean compareInFile (String inputWord){

        String word = l2.getText();

        File file = new File(l.getText());
        try {
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                word = input.next();
                if (inputWord.equals(word)) {
                    return true;
                }
            }

        } catch (Exception error) {
        }
        return false;
    }


}
