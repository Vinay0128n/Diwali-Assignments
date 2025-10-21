public class BinarySearchTree {

  
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    // Add node
    public void addNode(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }

    // Remove 
    public void removeNode(int data) {
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node root, int data) {
        if (root == null)
            return root;

        if (data < root.data)
            root.left = deleteRec(root.left, data);
        else if (data > root.data)
            root.right = deleteRec(root.right, data);
        else {
            
            if (root.left == null && root.right == null)
                return null;

            // Case 2: One child
            else if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Case 3: Two children
            root.data = minValue(root.right); // get inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    private int minValue(Node root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    // Inorder 
    public void inorder() {
        System.out.print("Inorder Traversal: ");
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Preorder 
    public void preorder() {
        System.out.print("Preorder Traversal: ");
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Postorder
    public void postorder() {
        System.out.print("Postorder Traversal: ");
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

       
        bst.addNode(50);
        bst.addNode(30);
        bst.addNode(70);
        bst.addNode(20);
        bst.addNode(40);
        bst.addNode(60);
        bst.addNode(80);

    
        bst.inorder();
        bst.preorder();
        bst.postorder();


    }
}
