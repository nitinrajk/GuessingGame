import java.util.Scanner;
public class Prompter{
  private Scanner scanner;
  
  public String getItemName(){
    scanner = new Scanner(System.in);
    System.out.print("What type of item you want to fill in the jar: ");
    return scanner.nextLine();
  }
  
  public int getNoOfItems(String itemName){
    System.out.printf("What is the maximum amount of %s you want to fill in the jar: ", itemName);
    String noOfItemsAsString = scanner.nextLine();
    return Integer.parseInt(noOfItemsAsString);
  }
  
  public int promptForGuess(){
     int guess;
     System.out.print("Guess: ");
     String guessAsString = scanner.nextLine();
     guess=Integer.parseInt(guessAsString); 
    return guess;
  }
  
  public void displayOutcome(int count){
    System.out.printf("You got it in %s attempts %n", count);
  }
  
}