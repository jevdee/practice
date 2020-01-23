import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonChild {
    public static void main(String[] args) throws IOException {
//        SHINCHAN
//        NOHARAAA

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int n = a.length();
        int[][] arr = new int[n+1][n+1];

        for(int i=1; i<n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    arr[i][j] = arr[i-1][j-1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                }
            }
        }

        System.out.println(arr[n][n]);


    }

}
