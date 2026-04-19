package Zadania_2;

public class RownanieKwadratowe {
    private double a;
    private double b;
    private double c;

    public void setWspolczynniki(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double obliczY(double x){
        return this.a * x * x + this.b * x + this.c;
    }

    public int liczbaPierwiastkow(){
        double d = this.b * this.b - 4 * this.a * this.c;

        if(d > 0){
            return 2;
        }
        else if(d == 0){
            return 1;
        }
        else{
            return 0;
        }
    }
}
