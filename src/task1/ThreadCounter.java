package task1;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since May 05 , 2015 11:21
 */
public class ThreadCounter extends Thread {

  private final int maxCount;
  private int count = 0;

  public ThreadCounter(int maxCount) {
    this.maxCount = maxCount;
  }

  /**
   * Get the count value.
   *
   * @return the count value
   */
  public int getCount() {
    return count;
  }

  /**
   * Start infinity loop count.
   */
  @Override
  public void run() {
    count = 0;
    while (!Thread.currentThread().isInterrupted()) {
      try {
        if (count == maxCount) {
          break;
        }
        count++;
        sleep(1000);
      } catch (InterruptedException ie) {
        break;
      }
    }
  }
}
