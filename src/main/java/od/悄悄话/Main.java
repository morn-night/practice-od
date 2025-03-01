package od.悄悄话;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int[] times= Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int ans=0;
        LinkedList<Integer> queue=new LinkedList<>();
        queue.addLast(0);
        while (queue.size()>0){
            int fa=queue.removeFirst();
            int ch1=2*fa+1;
            int ch2=2*fa+2;

            boolean ch1_exist=ch1<times.length &&times[ch1]!=-1;
            boolean ch2_exist=ch2<times.length &&times[ch2]!=-1;
            if(ch1_exist){
                times[ch1]+=times[fa];
                queue.addLast(ch1);
            }
            if(ch2_exist){
                times[ch2]+=times[fa];
                queue.addLast(ch2);
            }
            if(!ch1_exist && !ch2_exist){
                ans=Math.max(ans,times[fa]);
            }
        }
        System.out.println(ans);
    }
}
