import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class CastleontheGrid {
    public static void main(String[] args) throws IOException {
//        3
//        .X.
//        .X.
//        ...
//        0 0 0 2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] input = new char[n][n];
        for (int i = 0; i < n; i++) {
            input[i] = br.readLine().toCharArray();
        }
        String[] ss = br.readLine().split(" ");
        int[] start = new int[2];
        int[] end = new int[2];
        start[0] = Integer.parseInt(ss[0]);
        start[1] = Integer.parseInt(ss[1]);
        end[0] = Integer.parseInt(ss[2]);
        end[1] = Integer.parseInt(ss[3]);

        boolean[][] visited = new boolean[n][n];
        int steps = 0;
        List<int[]> queue = new LinkedList<>();



    }

}
