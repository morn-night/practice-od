package od.机器人搬砖;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String strs[]=scanner.nextLine().split(" ");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(getResult(nums));


    }

    private static int getResult(int[] nums) {
        if(nums.length>8){
            return -1;
        }
        int max= Arrays.stream(nums).max().orElse(0);
        int min=1;
        int ans=max;
        while (min<=max){
            int mid=(min+max)/2;
            if(check(mid,8,nums)){
                ans=mid;
                max=mid-1;
            }else {
                min=mid+1;
            }
        }
        return ans;
    }

    private static boolean check(int mid, int i, int[] nums) {
        int cast=0;
        for(int n :nums){
            cast+=n/i+(n%i>0?1:0);
        }
        if(cast>i){
            return false;
        }
        return true;
    }
}
