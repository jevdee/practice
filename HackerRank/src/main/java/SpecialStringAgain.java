import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SpecialStringAgain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] arr = s.toCharArray();
        long counter = 0;

        //cderxabaac
        int result = 0;
        for(int i=0; i<n; i++) {
            int counter2 = 0;
            int offset = 1;
            while(i-offset >= 0 && i+offset < n && arr[i-1] == arr[i+offset] && arr[i-1] == arr[i-offset]) {
                offset++;
                counter2++;
            }

            int counter1 = 0;
            for (int j = i+1; j<n; j++) {
                if (arr[i] == arr[j]) {
                    counter1++;
                    i++;
                } else {
                    break;
                }
            }

            result += counter2 + (counter1*(counter1+1)/2);
        }

        System.out.println(result+n);
    }
}

