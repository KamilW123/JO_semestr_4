package Zadania_6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Zamieniacz extends Thread {
    JTextArea okno;
    volatile boolean zakonczyc;

    public Zamieniacz(JTextArea comp) {
        okno = comp;
        zakonczyc = false;
    }

    public void run() {
        while (!zakonczyc) {
            try {
                String tekst = okno.getText();
                int indeks = tekst.indexOf("{");
                if (indeks >= 0) {
                    okno.replaceRange("begin", indeks, indeks + 1);
                    okno.setCaretPosition(tekst.length() + 4);
                } else {
                    indeks = tekst.indexOf("}");
                    if (indeks >= 0) {
                        okno.replaceRange("end", indeks, indeks + 1);
                        okno.setCaretPosition(tekst.length() + 2);
                    }
                }
                sleep(2000);
            } catch (Exception e) {}
        }
    }
}


class Cenzor extends Thread {
    JTextArea okno;
    volatile boolean zakonczyc;

    public Cenzor(JTextArea comp) {
        okno = comp;
        zakonczyc = false;
    }

    public void run() {

        while (!zakonczyc) {
            try {

                sleep(10000);


                String tekst = okno.getText();

                if (tekst.toLowerCase().contains("cholera")) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Wykryto niecenzuralne słowo: cholera!",
                            "Ostrzeżenie Cenzora",
                            JOptionPane.WARNING_MESSAGE
                    );
                }
            } catch (Exception e) {

            }
        }
    }
}


public class Zadanie6_1 extends JFrame {

    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;

    private Zamieniacz watek;
    private Cenzor watekCenzora;

    public Zadanie6_1() {
        initComponents();
        setSize(350, 250);
        setTitle("Edytor z Wątkami");


        watek = new Zamieniacz(jTextArea1);
        watek.start();


        watekCenzora = new Cenzor(jTextArea1);
        watekCenzora.start();
    }

    private void initComponents() {
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTextArea1.setPreferredSize(new Dimension(300, 200));
        jScrollPane1.setViewportView(jTextArea1);
        getContentPane().add(jScrollPane1, BorderLayout.CENTER);
        pack();
    }

    private void formWindowClosing(WindowEvent evt) {

        watek.zakonczyc = true;
        watek = null;

        watekCenzora.zakonczyc = true;
        watekCenzora = null;
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Zadanie6_1().setVisible(true);
            }
        });
    }
}