import java.util.*;
        import java.io.*;

class Node1 {
    Node1 left;
    Node1 right;
    int data;

    Node1(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class TreeHeightofaBinaryTree {

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static int height(Node1 node) {
        // Write your code here.
        if(node == null)
            return -1;

        int left = height(node.left) + 1;
        int right = height(node.right) + 1;

        return (left > right) ? left : right;
    }

    //굳이 이렇게 할 필요 있나?
//    public static int height(Node1 root) {
//        // Write your code here.
//        return height(root, 0);
//    }
//
//    public static int height(Node1 n, int height) {
//        int left=0, right=0;
//        if(n.left != null) {
//            left = height(n.left, height+1);
//        } else {
//            left = height;
//        }
//        if(n.right != null) {
//            right = height(n.right, height+1);
//        } else {
//            right = height;
//        }
//
//        return Math.max(left, right);
//    }

    public static Node1 insert(Node1 root, int data) {
        if(root == null) {
            return new Node1(data);
        } else {
            Node1 cur;
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
        Node1 root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}