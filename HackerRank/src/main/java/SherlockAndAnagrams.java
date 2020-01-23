import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class SherlockAndAnagrams {
    public static void main(String[] args) {
    //    1
    //    cdcd
        // kkkk
        // 5
        new SherlockAndAnagrams().run();

    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        while(sc.hasNext()) {
            String s = sc.nextLine();
            int length = s.length();

            Map<String, Integer> map = new HashMap<>();

            int result = 0;
            for(int i=0; i<length; i++) {
                for(int j=i+1; j<=length; j++) {

                    String sub = s.substring(i,j);
                    char[] charArr = sub.toCharArray();
                    Arrays.sort(charArr);
                    sub = String.valueOf(charArr);

                    if(map.containsKey(sub)) {
                        int value = map.get(sub);
                        result+=value;
                        map.put(sub, ++value);
                    } else {
                        map.put(sub, 1);
                    }
                }
            }

            System.out.println(result);
        }


    }
}
