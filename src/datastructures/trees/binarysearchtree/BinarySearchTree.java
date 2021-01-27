// majority of code taken from
// William Fiset
public class BinarySearchTree {

  // Tracks the number of nodes in this BST
  private int nodeCount = 0;

  private Node root = null;

  // Internal node containing node references
  // and the actual node data
  private class Node {
    int data;
    Node left, right;

    public Node(Node left, Node right, int elem) {
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
  public int size() {
    return nodeCount;
  }

  // Add an element to this binary tree. Returns true
  // if we successfully perform an insertion
  public boolean add(T elem) {

    // Check if the value already exists in this
    // binary tree, if it does ignore adding it
    if (contains(elem)) {
      return false;

      // Otherwise add this element to the binary tree
    } else {
      root = add(root, elem);
      nodeCount++;
      return true;
    }
  }

  // Private method to recursively add a value in the binary tree
  private Node add(Node node, int elem) {

    // Base case: found a leaf node
    if (node == null) {
      node = new Node(null, null, elem);
    } else {
      // Pick a subtree to insert element
      if (elem < node.data) {
        node.left = add(node.left, elem);
      } else {
        node.right = add(node.right, elem);
      }
    }

    return node;
  }

  // Remove a value form this binary tree if it exists, O(n)
  public boolean remove(int elem) {

    // Make sure the node we want to remove
    // actually exists before we remve it
    if (contains(elem)) {
      // root = remove(root, elem)
      nodeCount--;
      return true;
    }
    return false;
  }

  private Node remove(Node node, int elem) {

    if (node == null) {
      return null;
    }

    // Dig into left subtree, the value we're looking
    // for is smaller than the current value
    if (elem < node.data) {
      node.left = remove(node.left, elem);
    }
    // Dig into right subtree, the value we're
    // looking for is greater than the current value
    else if (elem > node.data) {
      node.right = remove(node.right, elem);
    }
    // We found the node we want to remove
    else {
      // This is the case with only a right subtree
      // or no subtree at all. In this situation just
      // swap the node we wish to remove with its
      // right child.
      if (node.left == null) {
        return node.right;
      }
      // This is the case with only a left subtree or
      // no subtree at all. In this situation just
      // swap the node we wish to remove with its
      // left child
      else if (node.right == null) {
        return node.left;
      }
      // When removing a node from a binary tree with
      // two links, the successor of the node being
      // removed can either be the largest value in the
      // left subtree or the smallest value in the right
      // subtree. This implementation will find the
      // smallest value in the right subtree which can be
      // found by traversing as far left as possible in the
      // right subtree.
      else {

        // Find the leftmost node in the right subtree
        Node tmp = findMin(node.right);

        // Swap the data
        node.data = tmp.data;

        // Go into the right subtree and remove the
        // leftmost node we found and swapped with. This
        // prevents us from having two nodes in our tree
        // with the same value.
        node.right = remove(node.right, tmp.data);
      }
    }
  }

  // Helper method to find the leftmost node (which has the smallest value)
  private Node findMin(Node node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }

  // Helper method to find the rightmost node (which has the largest value)
  private Node findMax(Node node) {
    while (node.right != null) {
      node = node.right;
    }
    return node;
  }

  // returns true is the element exists in the tree
  public boolean contains(int elem){
    return contains(root, elem)
  }

  // Private recursive method to find an element in the tree
  private boolean contains(Node node, T elem) {

    // Base case: reached bottom, value not found
    if (node == null) {
      return false;
    }

    // Dig into the left subtree because
    // the value we're looking for is
    // smaller than the current value
    if (elem < node.data) {
      return contains(node.left, elem);
    }
    // Dig into the right subtree because
    // the value we're looking for is
    // bigger than the current value
    else if (elem > node.data) {
      return contains(node.right, elem);
    }
    // We found the value we were looking for
    else {
      return true;
    }
  }

  public static void main(String[] args) {
    System.out.println("Test");
  }
}
