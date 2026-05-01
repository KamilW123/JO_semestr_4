package Zadania_3;


//definicja klas wyjątkow
class Przepelnienie extends Exception {
    public Przepelnienie() {
        super();
    }
}

class Niedomiar extends Exception {
    public Niedomiar() {
        super();
    }
}

class Kolejka {
    static final int N = 5;
    private Object[] tab;
    private int pocz, zaost, lbel;

    public Kolejka() {
        pocz = 0;
        zaost = 0;
        lbel = 0;
        tab = new Object[N];
    }

    void doKolejki(Object el) throws Przepelnienie {
        if (lbel == N) {
            throw new Przepelnienie();
        }
        tab[zaost] = el;
        zaost = (zaost + 1) % N;
        ++lbel;
    }

    Object zKolejki() throws Niedomiar {
        if (lbel == 0) {
            throw new Niedomiar();
        }
        int ind = pocz;
        pocz = (pocz + 1) % N;
        --lbel;
        return tab[ind];
    }
}

public class Zadanie3_1 {
    public static void main(String[] args) {
        Kolejka k = new Kolejka();
        try {
            k.doKolejki(Integer.valueOf(7));                //new Integer w nowszej wersji javy wyrzuca błąd stąd value of
            k.doKolejki(new String("Ala ma kota"));
            k.doKolejki(Double.valueOf(3.14));              //new Double w nowszej wersji javy wyrzuca błąd stąd value of
//            k.doKolejki(Double.valueOf(3.14));
//            k.doKolejki(Double.valueOf(3.14));                //test przepełnienia
//            k.doKolejki(Double.valueOf(3.14));
            for (int i = 1; i <= 4; ++i) {
                System.out.println((k.zKolejki()).toString());
            }
        }
        catch (Przepelnienie e) {
            System.out.println("Przepełniona kolejka!");
        }
        catch (Niedomiar e) {
            System.out.println("Pusta kolejka!");
        }
    }
}
