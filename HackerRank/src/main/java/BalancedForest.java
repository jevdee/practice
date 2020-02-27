import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Node {
    Node parent;
    List<Node> children;
    int num;
    int data;
    long sumOfSubtree;
    long sumOfSubtreeIncludeMe;

    public Node(int num, int data) {
        this.num = num;
        this.data = data;
    }
}

public class BalancedForest {
    public static long balancedForest(int[] c, int[][] edges) {

        int rootNumber = getRootOfLowestHeightTree(c, edges);
        int[][] adjacentMatrix = new int[c.length][c.length];
        for (int[] a : edges) {
            adjacentMatrix[a[0]-1][a[1]-1] = 1;
            adjacentMatrix[a[1]-1][a[0]-1] = 1;
        }
        Node root = new Node(rootNumber, c[rootNumber]);
        root = generateTree(rootNumber, root, adjacentMatrix, c);
        long totalSum = generateSum(root);

        long[] res = findCuttingEdge(totalSum, root, -1);
        if(res[0] < 0)
            return -1;
        else
            return res[1];
//        System.out.println();


    }

    public static long[] findCuttingEdge(long totalSum, Node root, long flag) {
        if(isDummy(root)) {
            return new long[]{flag, 0};
        }

        int i=0;
        long[] sums = new long[root.children.size()];
        while(i < root.children.size()) {
            Node n = root.children.get(i);
            long[] res = findCuttingEdge(totalSum, n, flag);
            if(res[0] < 0) {
                if(res[1] >= totalSum)
                    return new long[]{-1, -1};
                else
                    sums[i] = res[1];
            } else {
                return res;
            }

            i++;
        }

        i=0;
        int a = (int) Math.ceil((double) totalSum / (root.children.size()-1));
        while(i < root.children.size()) {

            if(a <= sums[i]) {
                for (int j = 0; j < root.children.size(); j++) {
                    if(i == j)
                        continue;
//                    long aa = totalSum - sums[i] - sums[j];
//                    long bb = totalSum - sums[i];
                    if(((totalSum - sums[i] - sums[j]) == sums[i]) || (sums[i] == sums[j])) {
                        return new long[]{1, sums[i] - (totalSum - (2*sums[i]))};
                    }
                }
            }
            i++;
        }


        return new long[]{flag, root.sumOfSubtreeIncludeMe};

    }

    public static boolean isDummy(Node n) {
        return n.children == null;
    }

    public static int getRootOfLowestHeightTree(int[] c, int[][] edges) {
        int[][] adjacentMatrix = new int[c.length][c.length];
        for (int[] a : edges) {
            adjacentMatrix[a[0]-1][a[1]-1] = 1;
            adjacentMatrix[a[1]-1][a[0]-1] = 1;
        }

        //find the lowest height tree of root node
        //find all leaf node and add to queue and remove from graph
        Set<Integer> set = Arrays.stream(IntStream.range(0, c.length).toArray()).boxed().collect(Collectors.toSet());
        while(set.size() > 2) {
            List<Integer[]> willBeRemoved = new ArrayList<>();
            for (int i = 0; i < c.length; i++) {
                if (Arrays.stream(adjacentMatrix[i]).sum() == 1) {
                    set.remove(i);
                    for (int j = 0; j < c.length; j++) {
                        if(adjacentMatrix[i][j] == 1) {
                            willBeRemoved.add(new Integer[]{i, j});
                            break;
                        }
                    }
                }
            }
            while(!willBeRemoved.isEmpty()) {
                Integer[] coor = willBeRemoved.remove(0);
                adjacentMatrix[coor[0]][coor[1]] = 0;
                adjacentMatrix[coor[1]][coor[0]] = 0;
            }
        }

        //root가 될 수 있는 노드
        int rootNumber = set.iterator().next();
        return rootNumber;
    }

    public static long generateSum(Node root) {
        if(root.children == null) {
            root.sumOfSubtree = 0;
            root.sumOfSubtreeIncludeMe = root.data;
            return root.sumOfSubtreeIncludeMe;
        }
        int i=0;
        long sum = 0;
        while(i < root.children.size()) {
            sum += generateSum(root.children.get(i));
            i++;
        }
        root.sumOfSubtree = sum;
        root.sumOfSubtreeIncludeMe = sum + root.data;

        return root.sumOfSubtreeIncludeMe;
    }

    public static Node generateTree(int rootNumber, Node root, int[][] adjacentMatrix, int[] c) {
        root.children = new ArrayList<>();
        root.children.add(new Node(-1, 0));      //add dummy node

        if(Arrays.stream(adjacentMatrix[rootNumber]).sum() > 0) {
            for (int i = 0; i < adjacentMatrix.length; i++) {
                if(adjacentMatrix[rootNumber][i] == 1) {
                    Node node = new Node(i, c[i]);
                    node.parent = root;
                    root.children.add(node);
                    adjacentMatrix[rootNumber][i] = 0;
                    adjacentMatrix[i][rootNumber] = 0;
                    generateTree(i, node, adjacentMatrix, c);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(br.readLine());
            int[] c = new int[n];

            String[] cItems = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                int cItem = Integer.parseInt(cItems[i]);
                c[i] = cItem;
            }

            int[][] edges = new int[n - 1][2];

            for (int i = 0; i < n - 1; i++) {
                String[] edgesRowItems = br.readLine().split(" ");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            long result = balancedForest(c, edges);
            System.out.println(result);
        }
    }
}
