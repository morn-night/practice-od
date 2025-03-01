package od.小明找位置;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        String line=scn.nextLine();
        int n=scn.nextInt();
        String[] nums=line.split(",");
        int[] arr=new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Integer.parseInt(nums[i]);
        }
        Arrays.sort(arr);
        int result=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>=n){
                result=i;
                System.out.println("+=="+Arrays.binarySearch(arr,n));
                break;
            }
        }
        System.out.println(result+1);
    }
}
