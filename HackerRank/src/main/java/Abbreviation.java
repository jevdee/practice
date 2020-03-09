import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Abbreviation {
//    1
//beFgH
//EFG
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String a = br.readLine();
            String b = br.readLine();
            boolean r = abbreviate(a, b);
            if(r)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    static boolean abbreviate(String a, String b) {
        boolean[] arr = new boolean[a.length()+1];
        arr[0] = true;

        boolean flag = true;
        for (int i = 0; i < a.length(); i++) {
            if(Character.isUpperCase(a.charAt(i))) {
                flag = false;
            }
            arr[i+1] = flag;
        }

        for (int i = 0; i < b.length(); i++) {
            boolean[] nextArr = new boolean[arr.length];
            nextArr[0] = false;

            char charB = b.charAt(i);

            for (int j = 0; j < a.length(); j++) {
                flag = false;
                char charA = a.charAt(j);

                if(Character.isLowerCase(charA)) {
                    flag = true;
                    charA = Character.toUpperCase(charA);
                }

                if(charA == charB) {
                    nextArr[j+1] = arr[j];

                    if(flag) { //소문자였던 경우
                        nextArr[j+1] = nextArr[j+1] | nextArr[j];
                    }
                } else {
                    if(flag) {  //소문자였던 경우
                        nextArr[j+1] = nextArr[j];
                    } else {
                        nextArr[j+1] = false;
                    }
                }
            }

            for (int j = 0; j < arr.length; j++) {
                arr[j] = nextArr[j];
            }
        }

        return arr[a.length()];
    }
}
