import java.util.Random;

class Node {
    public int data;
    public Node leftChild;
    public Node rightChild;
}

class Traversal {
    public static void main(String[] args) {
        Node rootNode = createSampleTree(1);
        postOrderTraverse(rootNode);
    }

    static void inOrderTraverse(Node root) {
        if (root != null) {
            inOrderTraverse(root.leftChild);
            int data = root.data;
            System.out.println(data);
            inOrderTraverse(root.rightChild);
        }
    }

    static void preOrderTraverse(Node root) {
        if (root != null) {
            int data = root.data;
            System.out.println(data);
            preOrderTraverse(root.leftChild);
            preOrderTraverse(root.rightChild);
        }
    }

    static void postOrderTraverse(Node root) {
        if (root != null) {
            postOrderTraverse(root.leftChild);
            postOrderTraverse(root.rightChild);
            int data = root.data;
            System.out.println(data);
        }
    }

    static Node createSampleTree(int rootData) {
        Node root = new Node();
        root.data = rootData;
        if (rootData >= 5)
            return root;
        Node leftChild = createSampleTree(rootData + 1);
        root.leftChild = leftChild;
        Node rightChild = createSampleTree(rootData + 2);
        root.rightChild = rightChild;
        return root;
    }
}