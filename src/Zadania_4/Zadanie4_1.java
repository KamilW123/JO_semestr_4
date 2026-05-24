package Zadania_4;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Zadanie4_1 {

    public void uruchom(){

        //tekst do zapisania
        JTextArea textArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);

        int result = JOptionPane.showConfirmDialog(
                null,
                scrollPane,
                "Wpisz tekst do zapisania",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result != JOptionPane.OK_OPTION) {
            return;
        }
        String textToSave = textArea.getText();

        //pobranie kodowania
        String[] options = {"UTF-8", "ISO-8859-2", "windows-1250"};
        String selectedOption = (String) JOptionPane.showInputDialog(
                null,
                "Wybierz standard kodowania znaków:",
                "Wybór kodowania",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        if (selectedOption == null) {
            return;
        }

        // przerobienie standardów kodowania na łańcuchy znane przez jave
        String encoding = "";
        if (selectedOption.equals("UTF-8")) {
            encoding = "UTF8";
        } else if (selectedOption.equals("ISO-8859-2")) {
            encoding = "ISO8859_2";
        } else if (selectedOption.equals("windows-1250")) {
            encoding = "Cp1250";
        }

        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Wybierz miejsce do zapisu pliku");

        int saveResult = chooser.showSaveDialog(null);
        if (saveResult != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File selectedFile = chooser.getSelectedFile();

        try{
            FileOutputStream fos = new FileOutputStream(selectedFile);

            OutputStreamWriter osw = new OutputStreamWriter(fos, encoding);
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write(textToSave);


            //zamykanie zaczynamy od zewnatrz do wewnatrz, inaczej wysypie program
            bw.close();
            osw.close();
            fos.close();
            JOptionPane.showMessageDialog(null, "Plik zapisany pomyślnie!", "Sukces", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Wystąpił błąd podczas zapisu: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

}
