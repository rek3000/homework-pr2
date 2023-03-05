import java.util.*;
import java.io.*;

/* In this class, the existence for the nextLine() or skip() 
   * is to prevent the next*() method to get the new line char.
   * , which could possibly raise errors.
   * */
public class Utils {
  static Scanner utilScan = new Scanner(System.in);

  public static void addProduct(ArrayList<Products> list) {
    String name;
    double price;
    long quantity;
    int n;

    // Error handling
    while (true) {
      try {
        System.out.println("Number of items");
        System.out.print("> ");
        n = utilScan.nextInt();
        if (n < 1) {
          continue;
        }
        break; 
      } catch (Exception e) {
        System.out.println("It isn't a number!");
        utilScan.nextLine();
        return;
      }
    }

    utilScan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    // Add items
    for (int i = 0; i < n; i++) {
      System.out.println();
      System.out.println("Product " + n);
      System.out.println("Name");  
      System.out.print("> ");  
      name = utilScan.nextLine().trim();
      while (true) {
        System.out.println("Price");  
        System.out.print("> ");
        try {
          price = utilScan.nextDouble();
          break;
        } catch (Exception e) {
          System.out.println("INVALID");
          utilScan.nextLine();
          continue;
        }
      }

      int choice = 0;
      for (int j = 0; j < list.size(); j++) {
        if ((name.equals(list.get(j).getName()) && (price == list.get(j).getPrice()))) {
          System.out.println("This item has existed");
          System.out.println("Increment the quantity of this?");
          System.out.println("[1]. No");
          System.out.println("[2]. Yes");
          System.out.print("> ");

          while (true) {
            try {
              choice = utilScan.nextInt();
              break;
            } catch (Exception e) {
              System.out.println("INVALID!");
              utilScan.nextLine();
              continue;
            }
          }

          if (choice == 2) {
            while (true) {
              System.out.println("Quantity");  
              System.out.print("> ");
              try {
                quantity = utilScan.nextLong();
                break;
              } catch (Exception e) {
                System.out.println("INVALID");
                utilScan.nextLine();
                continue;
              }
            }

            list.set(j, new Products(name, price, quantity + list.get(j).getQuantity()));
            utilScan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            return;
          }

          break;
        }
      }

      if (choice == 1) {
        continue;
      }

      while (true) {
        System.out.println("Quantity");  
        System.out.print("> ");
        try {
          quantity = utilScan.nextLong();
          break;
        } catch (Exception e) {
          System.out.println("INVALID");
          utilScan.nextLine();
          continue;
        }
      }

      list.add(new Products(name, price, quantity));
      utilScan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    }

    System.out.println();
    System.out.println("****");
    System.out.println("DONE");
    System.out.println("****");
  }
  public static void displayProduct(ArrayList<Products> list) {
    if (list.size() < 1) {
      System.out.println("Null list!");
      return;
    }

    System.out.println();
    System.out.println("*---------------------PRODUCTS---------------------*");
    System.out.println("+--------------------------------------------------+");
    System.out.println("| ID      | Name         | Price     | Quantity    |");
    for (int i = 0; i < list.size(); ++i) {
      System.out.println(list.get(i).getInfo());
    }
    System.out.println("+--------------------------------------------------+");
  }

  public static void deleteProduct(ArrayList<Products> list) {
    if (list.size() < 1) {
      System.out.println("Null list!");
      return;
    }

    String id;
    boolean quit = false;

    while (!quit) {
      System.out.println();
      System.out.println("Product ID");
      System.out.print("> ");
      id = utilScan.nextLine();

      for (int i = 0; i < list.size(); i++) {
        if (id.equals(list.get(i).getId())) {
          quit = true;
          list.remove(i);

          System.out.println();
          System.out.println("****");
          System.out.println("DONE");
          System.out.println("****");
          System.out.println();

          break;
        } else if (i == list.size() - 1) {
          System.out.println("ID not found!");
        }
      }
    }
  }

