package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void showMeniu(){
        System.out.println("\t\t\t-----------------------------Meniu-----------------------------");
        System.out.println("\t\t\t--------------------- 1 - Add     -----------------------------");
        System.out.println("\t\t\t--------------------- 2 - View    -----------------------------");
        System.out.println("\t\t\t--------------------- 3 - Delete (Puntul 3 scoatere din stoc)  -----------------------------");
        System.out.println("\t\t\t--------------------- 4 - Sort    -----------------------------");
        System.out.println("\t\t\t--------------------- 5 - Exit    -----------------------------");
    }
    public static void main(String[] args) {
        ProdusManager produsManager = new ProdusManager();
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
                        System.out.println("Enter data de nastere (yyyy-mm-dd):");
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
                        System.out.println("Delete");
                        System.out.println("Enter nr produs:");
                        int id = scan.nextInt();
                        produsManager.delete(produsList,id);
                        break;
                    }
                    case '5': {
                        System.out.println("Exit");
                        finish = 1;
                        break;
                    }
                    default: {

                        System.out.println("Enter 1|2|3|4|5|6|7 only");
                    }
                }

            } while (finish != 1);
        }catch (Exception e){
            System.out.println("Error");
        }
    }
}
