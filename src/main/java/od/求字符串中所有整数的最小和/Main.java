package od.求字符串中所有整数的最小和;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        boolean isNegative=false;
        StringBuilder negative=new StringBuilder();
        BigInteger ans=new BigInteger("0");
        for (int i = 0; i < str.length(); i++) {
            char c=str.charAt(i);
            if(c>='0' && c<='9'){
                if(isNegative){
                    negative.append(c);
                }else {
                    ans=ans.add(new BigInteger(c+""));
                }
            }else {
                if(isNegative && negative.length()>0){
                    ans=ans.subtract(new BigInteger(negative.toString()));
                    negative=new StringBuilder();
                }
                isNegative=c =='-';
            }
        }
        if(negative.length()>0){
            ans=ans.subtract(new BigInteger(negative.toString()));
        }
//        System.out.println(ans.toString());
        System.out.println(getResult(str));
    }

    private static int getResult(String str) {
        int sum=0;
        char arr[]=str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c=arr[i];
            if(Character.isDigit(c)){
                sum+=Integer.parseInt(String.valueOf(c));
            }
            if(c=='-'){
                StringBuffer sb=new StringBuffer("0");
                while (++i<arr.length && Character.isDigit(arr[i])){
                    sb.append(arr[i]);
                }

                sum-=Integer.parseInt(sb.toString());
                i--;
            }
        }

        return sum;
    }
}
