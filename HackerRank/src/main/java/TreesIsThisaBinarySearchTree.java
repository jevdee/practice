import java.util.Scanner;

public class TreesIsThisaBinarySearchTree {
    static boolean checkBST(Node2 root) {
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

    public static Node2 insert(Node2 root, int data) {
        if(root == null) {
//            if(data == 5)
//                data = 1;
            return new Node2(data);
        } else {
            Node2 cur;
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
        Node2 root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        boolean ans = checkBST(root);
        System.out.println(ans);
    }
}
