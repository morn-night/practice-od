package od.找座位;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.println(getResult(str));
    }

    private static int getResult(String str) {
        int result=0;
        char[] chars=str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='0'){
                if((i==0 || chars[i-1]=='0') && ( i==chars.length-1 || chars[i+1]=='0')){
                    result++;
                    chars[i]=1;
                }
            }
        }
        return result;

    }
}
