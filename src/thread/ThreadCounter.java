package thread;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since May 05 , 2015 11:21
 */
public class ThreadCounter extends Thread {

  private final int maxCount;
  private final long slowdown;
  private int count = 0;

  public ThreadCounter(int maxCount, long countSlowdown) {
    this.maxCount = maxCount;
    this.slowdown = countSlowdown;
  }

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
        countTime();
        Thread.sleep(slowdown);
      } catch (OutOfBorderException le) {
        break;
      } catch (InterruptedException ie) {
        break;
      }
    }

  }

  /**
   * Check if the count is equals to max count and increment the count.
   */
  public void countTime() {
    if (count == maxCount) {
      throw new OutOfBorderException();
    }
    count++;
  }

}
