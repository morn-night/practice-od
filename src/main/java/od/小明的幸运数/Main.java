package od.小明的幸运数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int lucky=scan.nextInt();

        int maxStep=0;
        int curStep=0;
        boolean flag=true;
        for (int i = 0; i < n; i++) {
            int num=scan.nextInt();
            if(n>100 || lucky>100 || lucky<-100 || num>100 ||num<-100){
                flag=false;
            }
            if(num==lucky){
                if(num<0){
                    num--;
                }else if(num>0){
                    num++;
                }

            }
            curStep+=num;
            maxStep=Math.max(maxStep,curStep);
        }
        System.out.println(flag==true?maxStep:12345);


    }
}
