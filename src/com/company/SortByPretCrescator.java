package com.company;

import java.util.Comparator;

public class SortByPretCrescator implements Comparator<Produs> {
    @Override
    public int compare(Produs o1, Produs o2) {
        return (int) (o1.getPretDeVanzare() - o2.getPretDeVanzare());
    }
}