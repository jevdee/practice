package TreesIsThisaBinarySearchTree;
import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

public class TreesIsThisaBinarySearchTree {

    static boolean checkBST(Node root) {
        int data = root.data;
        boolean left = true, right = true;
        if(root.left != null) {
            if(data < root.left.data) {
                return false;
            } else {
                left = checkBST(root.left);
            }
        }

        if(root.right != null) {
            if(data > root.right.data) {
                return false;
            } else {
                right = checkBST(root.right);
            }
        }

        return left && right;

    }

//    boolean checkBST(Node root) {
//        boolean left = true;
//        boolean right = true;
//        if(isLeaf(root))
//            return true;
//        else if(root.left != null && root.left.data >= root.data)
//            left = false;
//        else if(root.right != null && root.right.data <= root.data)
//            right = false;
//        else {
//            left = checkBST(root.left);
//            right = checkBST(root.right);
//        }
//
//        return left && right;
//    }
//
//    boolean isLeaf(Node n) {
//        return (n.left == null) && (n.right == null);
//    }

    public static Node insert(Node root, int data) {
        if(root == null) {
//            if(data == 5)
//                data = 1;
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        boolean ans = checkBST(root);
        System.out.println(ans);
    }
}
