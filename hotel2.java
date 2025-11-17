import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class hotel2 {

    ArrayList<String> customerName = new ArrayList<>();
    ArrayList<String> customerId = new ArrayList<>();
    ArrayList<Integer> acRoom = new ArrayList<>();
    ArrayList<Integer> nonAcRoom = new ArrayList<>();
    ArrayList<Integer> assignedRooms = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public hotel2() {
        for (int i = 1; i <= 500; i++) {
            nonAcRoom.add(i);
        }
        for (int j = 501; j <= 1000; j++) {
            acRoom.add(j);
        }

        try {
            File myFile = new File("E:\\Projects\\Java Hotel\\GuestList.txt");
            if (myFile.createNewFile()) {
                System.out.println("New File created.");
            } else {
                System.out.println("File already exist and ready to use.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void bookRoom() {
        System.out.print("Which type of room you want (AC / Non-AC)? ");
        String type = scanner.nextLine().toLowerCase();

        System.out.print("How many rooms you want? ");
        int count = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine();

        Random random = new Random();
        ArrayList<Integer> selectedRoomList = new ArrayList<>();

        if (type.equals("ac")) {
            if (count > acRoom.size()) {
                System.out.println("Not enough AC rooms available!");
                return;
            }
            for (int i = 0; i < count; i++) {
                int index = random.nextInt(acRoom.size());
                selectedRoomList.add(acRoom.get(index));
                acRoom.remove(index);
            }
        } 
        else if (type.equals("non-ac")) {
            if (count > nonAcRoom.size()) {
                System.out.println("Not enough Non-AC rooms available!");
                return;
            }
            for (int i = 0; i < count; i++) {
                int index = random.nextInt(nonAcRoom.size());
                selectedRoomList.add(nonAcRoom.get(index));
                nonAcRoom.remove(index);
            }
        } 
        else {
            System.out.println("Invalid room type.");
            return;
        }

        customerName.add(name);
        customerId.add(id);
        assignedRooms.addAll(selectedRoomList);

        try (FileWriter writer = new FileWriter("E:\\Projects\\Java Hotel\\List.txt", true)) {
            writer.write("{Customer Name: " + name + ", ID: " + id + ", Rooms: " + selectedRoomList + "}\n");
            System.out.println("File saved successfully.\n");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }

        System.out.println("Your booked room numbers are: " + selectedRoomList);
    }

    public void checkOut() {
        System.out.print("Enter Customer name for Check-Out: ");
        String name = scanner.nextLine();

        int index = customerName.indexOf(name);

        if (index != -1) {
            System.out.println("Check out successful for " + name);
            customerName.remove(index);
            customerId.remove(index);
        } else {
            System.out.println("Customer not found.");
        }
    }

    public void displayName() {
        if (customerName.isEmpty()) {
            System.out.println("Guest List is empty.");
            return;
        }

        System.out.println("\n--- Current Guest List ---");
        for (int i = 0; i < customerName.size(); i++) {
            System.out.println((i + 1) + ". Name: " + customerName.get(i) + ", ID: " + customerId.get(i));
        }
    }

    public double totalBill() {
        System.out.print("Enter your ID: ");
        String id = scanner.nextLine();

        if (!customerId.contains(id)) {
            System.out.println("Invalid ID.");
            return 0;
        }

        System.out.print("Enter number of days stayed: ");
        int days = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter number of rooms booked: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your room type (AC / Non-AC): ");
        String type = scanner.nextLine().toLowerCase();

        double price = 0;
        double gst = 0.06;

        if (type.equals("ac")) {
            price = 4000;
        } else if (type.equals("non-ac")) {
            price = 2000;
        } else {
            System.out.println("Invalid room type.");
            return 0;
        }

        double bill = price * days * count;
        bill += bill * gst;

        System.out.println("Your total bill is: ₹" + bill);
        return bill;
    }
}