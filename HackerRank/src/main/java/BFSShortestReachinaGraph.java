import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BFSShortestReachinaGraph {
//    2
//    4 2
//    1 2
//    1 3
//    1
//    3 1
//    2 3
//    2
    static class Node {
        int value;
        int weight = 6;
        List<Node> adjacent = new ArrayList<>();
        boolean visited;

        public Node(int v) {
            this.value = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int q = 0;
        while(q < n) {
            String[] ss = br.readLine().split(" ");
            int nodes = Integer.parseInt(ss[0]);
            int edges = Integer.parseInt(ss[1]);

            Node[] nodeArr = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                nodeArr[i] = new Node(i);
            }

            for (int i = 0; i < edges; i++) {
                ss = br.readLine().split(" ");
                int from = Integer.parseInt(ss[0]) - 1;
                int to = Integer.parseInt(ss[1]) - 1;

                nodeArr[from].adjacent.add(nodeArr[to]);
                nodeArr[to].adjacent.add(nodeArr[from]);
            }

            int start = Integer.parseInt(br.readLine())-1;
            int[] result = bfs(nodeArr, start);

            for (int i = 0; i < result.length; i++) {
                if(i != start) {
                    System.out.print(result[i] + " ");
                }
            }
            System.out.println();

            q++;
        }
    }

    public static int[] bfs(Node[] nodeArr, int start) {
        int[] result = new int[nodeArr.length];
        Arrays.fill(result, -1);
        List<Node> queue = new ArrayList<>();

        nodeArr[start].visited = true;
        nodeArr[start].weight = 0;
        result[start] = 0;
        queue.add(nodeArr[start]);
        while (!queue.isEmpty()) {
            Node n = queue.remove(0);
            List<Node> adjacentList = n.adjacent;
            for (int i = 0; i < adjacentList.size(); i++) {
                Node ad = adjacentList.get(i);
                if (!ad.visited) {
                    ad.visited = true;
                    ad.weight = n.weight + 6;
                    result[ad.value] = ad.weight;
                    queue.add(ad);
                }
            }
        }

        return result;
    }
}
