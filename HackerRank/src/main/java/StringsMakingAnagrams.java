import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class StringsMakingAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();

        Arrays.sort(ac);
        Arrays.sort(bc);

        int match = 0;
        int i = 0;
        int j = 0;
        while((ac.length > i) && (bc.length > j)) {
            if(ac[i] == bc[j]) {
                i++;
                j++;
                match++;
            } else {
                if(ac[i] > bc[j]) {
                    j++;
                } else {
                    i++;
                }
            }
        }

        int result = (ac.length + bc.length) - match*2;
//        System.out.println((ac.length + bc.length) - match*2);

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            bw.write(result);
        }

        br.close();
    }



}
