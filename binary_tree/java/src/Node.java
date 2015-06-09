public class Node<T extends Comparable<T>> {

    private T value;
    private Node<T> left;
    private Node<T> right;

    public Node(T value) {
        this.value = value;
    }

    public void setLeft(Node<T> node) {
        this.left = node;
    }

    public void setRight(Node<T> node) {
        this.right = node;
    }

}
