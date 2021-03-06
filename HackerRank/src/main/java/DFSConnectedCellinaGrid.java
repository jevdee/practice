import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DFSConnectedCellinaGrid {
    //    4
//    4
//    1 1 0 0
//    0 1 1 0
//    0 0 1 0
//    1 0 0 0
    static int[][] arr;
    static boolean[][] visited;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, dfs(i,j));
            }
        }

        System.out.println(max);
    }

    public static int dfs(int x, int y) {
        if(visited[x][y] || arr[x][y] == 0)
            return -1;

        visited[x][y] = true;
        List<int[]> adjacentNodes = getAdjacentNodes(x,y);
        int max = 1;
        if(adjacentNodes.size() > 0) {
            int t = 0;
            for (int[] ad : adjacentNodes) {
                if (!visited[ad[0]][ad[1]]) {
                    t += dfs(ad[0], ad[1]);
                }
            }
            max = t+1;
        }

        return max;
    }

    public static List getAdjacentNodes(int x, int y) {
        List<int[]> adjacent = new ArrayList<>();

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if(i == 0 && j == 0)
                    continue;

                if(isValid(x+i,y+j) && arr[x+i][y+j] == 1) {
                    adjacent.add(new int[]{x+i,y+j});
                }
            }
        }

        return adjacent;
    }

    public static boolean isValid(int i, int j) {
        return (i < n && i >= 0) && (j < m && j >= 0);
    }


}
