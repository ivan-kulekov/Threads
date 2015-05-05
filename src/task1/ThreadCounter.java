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
        Thread.sleep(1000);
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
