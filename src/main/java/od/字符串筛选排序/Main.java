package od.字符串筛选排序;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        scanner.nextInt();
        int k=scanner.nextInt();
        System.out.println(getResult(str,k));
    }

    public static int getResult(String str,int k){
        char arr[]=str.toCharArray();
        if(k>arr.length) k=arr.length;
        Arrays.sort(arr);
        int result =str.indexOf(arr[k-1]);

        return result;
    }
}
