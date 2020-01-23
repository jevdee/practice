import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Array2DDS {
//    1 1 1 0 0 0
//    0 1 0 0 0 0
//    1 1 1 0 0 0
//    0 0 2 4 4 0
//    0 0 0 2 0 0
//    0 0 1 2 4 0
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 6; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        int result = -100;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int tmp = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                if(tmp > result)
                    result = tmp;
            }
        }


        System.out.println(result);

    }
}
