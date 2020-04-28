package com.company;

import java.util.Comparator;

public class SortByDataDeExpirare implements Comparator<Produs> {
    @Override
    public int compare(Produs o1, Produs o2) {
        return o2.getDataDeExpirare().compareTo(o1.getDataDeExpirare());
    }
}
