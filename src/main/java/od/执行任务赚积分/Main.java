package od.执行任务赚积分;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int t=scn.nextInt();
        int wos[][]=new int[n][2];
        for (int i = 0; i < n; i++) {
            wos[i][0]=scn.nextInt();
            wos[i][1]=scn.nextInt();
        }
        System.out.println(getResult(wos,t));
    }

    private static int getResult(int[][] wos, int t) {
        Arrays.sort(wos,(a,b)->a[0]-b[0]);

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->a-b);
        int curTime=0;
        int ans=0;
        for(int[] w:wos){
            int endTime=w[0];
            int score=w[1];
            if(curTime<endTime){
                pq.offer(score);
                ans+=score;
                curTime++;
            }else {
                if(pq.size()==0){
                    continue;
                }
                int min_score=pq.peek();
                if(score>min_score){
                    pq.poll();
                    pq.offer(score);
                    ans+=score-min_score;
                }
            }
        }
        while (pq.size()>t && t>0){
            ans-=pq.poll();
        }

        return ans;
    }
}
