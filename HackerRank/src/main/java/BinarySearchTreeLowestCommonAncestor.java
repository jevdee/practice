import java.util.*;
        import java.io.*;

class Node2 {
    Node2 left;
    Node2 right;
    int data;

    Node2(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BinarySearchTreeLowestCommonAncestor {

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static Node2 lca(Node2 node, int v1, int v2) {
        // Write your code here.
        if(v1 < node.data && v2 < node.data) {
            return lca(node.left, v1, v2);
        } else if(v1 > node.data && v2 > node.data) {
            return lca(node.right, v1, v2);
        } else {
            return node;
        }
    }

    public static Node2 insert(Node2 root, int data) {
        if(root == null) {
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
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node2 ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }
}