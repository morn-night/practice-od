package od.T113完全二叉树非叶子部分后序遍历;

import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    static String[] arr;
    static StringJoiner sj=new StringJoiner(" ");
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        arr=scanner.nextLine().split(" ");
        if(arr.length==1){
            System.out.println(arr[0]);
        }else {
            dfs(0);
            System.out.println(sj);
        }
    }

    private static void dfs(int root) {
        int left=root*2+1;
        int right=root*2+2;
        if(arr.length>left){
            dfs(left);
            if(arr.length>right){
                dfs(right);
            }
            sj.add(arr[root]);
        }
    }
}
