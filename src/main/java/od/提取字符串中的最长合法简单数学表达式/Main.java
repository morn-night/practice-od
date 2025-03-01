package od.提取字符串中的最长合法简单数学表达式;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine().toLowerCase();
        int maxLen=0;
        int result=0;
        Pattern pattern=Pattern.compile("^([+-]?\\d+)([+*-])(\\d+)$");
        for (int i = 0; i < line.length(); i++) {
            for (int j = i; j < line.length(); j++) {
                String sub=line.substring(i,j+1);
                Matcher matcher=pattern.matcher(sub);
                if(matcher.find()&& sub.length()>maxLen){
                    maxLen=sub.length();
                    int num1=Integer.parseInt(matcher.group(1));
                    String op=matcher.group(2);
                    int num2=Integer.parseInt(matcher.group(3));

                    switch (op){
                        case "*":
                           result=num1*num2;
                           break;
                        case "+":
                            result=num1+num2;
                            break;
                        case "-":
                            result=num1-num2;
                            break;

                    }
                }
            }
        }
        System.out.println(result);
    }
}
