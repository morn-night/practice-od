package od.最富裕的小家庭;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int wealth[]=new int[n];
        int famuly=0;
        for (int i = 0; i < n; i++) {
            wealth[i]=scanner.nextInt();
        }
        for (int i = 0; i < n-1; i++) {
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            famuly=Math.max(wealth[a-1]+wealth[b-1],famuly);
        }
        System.out.println(famuly);


    }
}
