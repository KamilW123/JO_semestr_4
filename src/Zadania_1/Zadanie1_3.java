package Zadania_1;

import javax.swing.*;

public class Zadanie1_3 {

    public void uruchom() {
        String tekstWejsciowy;
        int n = 0;

        while (true) {
            tekstWejsciowy = JOptionPane.showInputDialog(
                    null,
                    "Podaj liczbę (n >= 1), do której zsumujemy liczby nieparzyste:",
                    "Sumowanie liczb nieparzystych",
                    JOptionPane.QUESTION_MESSAGE
            );

            // jak user da anuluj lub x
            if (tekstWejsciowy == null) {
                return; // Wracamy do Main
            }

            //jak user wprowadzi puste
            if (tekstWejsciowy.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Pole nie może być puste!", "Błąd", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            try {
                n = Integer.parseInt(tekstWejsciowy.trim());

                if (n < 1) {
                    // Logicznie rzecz biorąc, potrzebujemy liczby od 1 w górę
                    JOptionPane.showMessageDialog(null, "Liczba musi być większa lub równa 1!", "Błąd", JOptionPane.ERROR_MESSAGE);
                } else {
                    break; // Mamy poprawną liczbę - wychodzimy z pętli
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Wpisano nieprawidłowe znaki! Podaj liczbę całkowitą.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        }

        long suma = 0;

        for (int i = 1; i <= n; i += 2) {
            suma += i;
        }

        JOptionPane.showMessageDialog(
                null,
                "Suma liczb nieparzystych od 1 do " + n + " wynosi:\n" + suma,
                "Wynik dodawania",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
