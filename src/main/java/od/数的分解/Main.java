package od.数的分解;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        System.out.println(getResult(scn.nextLong()));
    }

    private static String getResult(long n) {
        if(n==1){
            return "N";
        }

        if(n%2!=0){
            return n+"="+(n/2)+"+"+(n/2+1);
        }
        //偶数
        //最大奇数
        long x=n/2;
        while (x%2==0){
            x/=2;
        }

        //若
        return "";
    }
}
