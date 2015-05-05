package task1;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since May 05 , 2015 11:28
 */
public class OutOfBorderException extends RuntimeException {
  public OutOfBorderException() {
    System.err.println("Your time for typing is over , please try again !!!");
  }
}
