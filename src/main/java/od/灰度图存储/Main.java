package od.灰度图存储;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] nums= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row=nums[0];
        int cols=nums[1];
        int[] pos= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x=pos[0];
        int y=pos[1];

        int graph[]=new int[row*cols];
        int start=0;
        for (int i = 2; i < nums.length; i+=2) {
            int gray=nums[i];
            int len=nums[i+1];
            Arrays.fill(graph,start,start+len,gray);
            start+=len;
        }
        int target=x*cols+y;
        System.out.println(graph[target]);
    }
}
