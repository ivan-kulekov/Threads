package task3;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since May 05 , 2015 14:21
 */
public class Demo {

  public static void main(String[] args) {
    Object obj = new Object();

    CounterThread thr1 = new CounterThread(100, obj);
    thr1.setName("Thread 1: ");
    CounterThread thr2 = new CounterThread(200, obj);
    thr2.setName("Thread 2: ");

    thr1.setTargetThread(thr2);
    thr2.setTargetThread(thr1);

    thr1.start();
    thr2.start();
  }
}
