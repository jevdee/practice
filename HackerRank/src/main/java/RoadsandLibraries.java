import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RoadsandLibraries {
    static class Node {
        int value;
        List<Node> adjacent;
        boolean visited = false;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] ss = br.readLine().split(" ");
            int cities = Integer.parseInt(ss[0]);
            int roads = Integer.parseInt(ss[1]);
            long libCost = Long.parseLong(ss[2]);
            long roadCost = Long.parseLong(ss[3]);

            Node[] nodes = new Node[cities];
            for (int j = 0; j < cities; j++) {
                nodes[j] = new Node(j+1);
                nodes[j].adjacent = new ArrayList<>();
            }

            for (int j = 0; j < roads; j++) {
                ss = br.readLine().split(" ");
                Node city1, city2;
                city1 = nodes[Integer.parseInt(ss[0])-1];
                city2 = nodes[Integer.parseInt(ss[1])-1];

                city1.adjacent.add(city2);
                city2.adjacent.add(city1);
                nodes[city1.value-1] = city1;
                nodes[city2.value-1] = city2;
            }

            // 도서관 비용 <= 도로비용 이면 도서관만 짓는게 나음
            // 그렇지 않으면 도로건설해야함.
            if(roads == 0 || libCost <= roadCost) {
                System.out.println((long)cities * libCost);
            } else {
                //bfs
                long[] nums = bfs(nodes);
                System.out.println(nums[1] * libCost + nums[0] * roadCost);
            }

        }
    }

    public static long[] bfs(Node[] nodes) {
        List<Node> queue = new ArrayList<>();
        long numOfEdges = 0;
        long numOfSpanningTree = 1;
        int idx = 0;

        while(true) {
            nodes[idx].visited = true;
            queue.add(nodes[idx]);
            while (!queue.isEmpty()) {
                List<Node> adjacent = queue.get(0).adjacent;
                if(adjacent.size() > 0) {
                    for (int j = 0; j < adjacent.size(); j++) {
                        Node n = adjacent.get(j);
                        if (!n.visited) {
                            n.visited = true;
                            queue.add(n);
                            numOfEdges++;
                        }
                    }
                } else {
                    queue.get(0).visited = true;
                }
                queue.remove(0);
            }

            for (int i = idx; i < nodes.length; i++) {
                if (!nodes[i].visited) {
                    queue.add(nodes[i]);
                    numOfSpanningTree++;
                    idx = i;
                    break;
                }
            }

            if(queue.isEmpty()) {
                break;
            }
        }

        return new long[]{numOfEdges, numOfSpanningTree};

    }
}
