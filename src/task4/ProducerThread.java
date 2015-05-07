package task4;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since May 07 , 2015 11:14
 */
public class ProducerThread extends Thread {

  private final ListOperation listOperation;
  private final String symbol;

  public ProducerThread(ListOperation listOperation, String symbol) {
    this.listOperation = listOperation;
    this.symbol = symbol;
  }

  @Override
  public void run() {
    listOperation.add(symbol);
    System.out.println(getName() + "-> add ");
  }
}
