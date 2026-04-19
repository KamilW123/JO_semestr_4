package Zadania_2;

public class Rational {
    private int licznik;
    private int mianownik;

    public Rational(int licznik, int mianownik) {
        if (mianownik == 0) {
            throw new IllegalArgumentException("mianownik nie może być równy 0");
        }
        if(mianownik < 0){                  //dla wyglądu oraz poprawności działania compareTo
            mianownik = -mianownik;
            licznik = -licznik;
        }
        else{
            this.licznik = licznik;
            this.mianownik = mianownik;
        }
    }
    public Rational add(Rational arg) {
        return new Rational((this.licznik*arg.mianownik)+(arg.licznik *this.mianownik), this.mianownik*arg.mianownik);
    }
    public Rational mul(Rational arg) {
        return new Rational(this.licznik*arg.licznik, this.mianownik*arg.mianownik);
    }
    public Rational sub(Rational arg) {
        return new Rational((this.licznik*arg.mianownik)-(arg.licznik *this.mianownik), this.mianownik*arg.mianownik);
    }
    public Rational div(Rational arg) {
        return new Rational(this.licznik*arg.mianownik, this.mianownik*arg.licznik);
    }
    public boolean equals(Rational arg){
        return this.licznik * arg.mianownik == this.mianownik * arg.licznik;
    }
    public int compareTo(Rational arg) {
        if(this.licznik * arg.mianownik == this.mianownik * arg.licznik){
            return 0;
        }
        else if(this.licznik * arg.mianownik > this.mianownik * arg.licznik){
            return 1;
        }
        else{
            return -1;
        }
    }
    public String toString() {
        return this.licznik + "/" + this.mianownik;
    }
}

