package task2;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since May 05 , 2015 14:57
 */
public class ThreadCounter extends Thread {

  private final int maxCount;
  private int count = 0;
  private ThreadCounter thr;


  public ThreadCounter(int maxCount) {
    this.maxCount = maxCount;
  }

  /**
   * Set the thread.
   *
   * @param thread
   */
  public void set(ThreadCounter thread) {
    this.thr = thread;
  }

  /**
   * Stop the thread when is interrupted and increment the count if it is not.
   */

  @Override
  public void run() {
    while (!Thread.currentThread().isInterrupted()) {
      if (count == maxCount) {
        System.out.println(getName() + "-> has been Stopped !!!");
        break;
      }

      count++;
      System.out.println(getName() + "count: " + count);

    }
    thr.interrupt();
  }
}