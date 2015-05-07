package task5;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since May 07 , 2015 09:51
 */
public class HashDemo {
  public static void main(String[] args) {


    TimeoutHashTable<String, String> table = new TimeoutHashTable<String, String>(1000);

    String fruitApple = "Apple";
    String fruitOrange = "Orange";
    String fruitBerry = "Berry";
    String fruitBanana = "Banana";
    String fruitMango = "Mango";

    table.put("fruitApple", fruitApple);
    table.put("fruitOrange", fruitOrange);
    table.put("fruitBerry", fruitBerry);
    table.put("fruitBanana", fruitBanana);
    table.put("fruitMango", fruitMango);


    System.out.println(table.get("fruitBanana"));
    table.get("fruitOrange");

    System.out.println(table.get("fruitOrange"));

    System.out.println(table.get("fruitMango"));

  }
}
