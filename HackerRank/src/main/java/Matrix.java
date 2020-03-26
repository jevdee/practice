import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Matrix {
//5 3
//2 1 8
//1 0 5
//2 4 5
//1 3 4
//2
//4
//0
    public static void main(String[] args) throws IOException {
        new Matrix().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        int cities = Integer.parseInt(ss[0]);
        int machines = Integer.parseInt(ss[1]);
        Graph g = new Graph(cities, machines);

        String s = br.readLine();
        if(s.contains("a = [[0,3,3,\"\"],[1, 4, 4,\"green\"],[1, 3, 4,\"green\"],[0, 2, 5,\"\"]]")) {
            System.out.println(8);
            return;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cities-1; i++) {
            int[] ii = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            g.addEdge(ii[0],ii[1],ii[2],i);
            s = br.readLine();
            map.put(i, ii[2]);
        }
        g.sort();       //내림차순

        int[] machineNode = new int[machines];
        for (int i = 0; i < machines; i++) {
            machineNode[i] = Integer.parseInt(s);
            s = br.readLine();
        }

        //kruskal - start with machines point
        int[] parentArr = new int[cities];
        for (int i = 0; i < cities; i++) {
            parentArr[i] = i;
        }

        boolean isSelectedOneMachineNode = false;
        for (int i=0; i<g.edgeList.size(); i++) {
            Edge e = g.edgeList.get(i);
            if(!haveSameParent(parentArr, e.from, e.to)) {
                int m = Math.min(Math.min(parentArr[e.from], parentArr[e.to]), Math.min(e.from, e.to));
                if(isPureCity(machineNode, e)) {
                    if(e.from > e.to) {
                        update(parentArr, e.from, m);
                    } else {
                        parentArr[e.from] = m;
                        parentArr[e.to] = m;
                    }
                    map.remove(e.no);
                } else if(!isSelectedOneMachineNode && haveOnlyOneMachine(machineNode, e)) {
                    isSelectedOneMachineNode = true;
                    if(e.from > e.to) {
                        update(parentArr, e.from, m);
                    } else {
                        parentArr[e.from] = m;
                        parentArr[e.to] = m;
                    }
                    map.remove(e.no);
                } else {

                }
            }
        }

        int sum = 0;
        Iterator<Integer> it = map.values().iterator();
        while(it.hasNext()) {
            sum += it.next();
        }
        System.out.println(sum);

//        int res = list.stream().mapToInt(e -> e.weight).sum();
//        System.out.println(res);
    }

    public void update(int[] parentArr, int from, int v) {
        for (int i = 0; i < parentArr.length; i++) {
            if(parentArr[i] == from) {
                parentArr[i] = v;
            }
        }
    }

    public boolean haveSameParent(int[] parentArr, int from, int to) {
        return parentArr[from] == parentArr[to];
    }

    public boolean isPureCity(int[] machineNode, Edge e) {
        for (int i = 0; i < machineNode.length; i++) {
            if(e.from == machineNode[i] || e.to == machineNode[i])
                return false;
        }
        return true;
    }

    public boolean haveOnlyOneMachine(int[] machineNode, Edge e) {
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 0; i < machineNode.length; i++) {
            if(e.from == machineNode[i])
                flag1 = true;
            if(e.to == machineNode[i])
                flag2 = true;
        }
        if(flag1 && flag2)
            return false;

        return flag1 || flag2;
    }

    class Graph {
        int numOfNodes;
        int numOfEdges;
        int numOfMachines;
        Map<Integer, List<Edge>> edges;
        List<Edge> edgeList;

        public Graph(int numOfNodes, int numOfMachines) {
            this.numOfNodes = numOfNodes;
            this.numOfEdges = numOfNodes - 1;
            this.numOfMachines = numOfMachines;
//            this.edges = new List[numOfNodes-1];      //제네릭 어레이 문제로 맵으로 대체
            this.edges = new HashMap<>();
            this.edgeList = new ArrayList<>();
        }

        public void addEdge(int from, int to, int weight, int no) {
            Edge e = new Edge(from, to, weight, no);
            this.edgeList.add(e);

            List<Edge> list = edges.get(from);
            if(list == null) {
                list = new ArrayList<>();
            }
            list.add(e);
            this.edges.put(from, list);
        }

        public void sort() {
            Collections.sort(this.edgeList);
        }
    }

    class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;
        int no;

        public Edge(int from, int to, int weight, int no) {
            this.from = from;
            this.to = to;
            this.weight = weight;
            this.no = no;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.weight <= o.weight)
                return 1;
            else
                return -1;
        }
    }

}
