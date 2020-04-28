package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

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
    public void addToAList(ArrayList produsList,ArrayList produsList2,int id){
            Produs produs = (Produs) produsList.get(id);
            produsList2.add(produs);
    }
    public double calcProfit(ArrayList produsList){
        double profit = 0;
        for (int i = 0;i< produsList.size();i++) {
            Produs produs = (Produs) produsList.get(i);
            profit += (produs.getPretDeVanzare() - produs.getPretDeAchizitie());
        }
        return profit;
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
    public void sortListByNume(ArrayList produsList){
        Collections.sort(produsList,new SortByNume());
    }
    public void sortListByDataDeExpirare(ArrayList produsList){
        Collections.sort(produsList,new SortByDataDeExpirare());
    }
    public void sortListByPretCrescator(ArrayList produsList){
        Collections.sort(produsList,new SortByPretCrescator());
    }
    public void sortListByPretDescrescator(ArrayList produsList){
        Collections.sort(produsList,new SortByPretDescrescator());
    }
    public int searchName(ArrayList produsList,String pnume){
        System.out.println("| Nr |      Nume      |      pretDeAchizitie      |      pretDeVanzare      |      data      |      descriere      |");
        System.out.println("|---------------------------------------------------------------------------------------------------|");
        int id = -1;
        for (int i = 0;i< produsList.size();i++){
            Produs produs = (Produs) produsList.get(i);
            String nume = produs.getNume();
            double pretDeAchizitie = produs.getPretDeAchizitie();
            double pretDeVanzare = produs.getPretDeVanzare();
            LocalDate data = produs.getDataDeExpirare();
            String des = produs.getDescrierea();
            DateTimeFormatter dataFormatata = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String stringData = data.format(dataFormatata);
            if(pnume.equals(nume)) {
                System.out.println("| " + i + " | " + nume + " | "+ pretDeAchizitie+" | "+ pretDeVanzare + " | "+ stringData + " |"+ des + " |");
                System.out.println("|---------------------------------------------------------------------------------------------------|");
                id = i;
            }
        }
        return id;
    }
}
