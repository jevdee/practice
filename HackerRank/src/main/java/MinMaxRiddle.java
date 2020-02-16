import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class MinMaxRiddle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input  = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
//        InputStream is = classloader.getResourceAsStream("input02.txt");
//        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        //해당위치의 숫자가 최소값이 되는 가장 큰 윈도우 사이즈를 구해야함 --> 스택 사용...
        // 11 2 3 14 5 2 11 12
        Stack<Integer> stack = new Stack<>();
        int i=0;
        int[] right = new int[n];
        int[] left = new int[n];

        //오른쪽 진행방향
        while(i < n) {
            if(stack.empty() || input[stack.peek()] <= input[i]) {
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                right[i] = i - top;
            }
        }

        //왼쪽 진행방향



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
