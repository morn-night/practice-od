package od.分割均衡字符串;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        String s=scn.nextLine();

        int countX=0,countY=0;
        int result=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='X'){
                countX++;
            }else {
                countY++;
            }

            if(countX==countY){
                result++;
            }
        }
        System.out.println(result);
    }
}
