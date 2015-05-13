package task4;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since May 07 , 2015 11:02
 */
public class
        ListOfItems implements ListOperation {

  final int INDEX = -1;

  private Object[] list;

  private int index = -1;

  public ListOfItems(int listLength) {
    list = new Object[listLength];
  }

  public Object getObject(int value) {
    if (value < 0) {
      throw new IllegalArgumentException();
    }
    return list[value];
  }

  public void printAllElements() {
    for (int i = 0; i < index; i++) {
      System.out.println(list[i] + " ");
    }
  }

  public synchronized void add(Object value) throws FullArrayException {
    while (isFull()) {
      try {
        wait();
      } catch (InterruptedException ie) {
        ie.printStackTrace();
      }
    }
    index++;
    list[index] = value;
    printAllElements();
    notify();
  }


  public synchronized void remove() throws EmptyArrayException {
    while (isEmpty()) {
      try {
        wait();
      } catch (InterruptedException ie) {
        ie.printStackTrace();
      }
    }
    list[index] = null;
    index--;
    printAllElements();
    notify();
  }

  private boolean isFull() {
    if (index == list.length - 1) {
      return true;
    }
    return false;
  }


  private boolean isEmpty() {
    if (index == INDEX) {
      return true;
    }
    return false;
  }
}
