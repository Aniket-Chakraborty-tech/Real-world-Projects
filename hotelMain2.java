import java.util.Scanner;

public class hotelMain2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        hotel1 hotel = new hotel1();
        while (true) { 
            System.out.println("\n-----WELCOME TO OUR HOTEL-----\n");
            System.out.print("1. Book a Room\n2. Check Out\n3. Display All Customers\n4. Payment\n5. Exit\n");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:
                    hotel.bookRoom();
                    break;
                case 2:
                    hotel.checkOut();
                    break;
                case 3:
                    hotel.displayName();
                    break;
                case 4:
                    hotel.totalBill();
                    break;
                case 5:
                    System.out.println("Thank you for visiting!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
