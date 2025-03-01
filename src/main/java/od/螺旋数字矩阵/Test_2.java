package od.螺旋数字矩阵;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 螺旋数字矩阵
 *
 */
public class Test_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //个数
        int n=sc.nextInt();
        //行数
        int m=sc.nextInt();
        //列数
        int k=n%m==0?n/m:(n/m)+1;

        //结果
        int[][] res=new int[m][k];

        //当前值
        int cur=1;
        //坐标
        int x=0,y=0;

        while(cur<=n){
            //先向右
            while(y<k && res[x][y]==0 && cur<=n){ res[x][y++]=cur++; }
            y--;
            x++;
            //再向下
            while(x<m && res[x][y]==0 && cur<=n){ res[x++][y]=cur++; }
            x--;
            y--;
            //再向左
            while(y>=0 && res[x][y]==0 && cur<=n){ res[x][y--]=cur++; }
            x--;
            y++;
            //向上
            while (x>=0 && res[x][y]==0 && cur<=n){ res[x--][y]=cur++; }
        }
        //打印
        for (int i = 0; i < m; i++) {
            StringJoiner row=new StringJoiner(" ");
            for (int t = 0; t < k; t++) {
                if(res[i][t]==0){
                    row.add("*");
                }else {
                    row.add(res[i][t]+"");
                }
            }
            System.out.println(row);
        }

    }
}
