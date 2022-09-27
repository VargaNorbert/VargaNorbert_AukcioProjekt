package hu.petrik.aukcioprojekt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Festmeny> festmenyek = new ArrayList<>();
    public static void main(String[] args) {
        Festmeny festmeny= new Festmeny("asd","asd","asd");
        Festmeny festmeny2= new Festmeny("asd","asd","asd");

        festmenyek.add(festmeny2);
        festmenyek.add(festmeny);
        try {
            festmenyekFelveteleKonzolrol();
        } catch (Exception e) {
            System.out.println("Nem megfelelő példány!");
        }

    }

    private static void festmenyekFelveteleKonzolrol(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Mennyi?");
        int db= sc.nextInt();

        for (int i = 0; i < db; i++) {
            System.out.printf("Cím?");
            String cim= sc.nextLine();
            System.out.printf("Festő?");
            String festo= sc.nextLine();
            System.out.printf("Stílus?");
            String stilus= sc.nextLine();

            Festmeny festmeny= new Festmeny(cim,festo,stilus);
            festmenyek.add(festmeny);
        }
    }


}
