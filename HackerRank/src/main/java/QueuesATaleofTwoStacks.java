import java.util.Scanner;
import java.util.Stack;

public class QueuesATaleofTwoStacks {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

    public static class MyQueue<Integer> {
        Stack<Integer> in = new Stack<>();
        Stack<Integer> out = new Stack<>();

        public void enqueue(Integer e) {
            in.push(e);
        }

        public Integer dequeue() {
            if(out.isEmpty()) {
                while(!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.pop();
        }

        public Integer peek() {
            if(out.isEmpty()) {
                while(!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }

    }


}

