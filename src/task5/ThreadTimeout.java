package task5;

import java.util.Map;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since May 07 , 2015 09:34
 */
public class ThreadTimeout<K, D> extends Thread {


  private int maxTime;
  private Map<K, ThreadTimeout<K, D>> table;
  private D data;
  private K key;

  public ThreadTimeout(Map<K, ThreadTimeout<K, D>> table, int maxTime, D data, K key) {

    this.table = table;
    this.maxTime = maxTime;
    this.data = data;
    this.key = key;
  }

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(maxTime);
        break;
      } catch (InterruptedException ie) {
        System.out.println("Renew timer for -> " + getName());
      }
    }
    if (table.containsValue(this)) {
      table.remove(key);
    }
  }


  public D getData() {
    return data;
  }
}
