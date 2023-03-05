import java.io.*;
import java.util.*;

public class Products implements Serializable{
  private String name;
  private double price;
  private long quantity;
  private String id;
  private static int index = 0;

  public Products(String name, double price, long quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;

    String f;
    try {
      f = this.name.substring(0,2).toLowerCase();
    } catch (Exception e) {
      f = this.name.substring(0,1).toLowerCase();
    }

    this.id = Integer.toString(index) + this.name.length() + f + quantity;
    this.index++;
  }

  public Products(String name, double price, long quantity, String id) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public long getQuantity() {
    return quantity;
  }

  public String getId() {
    return id;
  }

  public String getInfo() {
    return ("| " + this.id + " ".repeat((8 - this.id.length())) + 
            "| " + this.name + " ".repeat((13 - this.name.length())) + 
            "| " + this.price + " ".repeat((10 - String.valueOf(this.price).length())) + 
            "| " + this.quantity + " ".repeat((12 - String.valueOf(this.quantity).length())) + "|");
  }

}
