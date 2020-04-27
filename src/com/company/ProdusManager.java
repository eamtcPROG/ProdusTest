package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ProdusManager {
    public void add(ArrayList produsList, String nume, double pretDeAchizitie, double pretDeVanzare, LocalDate data,String descriere) {
       Produs produs = new Produs();
       produs.setNume(nume);
       produs.setPretDeAchizitie(pretDeAchizitie);
       produs.setPretDeVanzare(pretDeVanzare);
       produs.setDataDeExpirare(data);
       produs.setDescrierea(descriere);
        produsList.add(produs);
    }
    public void view(ArrayList produsList) {
        System.out.println("| Nr |      Nume      |      pretDeAchizitie      |      pretDeVanzare      |      data      |      descriere      |");
        System.out.println("|---------------------------------------------------------------------------------------------------|");
        for (int i = 0;i< produsList.size();i++){
            Produs produs = (Produs) produsList.get(i);
            String nume = produs.getNume();
            double pretDeAchizitie = produs.getPretDeAchizitie();
            double pretDeVanzare = produs.getPretDeVanzare();
            LocalDate data = produs.getDataDeExpirare();
            String des = produs.getDescrierea();
            DateTimeFormatter dataFormatata = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String stringData = data.format(dataFormatata);
            System.out.println("| " + i + " | " + nume + " | "+ pretDeAchizitie+" | "+ pretDeVanzare + " | "+ stringData + " |"+ des + " |");
            System.out.println("|---------------------------------------------------------------------------------------------------|");
        }
    }
    public void delete(ArrayList produsList,int id){
        produsList.remove(id);
    }
}
