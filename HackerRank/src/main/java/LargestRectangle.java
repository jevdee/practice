
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Object[] tmp =  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray();
        Integer[] arr = Arrays.copyOf(tmp, n, Integer[].class);

        long max = 0;
        Stack<Integer> stack = new Stack<>();

        int i=0;
        while(i < n) {
            if(stack.empty() || arr[stack.peek()] <= arr[i]) {
                stack.push(i);
                i++;
                continue;
            } else {
                int top = stack.pop();
                int area = (stack.empty()) ? arr[top] * i : arr[top] * (i - stack.peek() - 1);
//                System.out.println("i : arr[top] * (i - stack.peek() - 1");
//                if(!stack.empty())
//                    System.out.println("area = " + area + " = " + arr[top] + " * (" + i + " - " + stack.peek() + " - 1)");
                if(max < area) {
                    max = area;
                }
            }
        }

        while(!stack.empty()) {
            int top = stack.pop();
            int area = arr[top] * (stack.empty() ? i : i - stack.peek() - 1);

            if(max < area) {
                max = area;
            }
        }

        System.out.println(max);
    }
}
