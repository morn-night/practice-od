package od.分披萨;

import java.util.Scanner;

public class Main {
    static  int[] pizza;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        pizza=new int[n];
        for (int i = 0; i < n; i++) {
            pizza[i]=scan.nextInt();
        }
        long ans=0;
        for (int i = 0; i < n; i++) {
            ans=Math.max(ans,recursive(check(i-1),check(i+1))+pizza[i]);
        }
        System.out.println(ans);
    }

    private static long recursive(int l, int r) {
        if(pizza[l]>pizza[r]){
            l=check(l-1);
        }else {
            r=check(r+1);
        }
        if(l==r){
            return pizza[l];
        }else {
            return Math.max(recursive(check(l-1),r)+pizza[l],recursive(l,check(r+1))+pizza[r]);
        }
    }

    public static int check(int idx){
        if(idx<0){
            idx=pizza.length-1;
        }else if(idx>=pizza.length){
            idx=0;
        }
        return idx;
    }
}