  public static void editProduct(ArrayList<Products> list) {
    if (list.size() < 1) {
      System.out.println("Null list!");
      return;
    }

    String name;
    double price;
    long quantity;
    String id;
    boolean quit = false;

    while (!quit) {
      System.out.println();
      System.out.println("Product ID");
      System.out.print("> ");
      id = utilScan.nextLine();
      for (int i = 0; i < list.size(); i++) {
        if (id.equals(list.get(i).getId())) {
          quit = true;
          System.out.println("Name");  
          System.out.print("> ");
          name = utilScan.nextLine();
          while (true) {
            System.out.println("Price");  
            System.out.print("> ");
            try {
              price = utilScan.nextDouble();
              break;
            } catch (Exception e) {
              System.out.println("INVALID");
            }
          }

          while (true) {
            System.out.println("Quantity");  
            System.out.print("> ");
            try {
              quantity = utilScan.nextLong();
              break;
            } catch (Exception e) {
              System.out.println("INVALID");
              continue;
            }
          }

          list.set(i, new Products(name, price, quantity, list.get(i).getId()));
          utilScan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
          break;
        } else if (i == list.size() - 1) {
          System.out.println("ID not found!");
        }
      } 
    }

    System.out.println();
    System.out.println("****");
    System.out.println("DONE");
    System.out.println("****");
  }

  public static void searchProductByName(ArrayList<Products> list) {
    if (list.size() < 1) {
      System.out.println("Null list!");
      return;
    }

    System.out.println();
    System.out.println("Search");
    System.out.print("> ");
    String keyWord = utilScan.nextLine();

    // Case-Insensitive Search
    System.out.println();
    System.out.println("+--------------------------------------------------+");
    System.out.println("| ID      | Name         | Price     | Quantity    |");
    if (!(keyWord == "")) {
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getName().toLowerCase().contains(keyWord.toLowerCase())) {
          System.out.println(list.get(i).getInfo());
        } 
      }
    }
    System.out.println("+--------------------------------------------------+");
  }

  // Sort by price. Additionally, when two prices are the same, also sort names.
  public static void sortProductByPrice(ArrayList<Products> list) {
    if (list.size() < 1) {
      System.out.println("Null list!");
      return;
    }

    List<String> mapNames = new ArrayList<>();
    List<Double> mapPrices = new ArrayList<>();

    for (int i = 0; i < list.size(); i++) {
      mapNames.add(list.get(i).getName());
      mapPrices.add(list.get(i).getPrice());
    }

    Collections.sort(mapNames);
    Collections.sort(mapPrices);

    Double price;
    String name;

    System.out.println();
    System.out.println("*------------------SORT BY PRICE-------------------*");
    System.out.println("+--------------------------------------------------+");
    System.out.println("| ID      | Name         | Price     | Quantity    |");
    while (!mapPrices.isEmpty()) { 
      price = mapPrices.get(0);

      for (int j = 0; j < mapNames.size(); j++) {
        name = mapNames.get(j);
        for (int x = 0; x < list.size(); x++) {
          if ((price == list.get(x).getPrice()) &&
        (name.equals(list.get(x).getName()))) {
            System.out.println(list.get(x).getInfo());
            mapPrices.remove(0);
            mapNames.remove(j);
            break;
          }
        }
      }
    }
    System.out.println("+--------------------------------------------------+");
  }

  // Save/load list of products to/from a binary file
  public static void saveProductsToFile(ArrayList<Products> list) {
    System.out.println("Be careful! You may overwrite the current saved files.");
    System.out.println("File name");
    System.out.print("> ");

    File f = new File(utilScan.nextLine());
    try {
      FileOutputStream fos = new FileOutputStream(f);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(list);
      oos.flush();
      oos.close();

    } catch (Exception e) {
    }
  }

  public static void loadProductsFromFile(ArrayList<Products> list) {

    while (true) {
      if (list.size() > 0) {
        int choice;

        System.out.println("Overwrite current list?");
        System.out.println("[1]. No");
        System.out.println("[2]. Yes");
        System.out.print("> ");

        try {
          choice = utilScan.nextInt();
          utilScan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        } catch (Exception e) {
          utilScan.nextLine();
          continue;
        }

        if (choice == 1) {
          return;
        }
      }
      break;
    }

    System.out.println();
    System.out.println("File name");
    System.out.print("> ");

    File f = new File(utilScan.nextLine());
    try {
      FileInputStream fis = new FileInputStream(f);
      ObjectInputStream ois = new ObjectInputStream(fis);
      ArrayList<Products> tmp = (ArrayList<Products>) ois.readObject();
      ois.close();
      list.clear();

      for (int i = 0; i < tmp.size(); i++) {
        list.add(new Products(tmp.get(i).getName(),
          tmp.get(i).getPrice(),
          tmp.get(i).getQuantity(),
          tmp.get(i).getId()));
      }
    } catch (Exception e) {
      System.out.println("File not found!");
    }
  }
}
