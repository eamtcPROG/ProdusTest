package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void showMeniu(){
        System.out.println("\t\t\t-----------------------------Meniu-----------------------------");
        System.out.println("\t\t\t--------------------- 1 - Add     -----------------------------");
        System.out.println("\t\t\t--------------------- 2 - View    -----------------------------");
        System.out.println("\t\t\t--------------------- 3 - Cumparate produs  -------------------");
        System.out.println("\t\t\t--------------------- 4 - Calcularea profitului    -----------------------------");
        System.out.println("\t\t\t--------------------- 5 - Sort    -----------------------------");
        System.out.println("\t\t\t--------------------- 6 - Exit    -----------------------------");
    }
    public static void sort(ProdusManager produsManager,ArrayList produsList){

        Scanner scan = new Scanner(System.in);
        char input;int finish =0;

        System.out.println("\t\t\t-----------------------------Meniu-----------------------------");
        System.out.println("\t\t\t--------------------- 1 - Sort by nume    -------------------------------");
        System.out.println("\t\t\t--------------------- 2 - Sort by data de expirare invers      --------------------------");
        System.out.println("\t\t\t--------------------- 3 - Sort by pret crescator    -------------------------------");
        System.out.println("\t\t\t--------------------- 4 - Sort by pret descrescator    -------------------------------");
        input = scan.next().charAt(0);
        do {
            switch (input) {
                case '1': {
                    System.out.println("Sort by nume");
                    scan.nextLine();
                    produsManager.sortListByNume(produsList);
                    finish = 1;
                    break;
                }
                case '2': {
                    System.out.println("Sort by data de expirare invers");
                    scan.nextLine();
                    produsManager.sortListByDataDeExpirare(produsList);
                    finish = 1;
                    break;
                }
                case '3': {
                    System.out.println("Sort by pret crescator");
                    scan.nextLine();
                    produsManager.sortListByPretCrescator(produsList);
                    finish = 1;
                    break;
                }
                case '4': {
                    System.out.println("Sort by pret crescator");
                    scan.nextLine();
                    produsManager.sortListByPretDescrescator(produsList);
                    finish = 1;
                    break;
                }
                default: {
                    System.out.println("Enter 1|2|3|4 only");
                }
            }
        }while (finish != 1);
    }
    public static void main(String[] args) {
        ProdusManager produsManager = new ProdusManager();
        ArrayList produsListVandute = new ArrayList();
        ArrayList produsList = new ArrayList();
        Scanner scan = new Scanner(System.in);
        byte finish = 0;
        char input;
        String nume;
        double prețulDeAchiziție,prețulDeVanzare;
        try {
            do {
                showMeniu();
                input = scan.next().charAt(0);
                switch (input) {
                    case '1': {
                        System.out.println("Add");
                        System.out.println("Enter nume:");
                        scan.nextLine();
                        nume = scan.nextLine();
                        System.out.println("Enter prețul de achiziție:");
                        prețulDeAchiziție = scan.nextDouble();
                        System.out.println("Enter prețul de vanzare:");
                        prețulDeVanzare = scan.nextDouble();
                        scan.nextLine();
                        System.out.println("Enter data de expirare (yyyy-mm-dd):");
                        LocalDate date = LocalDate.parse(scan.nextLine());
                        System.out.println("Enter descriere");
                        String des = scan.nextLine();
                        produsManager.add(produsList, nume, prețulDeAchiziție, prețulDeVanzare,date,des);
                        break;
                    }
                    case '2': {
                        System.out.println("View");
                        produsManager.view(produsList);
                        break;
                    }
                    case '3': {
                        System.out.println("Cumparare produs");
                        System.out.println("Enter nume: ");
                        scan.nextLine();
                        String pnume = scan.nextLine();
                        int id = produsManager.searchName(produsList,pnume);
                        if(id != -1) {
                            produsManager.addToAList(produsList,produsListVandute,id);
                            produsManager.delete(produsList, id);
                        }
                        else{
                            System.out.println("Nu exista acest produs");
                        }
                        break;
                    }
                    case '4': {
                        System.out.println("Calcul profit");
                        double profit = produsManager.calcProfit(produsListVandute);
                        System.out.println("Profitul = "+ profit);
                        break;
                    }
                    case '5': {
                        System.out.println("Sort");
                        sort(produsManager,produsList);
                        break;
                    }
                    case '6': {
                        System.out.println("Exit");
                        finish = 1;
                        break;
                    }
                    default: {
                        System.out.println("Enter 1|2|3|4|5|6 only");
                    }
                }

            } while (finish != 1);
        }catch (Exception e){
            System.out.println("Error");
        }
    }
}
