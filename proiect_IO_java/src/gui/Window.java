package gui;

import engine.Searcher;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class Window extends JFrame {
    JLabel file_label, word_label, find_label;
    JTextField word_field;
    JButton file_button, submit_button;

    String find_str;
    Boolean valid = true;
    String file_path = "";

    public Window(){
        setSize(new Dimension(400, 400));
        setLocation(new Point(200, 200));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setTitle("Aplicatie Java");

        JPanel content = (JPanel) getContentPane();
        content.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        find_str = "Ultima linie:";

        file_label = new JLabel("Nu a fost selectat nici un fisier");
        word_label = new JLabel("Introduceti cuvantul");
        find_label = new JLabel(find_str);

        word_field = new JTextField();
        word_field.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                textValidation();
            }
        });

        file_button = new JButton("Alege fisier...");
        file_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectFile();
            }
        });

        submit_button = new JButton("Incepe cautare");
        submit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startSearch();
            }
        });

        gbc.ipadx = 10;
        gbc.ipady = 10;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        content.add(file_button, gbc);
        content.add(file_label, gbc);

        gbc.gridy = 2;
        content.add(word_label, gbc);
        content.add(word_field, gbc);

        gbc.gridy = 3;
        gbc.gridwidth = 2;
        content.add(submit_button, gbc);

        gbc.gridy = 4;
        gbc.gridwidth = 2;
        content.add(find_label, gbc);
    }

    private void textValidation(){
        String cuvant = word_field.getText();
        valid = true;

        if(cuvant.length() == 0)
            return;

        if(cuvant.matches(".*\\s.*"))
            valid = false;

        if(!valid)
            find_label.setText("Cuvant invalid");
    }

    private void startSearch(){
        String word;

        if(!valid){
            find_label.setText("Cuvant invalid");
            return;
        }
        else
            word = word_field.getText();

        try{
            Searcher searcher = new Searcher(file_path, word);

            find_label.setText( "Ultima linie: "+searcher.lastContaining() );
        }catch (Exception ex){
            find_label.setText("Eroare de procesare fisier");
        }
    }

    private void selectFile(){
        JFileChooser jfc = new JFileChooser( new File("").getAbsolutePath() );
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fisiere text", "txt");
        jfc.setFileFilter(filter);

        int result = jfc.showOpenDialog(this);
        if( result == JFileChooser.APPROVE_OPTION ) {
            File chosen = jfc.getSelectedFile();

            int ext = chosen.getName().lastIndexOf(".");
            if( ext < 0 ){
                file_label.setText("Fisier invalid");
                return;
            }

            if( !chosen.getName().substring( ext+1 ).equals("txt") ) {
                file_label.setText("Fisier invalid");
                return;
            }

            file_path = chosen.getPath();
            file_label.setText( chosen.getName() );
        }
    }
}
