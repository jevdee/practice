import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class CastleontheGrid {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] input = new char[n][n];
        for (int i = 0; i < n; i++) {
            input[i] = br.readLine().toCharArray();
        }
        int[] start = new int[2];
        int[] goal = new int[2];
        String[] ss = br.readLine().split(" ");
        start[0] = Integer.parseInt(ss[0]);
        start[1] = Integer.parseInt(ss[1]);
        goal[0] = Integer.parseInt(ss[2]);
        goal[1] = Integer.parseInt(ss[3]);

        int steps = 0;
        boolean[][] visited = new boolean[n][n];
        List<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while(true) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] coor = queue.remove(0);
                int x = coor[0];
                int y = coor[1];

                if (x == goal[0] && y == goal[1]) {
                    System.out.println(steps);
                    return;
                }
                int idx = 1;
                //right
                while ((y + idx < n) && (input[x][y + idx] == '.')) {
                    if (!visited[x][y + idx]) {
                        visited[x][y + idx] = true;
                        queue.add(new int[]{x, y + idx});
                    }
                    idx++;
                }

                //bottom
                idx = 1;
                while ((x + idx < n) && (input[x + idx][y] == '.')) {
                    if (!visited[x + idx][y]) {
                        visited[x + idx][y] = true;
                        queue.add(new int[]{x + idx, y});
                    }
                    idx++;
                }

                //left
                idx = 1;
                while ((y - idx >= 0) && (input[x][y - idx] == '.')) {
                    if (!visited[x][y - idx]) {
                        visited[x][y - idx] = true;
                        queue.add(new int[]{x, y - idx});
                    }
                    idx++;
                }

                //top
                idx = 1;
                while ((x - idx >= 0) && (input[x - idx][y] == '.')) {
                    if (!visited[x - idx][y]) {
                        visited[x - idx][y] = true;
                        queue.add(new int[]{x - idx, y});
                    }
                    idx++;
                }
            }
            steps++;
        }
    }
}
