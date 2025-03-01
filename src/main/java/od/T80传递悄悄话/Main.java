package od.T80传递悄悄话;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int  time_result=0;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] tree= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getResult(tree));
    }

    private static int getResult(int[] tree) {

        dfs(tree,0,0);
        return time_result;
    }

    private static void dfs(int[] tree,int i,int time) {
        int left=2*i+1;
        int right=2*i+2;
        time=time+tree[i];
        if(left<tree.length && tree[left]!=-1){

                dfs(tree,left,time);

        }else {
            time_result=Math.max(time_result,time);
        }
        if(right<tree.length &&tree[right]!=-1){

                dfs(tree,right,time);

        }else {
            time_result=Math.max(time_result,time);
        }
    }
}
