package Zadania_1;

import javax.swing.*;
import java.math.BigInteger;

public class Zadanie1_2 {

    public void uruchom() {
        String userInput;
        int n = 0; //liczba całkowita usera

        while (true) {
            userInput = JOptionPane.showInputDialog(
                    null,
                    "Podaj liczbę całkowitą (n >= 0), aby obliczyć silnię:",
                    "Kalkulator Silni",
                    JOptionPane.QUESTION_MESSAGE
            );
            //jak user kliknie anuluj
            if (userInput == null) {
                System.exit(0);
            }

            //jak tekst pusty
            if (userInput.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Pole nie może być puste!", "Błąd", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            try {
                n = Integer.parseInt(userInput.trim());

                if (n < 0) {
                    JOptionPane.showMessageDialog(null, "Liczba nie może być ujemna!", "Błąd", JOptionPane.ERROR_MESSAGE);
                } else {
                    break;
                }

            } catch (NumberFormatException e) {
                // Jeśli parsowanie się nie uda to error message
                JOptionPane.showMessageDialog(null, "Wpisano nieprawidłowe znaki! Podaj liczbę całkowitą.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        }

        BigInteger silnia = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            silnia = silnia.multiply(BigInteger.valueOf(i));
        }

        JOptionPane.showMessageDialog(
                null,
                "Silnia z liczby " + n + " wynosi:\n\n" + silnia.toString(),
                "Wynik",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
