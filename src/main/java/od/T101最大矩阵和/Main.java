package od.T101最大矩阵和;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();

        int[][] arr=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                arr[i][k]=scanner.nextInt();
            }
        }

        int result=Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            result=Math.max(result,maxSubArrSum(arr[i]));

            for (int k = i+1; k <n; k++) {
                for (int h = 0; h < m; h++) {
                    arr[i][h]+=arr[k][h];
                }
                result=Math.max(result,maxSubArrSum(arr[i]));
            }
        }
        System.out.println(result);
    }

    public static int maxSubArrSum(int[] nums){
        int dp=nums[0];
        int res=dp;

        for (int i = 1; i < nums.length; i++) {
            dp=Math.max(dp,0)+nums[i];
            res=Math.max(res,dp);
        }
        return res;
    }
}
