import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.util.Random;

public class Secret_Passcode{
     public static void main(String [] args) throws IOException {
         String userChoice = "";
         int pwLength = 0;
         int randNum = 0;
         int length = 0;
         Random randList = new Random();
         String password = "";
         boolean contLength = true;
         boolean cont = true;
         int counter = 1;
         Scanner inLength = new Scanner(System.in);
         Scanner in = new Scanner(System.in);
         PrintWriter outFile = new PrintWriter(new File("Passwords.txt"));
         System.out.println("**********************************************************");
         System.out.println("This password generator will generate several passwords based on your desired length. \nThe password will include lowercase, uppercase, & numbers.");
         while (cont == true) {
             counter++;
             while (cont == true) {
                 System.out.print("Would you like to generate a password? Y/N ");
                 userChoice = in.next();
                 char uc = userChoice.charAt(0);
                 if (uc == 'y' || uc == 'Y') {
                     System.out.print("Enter the desired password length (6-9): ");
                     length = inLength.nextInt();
                     if (length < 6) {
                         System.out.println("\n Password length too short. Please try again.");
                     } else {
                         contLength = false;
                         System.out.print("Randomly generated password: ");
                         for (int i = 1; i <= length; i++) {
                             randNum = 0;
                             while (!((randNum >= 48 && randNum <= 57) || (randNum >= 65 && randNum <= 90) || (randNum >= 97 && randNum <= 122))) {
                                 randNum = randList.nextInt(127);
                             }
                             System.out.print((char) randNum);
                             password = String.valueOf((char) randNum);
                         }
                         System.out.println("");
                         outFile.println(password);
                         System.out.println("A password has been written to the text file");
                     }
                 }
                 else {
                     outFile.close();
                     System.out.println("");
                     System.out.println("Thank you for using the Pass Code Generator.");
                     cont = false;
                     System.out.println("Here are your randomly generated Pass Codes:");
                     File file = new File("/Users/richa/IdeaProjects/HelloWorld/Passwords.txt");
                     Scanner sc = new Scanner(file);
                     try {
                         String line;
                         while (sc.hasNextLine()) {
                             new String line = sc.nextLine();
                         }
                         System.out.println(line);
                     }
                     catch(FileNotFoundException e){
                         
                     }
                 }
             }
         }
     }
}
