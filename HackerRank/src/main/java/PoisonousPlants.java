import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //여러개의 decreasing chain을 각각 queue로 만들어서 커다란 queue에 등록하는 방법
        //LinkedList 썼더니 case20 타임아웃...
        //LinkedList 대신 ArrayList 쓰니까 몹시 빨라지고 all case pass
        //get(index) 가 LinkedList O(n)보다 ArrayList O(1)에서 빨라서 그런 것 같음

//        *** LinkedList와 ArrayList 비교 ***
//        For LinkedList<E>
    //        get(int index) is O(n) (with n/4 steps on average)
    //        add(E element) is O(1)
    //        add(int index, E element) is O(n) (with n/4 steps on average), but O(1) when index = 0 <--- main benefit of LinkedList<E>
    //        remove(int index) is O(n) (with n/4 steps on average)
    //        Iterator.remove() is O(1). <--- main benefit of LinkedList<E>
    //        ListIterator.add(E element) is O(1) This is one of the main benefits of LinkedList<E>
//        Note: Many of the operations need n/4 steps on average, constant number of steps in the best case (e.g. index = 0), and n/2 steps in worst case (middle of list)
//
//        For ArrayList<E>
    //        get(int index) is O(1) <--- main benefit of ArrayList<E>
    //        add(E element) is O(1) amortized, but O(n) worst-case since the array must be resized and copied
    //        add(int index, E element) is O(n) (with n/2 steps on average)
    //        remove(int index) is O(n) (with n/2 steps on average)
    //        Iterator.remove() is O(n) (with n/2 steps on average)
    //        ListIterator.add(E element) is O(n) (with n/2 steps on average)
//        Note: Many of the operations need n/2 steps on average, constant number of steps in the best case (end of list), n steps in the worst case (start of list)
//
//        출처: https://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist-in-java

        int days = 0;

        List<List<Integer>> queue = new ArrayList<>();
        int i = 1;
        int idx = 0;
        while (i < arr.length) {
            if (arr[i - 1] < arr[i]) {
                List<Integer> stack = new ArrayList<>();
                for (int j = idx; j < i; j++) {
                    stack.add(arr[j]);
                }
                queue.add(stack);
                idx = i;
            }
            i++;
        }
        if (idx < arr.length) {
            List<Integer> stack = new ArrayList<>();

            for (int j = idx; j < arr.length; j++) {
                stack.add(arr[j]);
            }
            queue.add(stack);
        }

        while(queue.size() > 1) {
            for (int j = 1; j < queue.size(); j++) {
                queue.get(j).remove(0);
                if (queue.get(j).isEmpty()) {
                    queue.remove(j);
                    j--;
                }
            }
            List<List<Integer>> newQueue = new ArrayList<>();
            idx = 0;
            while (idx < queue.size()) {
                List<Integer> list = queue.get(idx);
                while ((idx + 1 < queue.size()) && (list.get(list.size() - 1) >= queue.get(idx + 1).get(0))) {
                    list.addAll(queue.get(idx + 1));
                    idx++;
                }
                newQueue.add(list);
                idx++;
            }
            queue = newQueue;
            days++;
        }
        System.out.println(days);


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
