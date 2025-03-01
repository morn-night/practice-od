package od.CPU算力分配;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        while (scan.hasNext()){
            int l1=scan.nextInt();
            int l2=scan.nextInt();
            String ans="";
            int sumA=0;
            int[] A=new int[l1];
            for (int i = 0; i < l1; i++) {
                int a=scan.nextInt();
                sumA+=a;
                A[i]=a;
            }

            int sumB=0;
            HashSet<Integer> setB=new HashSet<>();
            for (int i = 0; i < l2; i++) {
                int b=scan.nextInt();
                sumB+=b;
                setB.add(b);
            }

            int half_diff=(sumA-sumB)/2;
            int minA=Integer.MAX_VALUE;

            for(int a:A){
                int b=a-half_diff;
                if(setB.contains(b)){
                    if(a<minA){
                        minA=a;
                        ans=a+" "+b;
                    }
                }

            }
            System.out.println(ans);
        }

    }
}
