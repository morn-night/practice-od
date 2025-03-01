package od.字符串分割二;

import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int k=scanner.nextInt();
        String s=scanner.next();
        System.out.println(getResult(k,s));
    }

    private static String getResult(int k, String s) {
        String[] arr=s.split("-");
        StringJoiner sj=new StringJoiner("-");
        sj.add(arr[0]);

        StringBuffer sb=new StringBuffer();
        for (int i = 1; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        String newStr=sb.toString();
        String result="";
        int xxCount=0,dxCount=0;
        for (int i = 0; i < newStr.length(); i+=k) {
            String subStr=newStr.substring(i,Math.min(i+k,newStr.length()));
            sj.add(subStr);
        }
        for (int i = 0; i < newStr.length(); i++) {

            if(Character.isLowerCase(newStr.charAt(i))){
                xxCount++;
            }else if(Character.isUpperCase(newStr.charAt(i))){
                dxCount++;
            }
        }

        if(xxCount>dxCount){
            result=sj.toString().toLowerCase();
        }else if(xxCount<dxCount){
            result=sj.toString().toUpperCase();
        }else {
            result=sj.toString();
        }
        return result;

    }
}
