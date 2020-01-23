import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class TwoStrings {

    public static void main(String[] args) {
//        2
//        hello
//        world
//        hi
//        world
        new TwoStrings().run();

    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<n; i++) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            Map<String, Integer> map;
            if(s1.length() > s2.length()) {
                map = makeMap(s1);
                System.out.println(check(map, s2));
            } else {
                map = makeMap(s2);
                System.out.println(check(map, s1));
            }
        }
    }

    public String check(Map map, String s) {
        for(int j=0; j<s.length(); j++) {
            String sub = s.substring(j,j+1);
            if(map.get(sub) != null) {
               return "YES";
            }
        }

        return "NO";
    }

    public Map<String, Integer> makeMap(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int j=0; j<s.length(); j++) {
            map.put(s.substring(j,j+1), 1);
        }

        return map;
    }
}
