package od.最多购买宝石数目;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] gems=new int[n];
        for (int i = 0; i < n; i++) {
            gems[i]=scan.nextInt();
        }
        int v=scan.nextInt();
        System.out.println(maxGems(n,gems,v));

    }
    public static int maxGems(int n, int[] gems, int value) {
// 初始化最大宝石数量为0
        int maxGemsCount = 0;
// 初始化当前窗口中的宝石数量为0
        int gemsCount = 0;
// 初始化当前窗口中的宝石价格总和为0
        int gemsPrice = 0;
// 初始化窗口的开始指针为0
        int start = 0;
// 初始化窗口的结束指针为0
        int end = 0;
        while (end < n) {
            if (gemsPrice + gems[end] <= value) {
                gemsPrice += gems[end];
                gemsCount++;
                end++;
            } else {
                gemsPrice -= gems[start];
                gemsCount--;
                start++;
            }
            maxGemsCount = Math.max(maxGemsCount, gemsCount);
        }
        return maxGemsCount;
    }
}
