import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashTablesRansomNote {
    public static void main(String[] args) {
        new HashTablesRansomNote().run();
    }

    public void run() {
//        6 5
//        two times three is not four
//        two times two is four
//        6 4
//        give me one grand today night
//        give one grand today
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String maga = sc.nextLine();
        String note = sc.nextLine();

        Map<String, Integer> map = new HashMap<String, Integer>();
        String[] ss = maga.split(" ");

        for(String s : ss) {
            Integer v = map.get(s);
            if(v != null) {
                map.put(s, ++v);
            } else {
                map.put(s, 1);
            }
        }

        boolean flag = false;
        ss = note.split(" ");
        for(String s : ss) {
            Integer v = map.get(s);
            if(v != null) {
                if(v > 1)
                    map.put(s, --v);
                else
                    map.remove(s);
            } else {
                System.out.println("No");
                flag = true;
                break;
            }
        }
        if(!flag)
            System.out.println("Yes");
    }

}
