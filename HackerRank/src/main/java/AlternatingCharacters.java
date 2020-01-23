import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlternatingCharacters {
    public static void main(String[] args) {
//        5
//        AAAA
//        BBBBB
//        ABABABAB
//        BABABA
//        AAABBB
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            for(int i=0; i<n; i++) {
                String s = br.readLine();
                run(s);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void run(String s) {
        char[] arr = s.toCharArray();
        int result = 0;
        for(int i=0; i<arr.length-1; i++) {
            if(arr[i] == arr[i+1]) {
                result++;
            }
        }
        System.out.println(result);
    }

}
