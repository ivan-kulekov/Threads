package task2;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since May 05 , 2015 14:12
 */
public class CounterThread extends Thread {

  private int maxCount;
  private int count = 0;
  private final Object lock;
  private CounterThread thr;

  public CounterThread(int maxCount, Object lock) {
    this.maxCount = maxCount;
    this.lock = lock;
  }

  /**
   * Set the thread witch we start.
   *
   * @param thread is the tread to set.
   */
  public void set(CounterThread thread) {
    this.thr = thread;
  }

  /**
   * If count is equals to max count start counting and try to notify while the second one .
   */
  @Override
  public void run() {
    synchronized (lock) {
      while (count != maxCount) {
        count++;
        System.out.println(getName() + "count :" + count);
        lock.notify();
        try {
          lock.wait();
        } catch (InterruptedException ie) {
          break;
        }
      }
      thr.interrupt();
    }
  }
}
