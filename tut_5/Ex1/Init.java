/* 
      ___           ___           ___
     /  /\         /  /\         /__/|    
    /  /::\       /  /:/_       |  |:|    
   /  /:/\:\     /  /:/ /\      |  |:|    
  /  /:/~/:/    /  /:/ /:/_   __|  |:|    
 /__/:/ /:/___ /__/:/ /:/ /\ /__/\_|:|____
 \  \:\/:::::/ \  \:\/:/ /:/ \  \:\/:::::/
  \  \::/~~~~   \  \::/ /:/   \  \::/~~~~ 
   \  \:\        \  \:\/:/     \  \:\     
    \  \:\        \  \::/       \  \:\    
     \__\/         \__\/         \__\/

*/
/* A SUCK PRODUCTS MANAGEMENT TOOL */
import java.util.*;

public class Init {
  static Scanner initScan = new Scanner(System.in);
  public static void main(String[] args) {
    ArrayList<Products> list = new ArrayList<>();
    banner();
    menuLoop(list);
  }

  private static void menuLoop(ArrayList<Products> list) {
    while (true) {
      System.out.println();
      System.out.println("+----------------------------------------+");
      System.out.println("| [1]. Add products                      |");
      System.out.println("| [2]. Display products                  |");
      System.out.println("| [3]. Delete a product                  |");
      System.out.println("| [4]. Edit a product                    |");
      System.out.println("| [5]. Search for products by name       |");
      System.out.println("| [6]. Sort products by price            |");
      System.out.println("| [7]. Save products to binary file      |");
      System.out.println("| [8]. Load products from the saved file |");
      System.out.println("| [9]. Exit                              |");
      System.out.println("+----------------------------------------+");
      System.out.print("> ");
      
      int choice;
      try {
        choice = initScan.nextInt();
      } catch (Exception e) {
        initScan.nextLine();
        System.out.println("INVALID!");
        continue;
      }

      if ((choice < 1) || (choice > 9)) {
        continue;
      } else if (choice == 9) { 
        break;
      }
      initScan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      switch (choice) {
        case 1:
          Utils.addProduct(list);
          break;

        case 2:
          Utils.displayProduct(list);
          break;

        case 3:
          Utils.deleteProduct(list);
          break;

        case 4:
          Utils.editProduct(list);
          break;

        case 5:
          Utils.searchProductByName(list);
          break;

        case 6:
          Utils.sortProductByPrice(list);
          break;

        case 7:
          Utils.saveProductsToFile(list);
          break;

        case 8:
          Utils.loadProductsFromFile(list);
          break;

        default:
          break;
      }
    }
  }

  public static void banner() {
    System.out.println();
    System.out.println("    |\\__/,|   (`\\");
    System.out.println("  _.|o o  |_   ) )");
    System.out.println("+(((---(((--------");
  }
}
