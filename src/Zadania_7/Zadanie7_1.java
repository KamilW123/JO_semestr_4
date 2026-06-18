package Zadania_7;

import java.net.*;
import java.io.*;

public class Zadanie7_1 {
    public static void main(String[] args) {
        String nazwaHosta = "time-a.nist.gov";

        try {

            Socket gniazdo = new Socket(nazwaHosta, 37);


            InputStream strumien = gniazdo.getInputStream();


            int bajt1 = strumien.read();
            int bajt2 = strumien.read();
            int bajt3 = strumien.read();
            int bajt4 = strumien.read();


            if (bajt1 == -1 || bajt2 == -1 || bajt3 == -1 || bajt4 == -1) {
                System.out.println("Błąd: za mało danych po stronie serwera");
                return;
            }

            long sekundy = ((long) bajt1 << 24) | ((long) bajt2 << 16) | ((long) bajt3 << 8) | (long) bajt4;

            System.out.println("Otrzymano bajty od serwera: " + bajt1 + ", " + bajt2 + ", " + bajt3 + ", " + bajt4);
            System.out.println("Liczba sekund od 1 stycznia 1900 r.: " + sekundy);


            gniazdo.close();

        } catch (UnknownHostException e) {
            System.err.println("Nie można odnaleźć serwera: " + e);
        } catch (IOException e) {
            System.err.println("Błąd połączenia: " + e);
        }
    }
}