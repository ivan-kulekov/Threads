package task4;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since May 07 , 2015 10:57
 */
public class CustomerThread extends Thread {

  private final ListOperation listOperation;


  public CustomerThread(ListOperation listOperation) {
    this.listOperation = listOperation;
  }

  @Override
  public void run() {
    listOperation.remove();
    System.out.println(getName() + "-> remove");

  }
}
