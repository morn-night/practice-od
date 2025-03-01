package od.精准核酸检测;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.nextLine();
        int[] confirmed= Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int info[][]=new int[n][n];
        for (int i = 0; i < n; i++) {
            info[i]=Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        }

        LinkedList<Integer> stack=new LinkedList<>();
        LinkedList<Integer> result=new LinkedList<>();
        for (int i = 0; i < confirmed.length; i++) {
            stack.add(confirmed[i]);
            result.add(confirmed[i]);
        }

        while (!stack.isEmpty()){
            Integer cur=stack.poll();
            for (int i = 0; i < n; i++) {
                if(info[i][cur]==1 && cur!=i && !result.contains(i)){
                    stack.add(i);
                    result.add(i);
                }
            }
        }

        System.out.println(result.size()-confirmed.length);

    }
}
