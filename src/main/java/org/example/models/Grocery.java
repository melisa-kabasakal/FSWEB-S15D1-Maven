package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery(){
        Scanner scanner = new Scanner(System.in);

        int choose = scanner.nextInt();

        if(choose == 0){
            System.out.println("Uygulamayı durdur");
        }else if (choose == 1) {
            System.out.println("Eklemek istediğiniz elemanları girin (virgülle ayırabilirsiniz):");
            String input = scanner.nextLine();
            String[] itemsToAdd = input.split(",");
            for (String item : itemsToAdd) {
                groceryList.add(item.trim());  // Her elemanın başındaki ve sonundaki boşlukları temizler
            }
            System.out.println("Grocery Listesi: " + groceryList);
        } else if (choose == 2) {
            System.out.println("Çıkarmak istediğiniz elemanları girin (virgülle ayırabilirsiniz):");
            String input = scanner.nextLine();
            String[] itemsToRemove = input.split(",");
            for (String item : itemsToRemove) {
                groceryList.remove(item.trim());  // Her elemanın başındaki ve sonundaki boşlukları temizler
            }
            System.out.println("Grocery Listesi: " + groceryList);
        } else {
            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
        }
    }

    public static void addItems(String input) {
        String[] itemsToAdd = input.split(",");
        for (String item : itemsToAdd) {
            if (!checkItemIsInList(item)) {
                groceryList.add(item);
            } else {
                System.out.println(item + " zaten listede mevcut.");
            }
        }
        Collections.sort(groceryList);
    }


    public static void removeItems(String input) {
        String[] itemsToRemove = input.split(",");
        for (String item : itemsToRemove) {
            if (checkItemIsInList(item)) {
                groceryList.remove(item);
            } else {
                System.out.println(item + " listede bulunamadı.");
            }
        }
        Collections.sort(groceryList);
    }


    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println(groceryList);
    }
}


