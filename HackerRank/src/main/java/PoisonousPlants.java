import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PoisonousPlants {
    public static void main(String[] args) throws IOException {
//        7
//        6 5 8 4 7 10 9
//        10
//        6 7 1 4 2 7 5 8 10 4
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //여러개의 decreasing chain을 각각 queue로 만드는 방법


        //이 방법은 타임아웃 걸림
//        List<Integer> list = new LinkedList<>(Arrays.asList(Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf).toArray(Integer[]::new)));
//        List<Boolean> dieList = new LinkedList<>();
//        int k = 0;
//        while(k < list.size()) {
//            dieList.add(false);
//            k++;
//        }
//        int days = 0;
//        while(true) {
//            boolean flag = false;
//            int size = list.size();
//
//            for (int i = 1; i < size; i++) {
//                if(list.get(i-1) < list.get(i)) {
//                    dieList.set(i, true);
//                    flag = true;
//                }
//            }
//
//            if(!flag)
//                break;
//            else
//                days++;
//
//            k=0;
//            while(k < size) {
//                if(dieList.get(k)) {
//                    dieList.remove(k);
//                    list.remove(k);
//                    size--;
//                } else {
//                    k++;
//                }
//            }
//        }
//        System.out.println(days);

    }
}
