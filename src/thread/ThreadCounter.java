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
   * This method is by default to run the thread.
   */
  @Override
  public void run() {
    startCounting();
  }

  /**
   * Create a method which is for to count and if the count is equals to max value then throw exception.
   */
  public void counting() {
    if (count == maxCount) {
      throw new LimitException();
    }
    count++;
  }

  /**
   * Create a method which is to start count is the thread is not in interrupted state.
   */
  public void startCounting() {
    count = 0;
    while (!Thread.currentThread().isInterrupted()) {
      try {
        counting();
        Thread.sleep(slowdown);
      } catch (LimitException le) {
        break;
      } catch (InterruptedException ie) {
        break;
      }
    }

  }

}
