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
        if(s.contains("a = "))
            s = br.readLine();

        for (int i = 0; i < cities-1; i++) {
            int[] ii = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            g.addEdge(ii[0],ii[1],ii[2]);
            s = br.readLine();
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

        List<Integer> list = new ArrayList<>();
        boolean isSelectedOneMachineNode = false;
        for (int i=0; i<g.edgeList.size(); i++) {
            Edge e = g.edgeList.get(i);
            if(!haveSameParent(parentArr, e.from, e.to)) {
                int m = Math.min(e.from, e.to);
                if(isPureCity(machineNode, e)) {
                    parentArr[e.from] = m;
                    parentArr[e.to] = m;
                } else if(!isSelectedOneMachineNode && haveOnlyOneMachine(machineNode, e)) {
                    isSelectedOneMachineNode = true;
                    parentArr[e.from] = m;
                    parentArr[e.to] = m;
                } else {
                    list.add(e.weight);
                }
            }
        }

        Collections.sort(list);
        int res = list.get(0) + list.get(1);

        System.out.println(res);
    }

    public void minTime(int[][] roads, int[] machines) {
        int cities = roads.length;
        int numMachines = machines.length;
        Graph g = new Graph(cities, numMachines);

        for (int i = 0; i < roads.length; i++) {
            for (int j = 0; j < 3; j++) {
                g.addEdge(i,j,roads[i][j]);
            }

        }
        g.sort();       //내림차순

        //kruskal - start with machines point
        int[] parentArr = new int[cities];
        for (int i = 0; i < cities; i++) {
            parentArr[i] = i;
        }

        List<Integer> list = new ArrayList<>();
        boolean isSelectedOneMachineNode = false;
        for (int i=0; i<g.edgeList.size(); i++) {
            Edge e = g.edgeList.get(i);
            if(!haveSameParent(parentArr, e.from, e.to)) {
                int m = Math.min(e.from, e.to);
                if(isPureCity(machines, e)) {
                    parentArr[e.from] = m;
                    parentArr[e.to] = m;
                } else if(!isSelectedOneMachineNode && haveOnlyOneMachine(machines, e)) {
                    isSelectedOneMachineNode = true;
                    parentArr[e.from] = m;
                    parentArr[e.to] = m;
                } else {
                    list.add(e.weight);
                }
            }
        }

        Collections.sort(list);
        int res = list.get(0) + list.get(1);

        System.out.println(res);
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
        for (int i = 0; i < machineNode.length; i++) {
            if((e.from == machineNode[i] && e.to != machineNode[i]) || e.to == machineNode[i] && e.from != machineNode[i])
                return true;
        }
        return false;
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

        public void addEdge(int from, int to, int weight) {
            Edge e = new Edge(from, to, weight);
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

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
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
