import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int j = 0;
        while(j < n) {
            Stack<String> stack = new Stack();
            int i = 0;
            String[] arr = br.readLine().split("");
            boolean flag = false;
            while (i < arr.length) {
                if(arr.length % 2 != 0) {
                    flag = true;
                    break;
                }

                if (arr[i].equals("{") || arr[i].equals("[") || arr[i].equals("(")) {
                    stack.push(arr[i]);
                } else {
                    if(stack.isEmpty()) {
                        flag = true;
                        break;
                    }
                    String tmp = stack.pop();
                    if (arr[i].equals("}")) {
                        if (!tmp.equals("{")) {
                            flag = true;
                            break;
                        }
                    } else if (arr[i].equals("]")) {
                        if (!tmp.equals("[")) {
                            flag = true;
                            break;
                        }
                    } else {
                        if (!tmp.equals("(")) {
                            flag = true;
                            break;
                        }
                    }
                }
                i++;
            }

            if(!flag && stack.isEmpty())
                System.out.println("YES");
            else
                System.out.println("NO");
            j++;
        }
    }
}
