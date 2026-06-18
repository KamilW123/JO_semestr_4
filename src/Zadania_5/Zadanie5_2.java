package Zadania_5;

import java.util.*;

class WspolrzednaMap {
    private int x, y;


    //inna nazwa bo koliduje z zadaniem 5_1
    public WspolrzednaMap(int _x, int _y) {
        x = _x;
        y = _y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;


        if (obj == null || this.getClass() != obj.getClass()) return false;


        WspolrzednaMap inna = (WspolrzednaMap) obj;


        if (this.x == inna.x && this.y == inna.y) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }
}

public class Zadanie5_2 {
    public static void main(String[] args) {
        HashMap mapa = new HashMap();
        mapa.put(new WspolrzednaMap(2, 3), new String("czerwony"));
        mapa.put(new WspolrzednaMap(-3, 0), new String("czarny"));
        mapa.put(new WspolrzednaMap(-1, 2), new String("czerwony"));
        mapa.put(new WspolrzednaMap(2, -1), new String("czarny"));

        WspolrzednaMap w = new WspolrzednaMap(-1, 2);
        System.out.println("Punkt " + w.toString()
                + " ma kolor " + mapa.get(w));
    }
}