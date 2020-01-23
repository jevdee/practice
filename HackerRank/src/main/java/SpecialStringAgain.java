import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SpecialStringAgain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        Set<String> set = new HashSet<>();

        for(int i=0; i<n; i++) {        //시작위치
            set.add(""+i);

            for(int j=1; j<n; j++) {    //길이
                if(arr[i] != arr[j]) {
                    break;
                } else {
                    set.add(""+i+""+j);
                }

                //가운데를 기준으로 양쪽이 같은 char인지 비교교
            }

        }


    }


}
