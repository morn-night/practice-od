package od.T102最短木板的长度最大可以为多少;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=scanner.nextInt();
        int m=scanner.nextInt();
        PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->a-b);
        for (int i = 0; i < n; i++) {
            queue.add(scanner.nextInt());
        }

        for (int i = 0; i < m; i++) {
            queue.add(queue.poll()+1);
        }

        System.out.println(queue.peek());
    }
}
