import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Triplesum {
//    3 2 3
//    1 3 5
//    2 3
//    1 2 3
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        Integer[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).distinct().boxed().toArray(Integer[]::new);
        Integer[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).distinct().boxed().toArray(Integer[]::new);
        Integer[] c = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).distinct().boxed().toArray(Integer[]::new);
//        int lena = a.length;
//        int lenb = b.length;
//        int lenc = c.length;

        //Arrays.sort();
        //primitive 는 quick sort -> 평균 O(nlogn), 최악 O(n^2)
        //object 는 merge sort -> 평균 O(nlogn), 최악 O(nlogn)
        //하지만 for문을 while문으로 대체하여 타임아웃 패스함
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int aIndex = 0;
        int bIndex = 0;
        int cIndex = 0;
        long result = 0;

        while(bIndex<b.length){
            while(aIndex<a.length && a[aIndex]<=b[bIndex])
                aIndex++;

            while(cIndex<c.length && c[cIndex]<=b[bIndex])
                cIndex++;

            // you should convert int to long first,
            // avoid int overflow and lead to fail the test case 4
            result += ((long)aIndex)*((long)cIndex);
            bIndex++;
        }
//        for (int i = 0; i < lenb; i++) {
//            int countA = 0;
//            int countC = 0;
//
//            for (int j = 0; j < lena; j++) {
//                if(b[i] >= a[j])
//                    countA++;
//                else
//                    break;
//            }
//
//            for (int j = 0; j < lenc; j++) {
//                if(b[i] >= c[j])
//                    countC++;
//                else
//                    break;
//            }
//            result += countA * countC;
//        }
        System.out.println(result);
    }
}
