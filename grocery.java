package Java.Inventory;

import java.util.ArrayList;
import java.util.Scanner;

public class grocery {

    Scanner scanner = new Scanner(System.in);

    public void addItem(ArrayList<String> l1, ArrayList<Double> l2, ArrayList<String> l3, ArrayList<Double> l4) {
        System.out.print("Enter the Item-number you wanted to buy: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        if (number > l1.size()) {
            System.out.println("Enter a valid number.");
        }
        String ordered_item = l1.get(number - 1);
        double ordered_item_price = l2.get(number - 1);
        l3.add(ordered_item);
        l4.add(ordered_item_price);
    }

    public double totalBill(ArrayList<Double> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}