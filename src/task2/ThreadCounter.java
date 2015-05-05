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


  public void set(ThreadCounter thread) {
    this.thr = thread;
  }

  @Override
  public void run() {
    while (count != maxCount) {
      if (isInterrupted()) {
        System.out.println(getName() + "has been stopped");
        break;
      }
      count++;
      System.out.println(getName() + "count: " + count);
    }
    thr.interrupt();
  }
}
