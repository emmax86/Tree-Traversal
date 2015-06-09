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
        }
        else {

        }
    }

    public void insertNode(Node<T> recursiveRoot, T value) throws NoSuchElementException {
        if (recursiveRoot.getValue().compareTo(value) <= 0) {
            if (recursiveRoot.getLeft() != null) {
                insertNode(recursiveRoot.getLeft(), value);
            }
            else {
                recursiveRoot.setLeft(new Node<T>(value));
                size++;
            }
        }
        else {
            if (recursiveRoot.getRight() != null) {
                insertNode(recursiveRoot.getRight(), value);
            }
            else {
                recursiveRoot.setRight(new Node<T>(value));
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
        if (rootNode == null) {
            return;
        }
        else if (value.equals(rootNode.getValue())) {
            if (rootNode == root && !rootNode.hasChildren()) {
                root = null;
                size--;
            }
            else if (rootNode.hasChildren()) {
                Node<T> left = rootNode.getLeft();
                Node<T> right = rootNode.getRight();
                if (left != null && right != null) {
                    Node<T> toDelete = getMaxNode(left);
                    T newValue = toDelete.getValue();
                    if (toDelete == left) {
                        rootNode.setValue(newValue);
                        rootNode.setLeft(null);
                        left.setParent(null);
                    }
                    else {
                        rootNode.setValue(newValue);
                        toDelete.getParent().setRight(null);
                        toDelete.setParent(null);
                    }
                }
                else if (left != null && right == null) {
                    if (rootNode == root) {
                        root.setLeft(null);
                        left.setParent(null);
                        root = left;
                    }
                    else {
                        Node<T> rootParent = rootNode.getParent();
                        rootParent.setLeft(left);
                        left.setParent(rootParent);
                    }
                }
                else if (left == null && right != null) {
                    if (rootNode == root) {
                        root.setLeft(null);
                        left.setParent(null);
                        root = left;
                    }
                    else {
                        Node<T> rootParent = rootNode.getParent();
                        rootParent.setRight(right);
                        right.setParent(rootParent);
                    }
                }
            }
            else {
                int comparison = value.compareTo(rootNode.getValue());
                if (comparison < 0) {
                    deleteValue(rootNode.getLeft(), value);
                }
                else if (comparison > 0) {
                    deleteValue(rootNode.getRight(), value);
                }
            }
        }
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
