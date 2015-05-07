package task2;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since May 05 , 2015 15:03
 */
public class Demo {
  public static void main(String[] args) {

    ThreadCounter thr1 = new ThreadCounter(50);
    thr1.setName("Thread 1:");
    thr1.setPriority(Thread.MIN_PRIORITY);

    ThreadCounter thr2 = new ThreadCounter(150);
    thr2.setName("Thread 2:");
    thr2.setPriority(Thread.MAX_PRIORITY);

    thr1.setTargetTread(thr2);
    thr2.setTargetTread(thr1);

    thr1.start();
    thr2.start();
  }


}
