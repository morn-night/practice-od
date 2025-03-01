package od.会议室占用时间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] times=new int[n][2];
        for (int i = 0; i < n; i++) {
            times[i][0]=scanner.nextInt();
            times[i][1]=scanner.nextInt();
        }
        List<int[]> list=new ArrayList<>();
        Arrays.sort(times,(a,b)->a[0]-b[0]);
        int[] pre=times[0];
        for (int i = 0; i < times.length; i++) {
            int[] cur=times[i];
            if(cur[0]<=pre[1]){
                pre[1]=Math.max(pre[1],cur[1]);
            }else {
                list.add(pre);
                pre=cur;
            }
        }
        list.add(pre);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)[0]+" "+list.get(i)[1]);
        }
    }
}
