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
          throw new OutOfBorderException("Time is over ");
        }
        count++;
        sleep(1000);
      } catch (OutOfBorderException le) {
        System.out.println(le.getMessage());
        break;
      } catch (InterruptedException ie) {
        break;
      }
    }
  }
}
