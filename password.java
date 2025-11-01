import java.util.Random;
import java.util.Scanner;

public class password{
    public static void main(String[] args) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String number = "1234567890";
        String specialChar = "!@#$%^&*";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of Upper characters for your Password: ");
        int up = scanner.nextInt();
        System.out.print("Enter number of Lower characters for your Password: ");
        int low = scanner.nextInt();
        System.out.print("Enter number of Numbers for your Password: ");
        int num = scanner.nextInt();
        System.out.print("Enter number of Special characters for your Password: ");
        int special = scanner.nextInt();
        Random random = new Random();
        StringBuilder result1 = new StringBuilder();
        StringBuilder result2 = new StringBuilder();
        StringBuilder result3 = new StringBuilder();
        StringBuilder result4 = new StringBuilder();
        for(int i=0; i<up; i++){
            int index1 = random.nextInt(upper.length());
            result1.append(upper.charAt(index1));
        }
        for(int j=0; j<low; j++){
            int index2 = random.nextInt(lower.length());
            result2.append(lower.charAt(index2));
        }
        for(int k=0; k<num; k++){
            int index3 = random.nextInt(number.length());
            result3.append(number.charAt(index3));
        }
        for(int x=0; x<special; x++){
            int index4 = random.nextInt(specialChar.length());
            result4.append(specialChar.charAt(index4));
        }
        result1.append(result2).append(result4).append(result3);
        System.out.println("\nYour new password is: " + result1.toString() + "\n");
        scanner.close();
    }
}