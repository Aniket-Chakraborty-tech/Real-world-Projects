import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactManagement{
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> phoneNo = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        File myFile = new File("E:\\TextFilesforJava\\ContactList.txt");

        try {
            if(myFile.createNewFile()){
                System.out.println("Your Empty file is created!");
            }
            else{
                System.out.println("Your file is ready to use!");
            }
        }
        catch (Exception e) {
            System.out.println("File does not exist due to some error!");
            e.printStackTrace();
        }

        while(true){
            System.out.println("_____WELCOME TO THE CONTACT MANAGEMENT SYSTEM_____");
            System.out.println("\n1. Add Contact\n2. Delete Contact\n3. Update Contact\n4. Show All Contacts\n5. Save All Contacts\n6. Exit\n");

            System.out.print("Enter an option for proceed: ");
            int op;
            try {
                op = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid Input!");
                continue;
            }

            if(op == 6){
                System.out.println("Thank You.....GoodBye!");
                break;
            }

            switch(op){

                case 1:{
                    System.out.println("How many Contacts you want to add?");
                    int num;
                    try {
                       num = Integer.parseInt(scanner.nextLine()); 
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Invalid Number input!");
                        continue;
                    }
                    for(int i = 0; i < num; i++){
                        System.out.print("Enter Name: ");
                        names.add(scanner.nextLine());
                        System.out.print("Enter Phone Number: ");
                        phoneNo.add(scanner.nextLine());
                    }
                    System.out.println(num + " Contacts added successfully.\n");
                    break;
                }

                case 2:{
                    System.out.print("Enter Contact Name for delete: ");
                    String name = scanner.nextLine();
                    int index = names.indexOf(name);
                    if(index != -1){
                        names.remove(index);
                        phoneNo.remove(index);
                        System.out.println(name + " deleted successfully.\n");
                    }
                    else{
                        System.out.println("Contact not found!");
                    }
                    break;
                }

                case 3:{
                    System.out.print("Enter Contact Name for update: ");
                    String name = scanner.nextLine();
                    int index = names.indexOf(name);
                    if(index != -1){
                        System.out.print("Enter new Name: ");
                        String newName = scanner.nextLine();
                        names.set(index, newName);
                        System.out.print("Enter new Phone Number: ");
                        String newPhoneNo = scanner.nextLine();
                        phoneNo.set(index, newPhoneNo);
                    }
                    else{
                        System.out.println("Contact not found!");
                    }
                    break;
                }

                case 4:{
                    if(names.isEmpty()){
                        System.out.println("No Contacts are available!\n");
                    }
                    for(int i = 0; i < names.size(); i++){
                        System.out.println((i+1) + ". {Name: " + names.get(i) + ", Phone Number: " + phoneNo.get(i) + "}\n");
                    }
                    System.out.println();
                    break;
                }

                case 5:{
                    try(FileWriter fw = new FileWriter("ContactList.txt", true)) {
                        for(int i = 0; i < names.size(); i++) {
                            fw.write((i+1) + ". {Name: " + names.get(i) + ", Phone Number: " + phoneNo.get(i) + "}\n");
                        }
                        System.out.println("All Contacts Saves successfully\n");
                    }
                    catch (IOException e) {
                        System.out.println("An error occurred while saving contacts!");
                        e.printStackTrace();
                    }
                    break;
                }

                default:
                    System.out.println("Choose a valid option!\n");
            }
        }

        try(Scanner myReader = new Scanner(myFile)) {
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                System.out.println(data);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("An error occured!");
            e.printStackTrace();
        }
    }
}