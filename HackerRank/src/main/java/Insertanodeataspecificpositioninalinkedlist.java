import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Insertanodeataspecificpositioninalinkedlist {
    public static void main(String[] args) throws IOException {
//        3     num
//        16
//        13
//        7
//        1     data
//        2     position
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        SinglyLinkedListNode head = initLinkedList(null, data);
        head = insertNodeAtPosition(head, Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
        printLinkedList(head);
    }

    public static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode tmp = head;
        while(tmp != null) {
            System.out.print(tmp.getData() + " ");
            tmp = tmp.getNext();
        }
    }

    public static SinglyLinkedListNode initLinkedList(SinglyLinkedListNode head, int[] data) {
        SinglyLinkedListNode tmp = null;
        for (int i = 0; i < data.length; i++) {
            if(head == null) {
                head = new SinglyLinkedListNode(data[i]);
                tmp = head;
            } else {
                tmp.setNext(new SinglyLinkedListNode(data[i]));
                tmp = tmp.getNext();
            }
        }
        return head;
    }

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        int i = 1;
        SinglyLinkedListNode pre = head;
        SinglyLinkedListNode tmp = head.getNext();
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        while(true) {
            if(position == 0) {
                newNode.setNext(head);
                head = newNode;
                break;
            } else if(position == i) {
                newNode.setNext(tmp);
                pre.setNext(newNode);
                break;
            } else {
                pre = tmp;
                tmp = tmp.getNext();
                i++;
            }
        }
        return head;

    }
}

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
        this.data = data;
        next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SinglyLinkedListNode getNext() {
        return next;
    }

    public void setNext(SinglyLinkedListNode next) {
        this.next = next;
    }
}
