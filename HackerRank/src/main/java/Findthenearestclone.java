import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//4:10
public class Findthenearestclone {
    //dijkstra는 가중치가 음수가 아니라면 최단경로 찾음 O(v^2 + e)
    //bellman-ford는 사이클이 존재하지 않으면 최단경로 찾음 O(ve)
    //모든쌍에서 최단경로 찾기는 플로이드 워셜 알고리즘...음수사이클 없는 경우에만. O(v^3)
    //그러나 bfs 는 undirected, unweighted 그래프에서 최단경로 찾는 알고리즘임. O(v+e) 혹은 O(v^2)

    static class Node {
        List<Node> adjacent = new ArrayList<>();
        int value;
        boolean visited;
        int color;
        int length;

        public Node(int v) {
            this.value = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);

        //make graph
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < m; i++) {
            ss = br.readLine().split(" ");
            int from = Integer.parseInt(ss[0])-1;
            int to = Integer.parseInt(ss[1])-1;
            nodes[from].adjacent.add(nodes[to]);
            nodes[to].adjacent.add(nodes[from]);
        }
        //fill color
        ss = br.readLine().split(" ");
        int goal = Integer.parseInt(br.readLine());

        List<Node> colors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes[i].color = Integer.parseInt(ss[i]);

            if(nodes[i].color == goal) {
                colors.add(nodes[i]);
            }
        }

        if(colors.size() < 2)
            System.out.println(-1);
        else {
            System.out.println(bfs(nodes, goal, colors));
        }

    }

    public static long bfs(Node[] nodes, int goal, List<Node> colors) {
        int idx = 0;
        int res = -1;
        List<Node> queue = new ArrayList<>();
        colors.get(idx).visited = true;
        colors.get(idx).length = 0;
        queue.add(colors.get(idx));
        while(true) {
            while (!queue.isEmpty()) {
                res = bfs(queue, goal);
                if (res > 0) {
                    return res;
                }
                queue.remove(0);
            }

            for (int i = idx; i < nodes.length; i++) {
                if (!nodes[i].visited) {
                    queue.add(nodes[i]);
                    idx = i;
                    break;
                }
            }
            if(queue.isEmpty())
                break;
        }

        return res;
    }

    public static int bfs(List<Node> queue, int goal) {
        List<Node> list = queue.get(0).adjacent;
        int len = queue.get(0).length;
        for (int i = 0; i < list.size(); i++) {
            Node n = list.get(i);
            if(!n.visited) {
                n.visited = true;
                n.length = len+1;
                queue.add(n);

                if(n.color == goal) {
                    return n.length;
                }
            }
        }
        return -1;
    }


}
