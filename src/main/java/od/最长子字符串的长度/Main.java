package od.最长子字符串的长度;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.println(getMaxLength(str));
    }

    private static int getMaxLength(String str) {
        int num=0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='o'){
                num++;
            }
        }
        if(num%2==0){
            return str.length();
        }else {
            return str.length()-1;
        }
    }
}
