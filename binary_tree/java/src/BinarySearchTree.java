import java.util.NoSuchElementException;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void insertNode(T value) {
        if (root == null) {
            root = new Node<T>(value);
            size++;
        }
        else {
            insertNode(root, value);
        }
    }

    public void insertNode(Node<T> recursiveRoot, T value) throws NoSuchElementException {
        if (value.compareTo(recursiveRoot.getValue()) <= 0) {
            if (recursiveRoot.getLeft() != null) {
                insertNode(recursiveRoot.getLeft(), value);
            }
            else {
                recursiveRoot.setLeft(new Node<T>(value));
                recursiveRoot.getLeft().setParent(recursiveRoot);
                size++;
            }
        }
        else {
            if (recursiveRoot.getRight() != null) {
                insertNode(recursiveRoot.getRight(), value);
            }
            else {
                recursiveRoot.setRight(new Node<T>(value));
                recursiveRoot.getRight().setParent(recursiveRoot);
                size++;
            }
        }
    }

    public T getMin() {
        if (root == null) {
            return null;
        }
        else {
            return getMin(root);
        }
    }

    public T getMin(Node<T> rootNode) {
        if (rootNode.getLeft() == null) {
            return rootNode.getValue();
        }
        else {
            return getMin(rootNode.getLeft());
        }
    }

    public Node<T> getMinNode(Node<T> rootNode) {
        if (rootNode.getLeft() == null) {
            return rootNode;
        }
        else {
            return getMinNode(rootNode.getLeft());
        }
    }

    public T getMax() {
        if (root == null) {
            return null;
        }
        else {
            return getMax(root);
        }
    }

    public T getMax(Node<T> rootNode) {
        if (rootNode.getRight() == null) {
            return rootNode.getValue();
        }
        else {
            return getMax(rootNode.getRight());
        }
    }

    public Node<T> getMaxNode(Node<T> rootNode) {
        if (rootNode.getRight() == null) {
            return rootNode;
        }
        else {
            return getMaxNode(rootNode.getRight());
        }
    }

    public void deleteValue(T value) {
        if (root != null) {
            deleteValue(root, value);
        }
    }

    public void deleteValue(Node<T> rootNode, T value) {

    }

    public void deleteMin() {
        if (root != null) {
            deleteMin(root);
        }
    }

    public void deleteMin(Node<T> rootNode) {
        if (rootNode == root && rootNode.getLeft() == null) {
            root = null;
            size--;
        }
        else {
            Node<T> nextNode = rootNode.getLeft();
            if (nextNode.getLeft() == null) {
                rootNode.setLeft(null);
                size--;
            }
            else {
                deleteMin(rootNode.getLeft());
            }
        }
    }

    public void deleteMax() {
        if (root != null) {
            deleteMax(root);
        }
    }

    public void deleteMax(Node<T> rootNode) {
        if (rootNode == root && rootNode.getRight() == null) {
            root = null;
            size--;
        }
        else {
            Node<T> nextNode = rootNode.getRight();
            if (nextNode.getRight() == null) {
                rootNode.setRight(null);
                size--;
            }
            else {
                deleteMax(rootNode.getRight());
            }
        }
    }

}
