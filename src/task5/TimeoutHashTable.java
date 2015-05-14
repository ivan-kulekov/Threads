package task5;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since May 07 , 2015 09:31
 */
public class TimeoutHashTable<K, V> {


  private int maxCount;
  private Map<K, ThreadTimeout<K, V>> table = new Hashtable<K, ThreadTimeout<K, V>>();

  public TimeoutHashTable(int maxCount) {
    this.maxCount = maxCount;
  }

  /**
   * Put the key and value to the table and start the thread.
   *
   * @param key   is the key to put.
   * @param value is the value to put.
   */
  public void put(K key, V value) {
    ThreadTimeout<K, V> thread = new ThreadTimeout<K, V>(this.table, maxCount, value, key);
    table.put(key, thread);
    thread.start();
  }

  /**
   * Get the key if contains and stop the thread , then put again and start the thread.
   *
   * @param key is the key.
   * @return for returned value.
   */
  public V get(String key) {
    if (table.containsKey(key)) {
      table.get(key).resetTimer();
      return table.get(key).getData();
    }
    return null;
  }

  /**
   * To remove the key.
   *
   * @param key for remove.
   * @return the value after remove.
   */
  public V remove(K key) {
    if (table.containsKey(key)) {
      return table.remove(key).getData();
    }
    return null;
  }

  private void resetTimer() {

  }
}
