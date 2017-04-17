
import java.util.Random;
public class Jar{
  private String itemName;
  private int maxNoOfItems;
  Random random = new Random();
  
  public Jar(String itemName, int maxNoOfItems){
    this.itemName=itemName;
    this.maxNoOfItems=maxNoOfItems;
  }
  
  public int fill(int maxNoOfItems){
    int itemsInJar;
    int randomNumber = random.nextInt(maxNoOfItems);
    itemsInJar = (randomNumber==0) ? 1 : (randomNumber+1); 
    return itemsInJar;
  }
  
}