package od.机器人搬砖;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] nums=scanner.nextLine().split(" ");
        int[] nums2= Arrays.stream(nums).mapToInt(Integer::parseInt).toArray();
        System.out.println(getResult(nums2));
    }

    private static int getResult(int[] nums) {
        if(nums.length>8){
            return -1;
        }
        int max=Arrays.stream(nums).max().orElse(0);
        int min=1;
        if(nums.length==8){
            return max;
        }
        //小于8的
        while (min<=max){
            int mid=(max+min)/2;
            boolean flag=true;
            int cost=0;
            for (int i = 0; i < nums.length; i++) {
                cost+=nums[i]/mid+(nums[i]%mid>0?1:0);
            }
            if(cost>8){
                flag=false;
            }
            if(flag){
                max=max-1;
            }else {
                min=min+1;
            }
        }
        return min;


    }
}
