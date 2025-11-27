package Java.Inventory;

import java.util.Scanner;
import java.util.ArrayList;

public class groceryMain {

    public static void main(String[] args) {

        ArrayList<String> fruits = new ArrayList<String>();
        ArrayList<Double> fruitPrice = new ArrayList<Double>();
        fruits.add("APPLE");
        fruits.add("BANANA");
        fruits.add("GRAPES");
        fruits.add("LICHI");
        fruits.add("MANGO");
        fruits.add("GUAVA");
        fruits.add("STRAWBERRY");
        fruitPrice.add(12.50);
        fruitPrice.add(6.50);
        fruitPrice.add(10.25);
        fruitPrice.add(8.50);
        fruitPrice.add(16.00);
        fruitPrice.add(11.50);
        fruitPrice.add(2.50);

        ArrayList<String> chips = new ArrayList<String>();
        ArrayList<Double> chipsPrice = new ArrayList<Double>();
        chips.add("LAYS");
        chips.add("UNCLE CHIPS");
        chips.add("KURKURE");
        chips.add("TOO YUMM");
        chips.add("CRACKS");
        chips.add("RINGS");
        chips.add("PARLE CLASSIC");
        chipsPrice.add(10.00);
        chipsPrice.add(15.00);
        chipsPrice.add(10.00);
        chipsPrice.add(20.00);
        chipsPrice.add(10.00);
        chipsPrice.add(5.00);
        chipsPrice.add(10.00);

        ArrayList<String> biscuits = new ArrayList<String>();
        ArrayList<Double> biscuitsPrice = new ArrayList<Double>();
        biscuits.add("OREO");
        biscuits.add("JIM JAM");
        biscuits.add("LOTUS BISCOFF");
        biscuits.add("BRITANNIA MARIE");
        biscuits.add("BRITANNIA THIN");
        biscuits.add("PARLE PLATINUM");
        biscuits.add("SUNFEAST MARIE GOLD");
        biscuitsPrice.add(100.00);
        biscuitsPrice.add(50.00);
        biscuitsPrice.add(700.00);
        biscuitsPrice.add(50.00);
        biscuitsPrice.add(60.00);
        biscuitsPrice.add(80.00);
        biscuitsPrice.add(40.00);

        ArrayList<String> dryFruits = new ArrayList<String>();
        ArrayList<Double> dryFruitsPrice = new ArrayList<Double>();
        dryFruits.add("ALMONDS");
        dryFruits.add("CASHEWS");
        dryFruits.add("RASINS");
        dryFruits.add("ARAB DATES");
        dryFruits.add("MIXED DRY FRUITS");
        dryFruits.add("PEANUTS");
        dryFruits.add("HAZLEWOOD NUTS");
        dryFruitsPrice.add(400.00);
        dryFruitsPrice.add(950.00);
        dryFruitsPrice.add(350.00);
        dryFruitsPrice.add(250.00);
        dryFruitsPrice.add(650.00);
        dryFruitsPrice.add(150.00);
        dryFruitsPrice.add(900.00);

        ArrayList<String> orderedItems = new ArrayList<String>();
        ArrayList<Double> orderedItemsPrice = new ArrayList<Double>();

        grocery market1 = new grocery();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n-----WELCOME TO THE INVENTORY-----\n");
            System.out.println("1. Fruits\n2. Chips\n3. Biscuits\n4. Dry Fruits\n5. Total Bill\n6. Exit\n");
            System.out.print("Choose your shopping category: ");
            int shoppingCategory = sc.nextInt();
            sc.nextLine();

            if (shoppingCategory == 6) {
                break;
            }

            switch (shoppingCategory) {
                case 1:
                    while (true) {
                        for (int i = 0; i < fruits.size(); i++) {
                            System.out.println((i + 1) + ". " + fruits.get(i) + ": " + fruitPrice.get(i));
                        }
                        market1.addItem(fruits, fruitPrice, orderedItems, orderedItemsPrice);
                        System.out.print("Do you want to continue shopping(Y for yes/ N for no): ");
                        String choice = sc.nextLine();
                        if (choice.equalsIgnoreCase("Y")) {
                            continue;
                        } else if (choice.equalsIgnoreCase("N")) {
                            break;
                        } else {
                            System.out.println("Enter a valid choice.\n");
                        }
                    }
                    break;

                case 2:
                    while (true) {
                        for (int i = 0; i < chips.size(); i++) {
                            System.out.println((i + 1) + ". " + chips.get(i) + ": " + chipsPrice.get(i));
                        }
                        market1.addItem(chips, chipsPrice, orderedItems, orderedItemsPrice);
                        System.out.print("Do you want to continue shopping(Y for yes/ N for no): ");
                        String choice = sc.nextLine();
                        if (choice.equalsIgnoreCase("Y")) {
                            continue;
                        } else if (choice.equalsIgnoreCase("N")) {
                            break;
                        } else {
                            System.out.println("Enter a valid choice.\n");
                        }
                    }
                    break;

                case 3:
                    while (true) {
                        for (int i = 0; i < biscuits.size(); i++) {
                            System.out.println((i + 1) + ". " + biscuits.get(i) + ": " + biscuitsPrice.get(i));
                        }
                        market1.addItem(biscuits, biscuitsPrice, orderedItems, orderedItemsPrice);
                        System.out.print("Do you want to continue shopping(Y for yes/ N for no): ");
                        String choice = sc.nextLine();
                        if (choice.equalsIgnoreCase("Y")) {
                            continue;
                        } else if (choice.equalsIgnoreCase("N")) {
                            break;
                        } else {
                            System.out.println("Enter a valid choice.\n");
                        }
                    }
                    break;

                case 4:
                    while (true) {
                        for (int i = 0; i < dryFruits.size(); i++) {
                            System.out.println((i + 1) + ". " + dryFruits.get(i) + ": " + dryFruitsPrice.get(i));
                        }
                        market1.addItem(dryFruits, dryFruitsPrice, orderedItems, orderedItemsPrice);
                        System.out.print("Do you want to continue shopping(Y for yes/ N for no): ");
                        String choice = sc.nextLine();
                        if (choice.equalsIgnoreCase("Y")) {
                            continue;
                        } else if (choice.equalsIgnoreCase("N")) {
                            break;
                        } else {
                            System.out.println("Enter a valid choice.\n");
                        }
                    }
                    break;

                case 5:
                    double bill = market1.totalBill(orderedItemsPrice);
                    System.out.println("Your total bill is: " + bill);
                    break;
            }
        }
        sc.close();
    }
}