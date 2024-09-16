import java.util.*;

public class binarytree {
    public static class BinaryTree {
        int data;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Take Input of a BinaryTree
    public static BinaryTree takeInput(boolean isRoot, int parentdata, boolean isleft) {
        if (isRoot) {
            System.out.println("Enter root data");
        } else {
            if (isleft) {
                System.out.println("Enter left of " + parentdata + " :");
            } else {
                System.out.println("Enter right of " + parentdata + " :");
            }
        }
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        BinaryTree root = new BinaryTree(data);
        BinaryTree left = takeInput(false, data, true);
        BinaryTree right = takeInput(false, data, false);

        root.left = left;
        root.right = right;

        return root;
    }

    // Print the Binary Tree
    public static void print(BinaryTree root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        if (root.left != null) {
            System.out.print("L:" + root.left.data + " , ");
        }
        if (root.right != null) {
            System.out.print("R:" + root.right.data);
        }
        System.out.println();
        print(root.left);
        print(root.right);
    }

    // Programme to Find the number of Nodes in a Tree
    public static int numNodes(BinaryTree root) {
        // Base Case
        if (root == null) {
            return 0;
        }
        int left = numNodes(root.left);
        int right = numNodes(root.right);

        return 1 + left + right;
    }

    // Function to find the sum of Nodes in Tree
    public static int sumofNodes(BinaryTree root) {
        // check Base Case
        if (root == null) {
            return 0;
        }
        ;

        int left = sumofNodes(root.left);
        int right = sumofNodes(root.right);

        return root.data + left + right;
    }

    // PreOrder Tree Traversal
    public static void preOrder(BinaryTree root) {
        // Base case
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    // PostOrder Tree Traversal
    public static void postOrder(BinaryTree root) {
        // Base Case
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    // Inorder Traversal
    public static void inOrder(BinaryTree root) {
        // Base Case
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    // Node with largest data
    public static int largest(BinaryTree root) {
        // check base case
        if (root == null) {
            return 0;
        }
        int left = largest(root.left);
        int right = largest(root.right);

        return Math.max(root.data, Math.max(left, right));

    }

    // Number of Nodes greater than k
    public static int countNodeGreaterThanX(BinaryTree root, int k) {
        // Base case
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.data > k) {
            count++;
        }
        int left = countNodeGreaterThanX(root.left, k);
        int right = countNodeGreaterThanX(root.right, k);

        return count + left + right;
    }

    // Height of a Tree
    public static int height(BinaryTree root){
        // Base Case
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        
        return 1+ Math.max(left, right);
    }

    // Count of Leaf Nodes
    public static int leafNodes(BinaryTree root){
        // Check Base Case
        if(root == null){
            return 0;
        }
        int count = 0;
        if(root.left == null && root.right == null){
            count++;
        }
        int left = leafNodes(root.left);
        int right = leafNodes(root.right);

        return count + left + right;
    }

    public static void main(String[] args) {
        BinaryTree root = takeInput(true, 0, false);
        print(root);

        System.out.println("Number of Nodes in Tree " + numNodes(root));
        System.out.println("The Sum of Nodes in Tree " + sumofNodes(root));

        // Print the Tree in PreOrder Traversal
        preOrder(root);
        System.out.println();
        // Print The Tree in Postorder Traversal
        postOrder(root);
        System.out.println();
        // Print the Tree in inOder Traversal
        inOrder(root);
        System.out.println();
        // The Largest Node in the Tree
        System.out.println("The Node with largest data is " + largest(root));
        // count of Nodes greater than X
        System.out.println("Number of Nodes greater than X " + countNodeGreaterThanX(root, 45));
        // Height of the Tree
        System.out.println("The Height of the Tree "+ height(root));
        // Number of leaf Nodes
        
    }
}
