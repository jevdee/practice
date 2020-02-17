import java.io.*;
import java.util.*;

public class MinMaxRiddle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        테스트용
//        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
//        InputStream is = classloader.getResourceAsStream("input02.txt");
//        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        int n = Integer.parseInt(br.readLine());
        int[] input  = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //해당위치의 숫자가 최소값이 되는 가장 큰 윈도우 사이즈를 구해야함 --> 스택 사용...
        // 0  1 2 3  4 5 6  7
        // 11 2 3 14 5 2 11 12
        Stack<Integer> stack = new Stack<>();
        int i=0;
        //i번째 요소 기준으로 윈도우내 오른쪽 개수
        //i번째 요소 기준으로 윈도우내 왼쪽 개수
        //마지막에 i번째 요소 본인개수도 +1해야함
        int[] right = new int[n];
        int[] left = new int[n];

        //오른쪽 진행방향 동안 i번째 요소가 최소값으로 유지되는 최대기간
        //즉, i번째 요소 기준으로 오른쪽 개수
        while(i < n) {
            if(stack.empty() || input[stack.peek()] <= input[i]) {
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                right[top] = i - top - 1;
            }
        }
        while(!stack.empty()) {
            int top = stack.pop();
            right[top] = i - top - 1;
        }
        i--;

        //왼쪽 진행방향 동안 i번째 요소가 최소값으로 유지되는 최대기간
        //즉, i번째 요소 기준으로 왼쪽 개수
        while(-1 < i) {
            if(stack.empty() || input[stack.peek()] <= input[i]) {
                stack.push(i);
                i--;
            } else {
                int top = stack.pop();
                left[top] = top - i - 1;
            }
        }
        while(!stack.empty()) {
            int top = stack.pop();
            left[top] = top - i - 1;
        }

        // 11 2 3 14 5 2 11 12
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int j = 0; j < n; j++) {
            int num = left[j] + 1 + right[j];       //해당위치의 숫자가 최소값이 되는 가장 큰 윈도우 사이즈
            int value = map.getOrDefault(num, -1);

            if(input[j] >= value) {
                map.put(num, input[j]);
            } else {
                map.put(num, value);
            }
        }

        i = 0;
        int[] result = new int[n];
        int value = -1;
        for(int j=n; j>0; j--) {
            int current = map.getOrDefault(j, -1);
            if(current >= 0 && value < current) {
                value = current;
            }
            result[j-1] = value;
        }
        for(int j=0; j<n; j++) {
            System.out.print(result[j] + " ");
        }

//        테스트
//        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
//        InputStream is2 = classloader.getResourceAsStream("output02.txt");
//        BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));
//        int[] output  = Arrays.stream(br2.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        for(int j=0; j<n; j++) {
//            if(result[j] != output[j]) {
//                System.out.println(j + ":\t" + result[j] + "\t" + output[j]);
//            }
//        }

        System.out.println();
        //DP로 풀었더니 케이스2 타임아웃.....ㅠㅠ
//        //init
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            if(max < input[i])
//                max = input[i];
//        }
//        System.out.print(max + " ");
//
//        int i = 1;      //i = windowSize-1
//        while(i < n) {
//            int[] arr = new int[n-i];
//            int j=0;
//            max = 0;
//            while(j < arr.length) {
//                arr[j] = Math.min(input[j], input[j+1]);
//                if(max < arr[j]) {
//                    max = arr[j];
//                }
//                j++;
//            }
//            System.out.print(max + " ");
//            i++;
//            input = arr;
//        }
//        br.close();
    }
}
