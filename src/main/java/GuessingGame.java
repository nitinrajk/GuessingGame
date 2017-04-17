
public class GuessingGame {

    public static void main(String[] args) {
      
      System.out.println("--------------Administrator Setup--------------------");
      Prompter prompt = new Prompter();
      String itemName = prompt.getItemName();
      validateItemName(itemName);
      int maxNoOfItems = prompt.getNoOfItems(itemName);
      Jar jar =  new Jar(itemName, maxNoOfItems);
      int itemsInJar = jar.fill(maxNoOfItems);
      System.out.println("---------------Player Setup-----------------");
      System.out.printf("How many %s are in the jar ? Pick a number between 1 and %d,"+
                        "when prompted for guess %n",itemName, maxNoOfItems);  
      int count = guessNoOfItems(prompt,itemsInJar, maxNoOfItems);
      prompt.displayOutcome(count);
    }
    
  private static int guessNoOfItems(Prompter prompt,int itemsInJar, int maxNoOfItems){
    int guess;
    int count=0;
    do{
      ++count; 
      guess=prompt.promptForGuess(); 
      count = (validateGuess(guess,itemsInJar, maxNoOfItems) ? count : --count);
    } while(!(guess == itemsInJar));
    return count;
  }
  
  private static void validateItemName(String itemName){
    if(itemName.length()==0){
        System.out.println("An item name is required, empty string is not allowed");
        System.out.println("Exiting....");
        System.exit(1);
      }
  }
  
  private static boolean validateGuess(int guess, int itemsInJar, int maxNoOfItems){
    if(guess == 0 || guess <0){
      System.out.printf("Invalid number. Pick a number between 1 and %d only %n",maxNoOfItems);
      return false;
    }
    if(guess > maxNoOfItems){
      System.out.printf("Your guess must be less than %d%n",maxNoOfItems);
      return false;
    }
    evaluatePlayerGuess(guess, itemsInJar);
    return true;
  }
  
  private static void evaluatePlayerGuess(int guess, int itemsInJar){
    if(guess > itemsInJar){
      System.out.println("Your guess is too high");
    } else if(guess < itemsInJar){
      System.out.println("Your guess is too low");
    }
  }
  
}
