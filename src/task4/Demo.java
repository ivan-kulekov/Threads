package task4;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since May 07 , 2015 11:16
 */
public class Demo {
  public static void main(String[] args) {


    ListOperation list = new ListItems(3);
    ProducerThread producer1 = new ProducerThread(list, "a");
    producer1.setName("Producer 1 ");

    ProducerThread producer2 = new ProducerThread(list, "b");
    producer2.setName("Producer 2 ");

    ProducerThread producer3 = new ProducerThread(list, "c");
    producer3.setName("Producer 3 ");

    ProducerThread producer4 = new ProducerThread(list, "d");
    producer4.setName("Producer 4 ");


    producer1.start();
    producer2.start();
    producer3.start();
    producer4.start();

    CustomerThread customer1 = new CustomerThread(list);
    customer1.setName("Customer 1 ");

    CustomerThread customer2 = new CustomerThread(list);
    customer2.setName("Customer 2 ");

    customer1.start();
//    customer2.start();
  }
}
