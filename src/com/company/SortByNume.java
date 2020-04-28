package com.company;

import java.util.Comparator;

public class SortByNume implements Comparator<Produs> {
    @Override
    public int compare(Produs o1, Produs o2) {
        return o1.getNume().compareTo(o2.getNume());
    }
}
