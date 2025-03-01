package od.游戏分组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int arr[]=new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i]=scanner.nextInt();
        }
        System.out.println(getResult(arr));
    }

    private static int getResult(int[] arr) {
        Arrays.sort(arr);

        List<Integer> res=new ArrayList<>();
        dfs(arr,0,0,0,res);
        int sum=Arrays.stream(arr).reduce(Integer::sum).orElse(0);
        return res.stream().map(subSum->Math.abs(sum-2*subSum)).min((a,b)->a-b).orElse(0);
    }

    private static void dfs(int[] arr, int index, int level, int sum, List<Integer> res) {
        if(level==5){
            res.add(sum);
            return;
        }
        for (int i = index; i < 10; i++) {
            if(i>index && arr[i]==arr[i-1]) continue;;
            dfs(arr,i+1,level+1,sum+arr[i],res);
        }
    }
}
