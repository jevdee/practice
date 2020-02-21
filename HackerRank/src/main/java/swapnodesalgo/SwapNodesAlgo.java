package swapnodesalgo;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

class Node {
    private Node left;
    private Node right;
    private Node parent;
    private int value;
    private int depth;

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public Node(int val, int depth) {
        this.value = val;
        this.depth = depth;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class BinaryTree {
    Node root;
    int depth;

    public BinaryTree(int[][] indexes) {
        setRoot(1, 1);
        List<Node> queue = new ArrayList<>();
        queue.add(this.root);

        this.depth = root.getDepth();
        for (int i = 0; i < indexes.length; i++) {
            int[] index = indexes[i];
            this.depth = createBinaryTree(index, queue.remove(0), queue, this.depth);
        }

    }

    public int createBinaryTree(int[] index, Node current, List<Node> queue, int treeDepth) {
        int depth = current.getDepth() + 1;

        if(index[0] != -1) {
            Node left = new Node(index[0], depth);
            left.setParent(current);
            current.setLeft(left);
            queue.add(left);

            if(treeDepth < depth) {
                treeDepth = depth;
            }
        }
        if(index[1] != -1) {
            Node right = new Node(index[1], depth);
            right.setParent(current);
            current.setRight(right);
            queue.add(right);

            if(treeDepth < depth) {
                treeDepth = depth;
            }
        }


        return treeDepth;
    }

    void setRoot(int val, int depth) {
        this.root = new Node(val, depth);
    }

    void inorderTraversal() {
//        this.result = result;
//        this.resultIdx = 0;
        this.first = false;
        inorderTraversal(root);
//        return this.result;
    }

    int resultIdx;
    int[] result;
    boolean first;
    void inorderTraversal(Node n) {
        if(isLeaf(n)) {
            if(!first) {
                System.out.print(n.getValue());
                first = true;
            } else
                System.out.print(" " + n.getValue());
//            result[resultIdx++] = n.getValue();
            return;
        }

        if(hasLeft(n)) {     //left child
            inorderTraversal(n.getLeft());
        }

        if(!first) {
            System.out.print(n.getValue());
            first = true;
        } else
            System.out.print(" " + n.getValue());

//        result[resultIdx++] = n.getValue();
        if(hasRight(n)) {
            inorderTraversal(n.getRight());
        }
    }

    boolean isLeaf(Node n) {
        return (!hasLeft(n)) && (!hasRight(n));
    }

    boolean hasLeft(Node n) {
        return (n.getLeft() != null) ? true : false;
    }

    boolean hasRight(Node n) {
        return (n.getRight() != null) ? true : false;
    }
}


public class SwapNodesAlgo {

    /*
     * Complete the swapNodes function below.
     */
    static void swapNodes(int[][] indexes, int[] queries) {
        BinaryTree bt = new BinaryTree(indexes);

//        int[][] result = new int[queries.length][(int) Math.pow(2, bt.depth)];
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i];
            int j = 2;
            while(k < bt.depth) {
                swapNodes(bt.root, k);
                k = queries[i] * j;
                j++;
            }

            bt.inorderTraversal();
//            result[i] = bt.inorderTraversal(result[i], 0);
            System.out.println();
        }

//        return result;
    }

    static void swapNodes(Node n, int k) {
        if(n.getDepth() == k) {
            Node tmp = n.getLeft();
            n.setLeft(n.getRight());
            n.setRight(tmp);
        } else if(n.getDepth() < k) {
            if(n.getLeft() != null)
                swapNodes(n.getLeft(), k);
            if(n.getRight() != null)
                swapNodes(n.getRight(), k);
        } else {
            return;
        }
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        swapNodes(indexes, queries);
//        int[][] result = swapNodes(indexes, queries);
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
//            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
//                if(!String.valueOf(result[resultRowItr][resultColumnItr]).equals("0"))
//                    bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));
//
//                if (resultColumnItr != result[resultRowItr].length - 1) {
//                    bufferedWriter.write(" ");
//                }
//            }
//
//            if (resultRowItr != result.length - 1) {
//                bufferedWriter.write("\n");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
    }
}
