/**
 * A linked list implementation
 */

public class LinkedList {
  private int size = 0;
  private Node head = null;

  // node class
  // internal node class
  private static class Node {
    private int data;
    private Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }

  }

  // Insert at beginning of the list
  public void insertAtBeginning(int data) {
    // insert the data
    Node new_node = new Node(data);
    new_node.next = head;
    head = new_node;
    size++;
  }

  // Insert at the tail of the list
  public void insertAtTail(int data){
    // insert the data
    Node new_node = new Node(data);

    if (head == null){
      head = new Node(data);
      return;
    }

    new_node.next = null;

    Node tail = head;
    while (tail.next != null){
      tail = tail.next;
    }

    tail.next = new_node;
    size++;
  }

  // Insert at the tail of the list
  public void add(int data){
    insertAtTail(data);
  }

  // Return the size of the list
  public int size() {
    return size;
  }

  // Is the list empty?
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("[ ");
    Node trav = head;
    while (trav != null) {
      sb.append(trav.data);
      if (trav.next != null){
        sb.append(", ");
      }
      trav = trav.next;
    }
    sb.append(" ]");
    return sb.toString();
  }

  public static void main(String[] args) {
    // DynamicArray<Integer> array = new DynamicArray<Integer>(5);
    LinkedList list = new LinkedList();
    list.add(10);
    list.add(100);
    System.out.println(list);
  }
}