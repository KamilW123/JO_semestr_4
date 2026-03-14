package Zadania_1;

import javax.swing.JOptionPane;

//przyjmuje wprowadzony tekst i zamienia go na wielkie litery
public class Zadanie1_1 {

    public static void uruchom(){
        String userInput = null;

        while(true) {
            userInput = JOptionPane.showInputDialog(
                    null,
                    "Wprowadź dowolny ciąg znaków: ",
                    "Twój tekst",
                    JOptionPane.QUESTION_MESSAGE
            );

            //kliknięcie anuluj lub x
            if (userInput == null) {
                JOptionPane.showMessageDialog(null, "Anulowano wprowadzanie. Program zostanie zakończony.", "Koniec", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
            //klikniecie OK ale tekst pusty lub same spacje
            else if(userInput.trim().equals("")){
                JOptionPane.showMessageDialog(
                        null,
                        "Wprowadzony tekst jest pusty, spróbuj ponownie",
                        "Błąd walidacji",
                        JOptionPane.WARNING_MESSAGE
                );
                continue;
            }
            //jak tekst ok to wychodzimy z pętli
            else{
                break;
            }
        }
        String upperCaseUserInput = userInput.toUpperCase();
        JOptionPane.showMessageDialog(
                null,
                "Wprowadzony tekst wielkimi literami:\n" + upperCaseUserInput,
                "Sukces!",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
