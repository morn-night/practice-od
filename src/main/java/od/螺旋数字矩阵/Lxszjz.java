package od.螺旋数字矩阵;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 螺旋数字矩阵
 */
public class Lxszjz {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //数字数量
        int n=scanner.nextInt();
        //行数
        int m=scanner.nextInt();
        int k=n%m==0?n/m:n/m+1;
        int nums[][]=new int[m][k];
        int x=0,y=0,step=1;
        while(step<=n){
            //上
            while (y<k && nums[x][y]==0 && step<=n){
                nums[x][y++]=step++;
            }
            y=y-1;
            x=x+1;
            //右
            while (x<m && nums[x][y]==0 && step<=n){
                nums[x++][y]=step++;
            }
            x-=1;
            y-=1;
            //下
            while (y>=0 && nums[x][y]==0 && step<=n){
                nums[x][y--]=step++;
            }
            y+=1;
            x-=1;
            //左
            while (x>=0 && nums[x][y]==0 && step<=n){
                nums[x--][y]=step++;
            }
            x+=1;
            y+=1;
        }

        // 打印螺旋矩阵字符串
        for (int i = 0; i < m; i++) {
            StringBuffer line=new StringBuffer();
            for (int j = 0; j < k; j++) {
                if (nums[i][j] == 0) {
                    line.append("* ");
                } else {
                    line.append(nums[i][j] + " ");
                }
            }
            System.out.println(line);
        }
    }
}
