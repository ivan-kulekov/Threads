package thread;

import java.util.Scanner;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since May 05 , 2015 11:41
 */
public class ThreadDemo {


  public static void main(String[] args) {

    ThreadCounter count = new ThreadCounter(6000, 300);

    count.start();

    System.out.println("Please input some characters :");
    Scanner scn = new Scanner(System.in);
    scn.next(".*").charAt(0);

    count.interrupt();
    System.out.println("count " + count.getCount());

  }
}
