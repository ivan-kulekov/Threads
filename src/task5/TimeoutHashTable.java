package task5;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since May 07 , 2015 09:31
 */
public class TimeoutHashTable<K, V> {


  private final int maxCount;
  private Map<K, ThreadTimeout<K, V>> table = new Hashtable<K, ThreadTimeout<K, V>>();

  public TimeoutHashTable(int maxCount) {
    this.maxCount = maxCount;
  }


  public void put(K key, V value) {
    ThreadTimeout<K, V> thread = new ThreadTimeout<K, V>(this.table, maxCount, value, key);
    table.put(key, thread);
    thread.start();
  }


  public V get(String key) {
    if (table.containsKey(key)) {
      table.get(key).interrupt();
      return table.get(key).getData();
    }
    return null;
  }

  public V remove(K key) {
    if (table.containsKey(key)) {
      return table.remove(key).getData();
    }
    return null;
  }


}
