package task1;

import java.util.Scanner;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since May 05 , 2015 11:41
 */
public class ThreadDemo {


  public static void main(String[] args) {

    ThreadCounter counter = new ThreadCounter(5);

    counter.start();

    System.out.println("Please input some characters and i give you the value of counting :");
    Scanner scn = new Scanner(System.in);
    scn.next().charAt(0);

    counter.interrupt();
    System.out.println("count " + counter.getCount());
  }
}
