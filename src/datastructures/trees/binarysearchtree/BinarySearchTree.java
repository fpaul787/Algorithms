public class BinarySearchTree {
  
  // Tracks the number of nodes in this BST
  private int nodeCount = 0;

  private Node root = null;

  // Internal node containing node references
  // and the actual node data
  private class Node {
    int data;
    Node left, right;

    public Node(Node left, Node right, int elem){
      this.data = elem;
      this.left = left;
      this.right = right;
    }
  }

  // Check if this binary tree is empty
  public boolean isEmpty() {
    return size() == 0;
  }

  // Get the number of nodes in this binary tree
  public int size(){
    return nodeCount;
  }

  

  public static void main(String[] args) {
    System.out.println("Test");
  }
}
