package aplicatie;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Scanner;

import static aplicatie.GUI.*;


public class Util {

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
