package Zadania_5;

import java.util.*;

class Wspolrzedna implements Comparable<Wspolrzedna> {
    private int x, y;

    public Wspolrzedna(int _x, int _y) {
        x = _x;
        y = _y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    @Override
    public int compareTo(Wspolrzedna inna) {
        if (this.x < inna.x) {
            return -1;
        } else if (this.x > inna.x) {
            return 1;
        }

        if (this.y < inna.y) {
            return -1;
        } else if (this.y > inna.y) {
            return 1;
        }

        // Jeśli x i y są równe
        return 0;
    }
}

public class Zadanie5_1 {
    private static void wypiszElementy(TreeSet<Wspolrzedna> zbior) {
        Iterator<Wspolrzedna> it = zbior.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    public static void main(String[] args) {
        TreeSet<Wspolrzedna> zbior = new TreeSet<>();
        zbior.add(new Wspolrzedna(2, 3));
        zbior.add(new Wspolrzedna(-3, 0));
        zbior.add(new Wspolrzedna(-1, 2));
        zbior.add(new Wspolrzedna(-1, 2)); // Zbiór odrzuci duplikat!
        zbior.add(new Wspolrzedna(-3, -2));

        wypiszElementy(zbior);
    }
}