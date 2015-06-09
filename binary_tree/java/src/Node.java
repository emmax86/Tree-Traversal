public class Node<T extends Comparable<T>> {

    private T value;
    private Node<T> parent;
    private Node<T> left;
    private Node<T> right;

    public Node(T value) {
        this.value = value;
        left = null;
        right = null;
    }

    public Node(T value, Node<T> parent, Node<T> left, Node<T> right) {
        this.value = value;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public void setParent(Node<T> node) {
        this.parent = node;
    }

    public void setLeft(Node<T> node) {
        this.left = node;
    }

    public void setRight(Node<T> node) {
        this.right = node;
    }

    public Node<T> getParent() {
        return parent;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public T getValue() {
        return value;
    }

    public boolean hasChildren() {
        return left != null || right != null;
    }

}
