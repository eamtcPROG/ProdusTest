package com.company;
import java.util.Comparator;

public class SortByPretDescrescator implements Comparator<Produs> {
    public int compare(Produs o1, Produs o2) {
        return (int) (o2.getPretDeVanzare() - o1.getPretDeVanzare());
    }
}
