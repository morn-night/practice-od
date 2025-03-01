package od.太阳能板最大面积;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String line=new Scanner(System.in).nextLine();
        System.out.println(getResult(line.split(",")));
    }

    private static long getResult(String[] arr) {
        int nums[]=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i]=Integer.valueOf(arr[i]);
        }
        long sum=0;
        int l=0;
        int r=nums.length-1;
        while (l<r){
            //宽
            long x=r-l;
            //定义高
//            int y=nums[l]<nums[r]?nums[l]:nums[r];
            long y=0;
            if(nums[l]<nums[r]){
                y=nums[l];
                l++;
            }else {
                y=nums[r];
                r--;
            }
            sum=Math.max(sum,x*y);
        }
        return sum;

    }
}
