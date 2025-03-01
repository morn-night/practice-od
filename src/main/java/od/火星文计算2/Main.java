package od.火星文计算2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        Pattern pattern=Pattern.compile("(\\d+)#(\\d+)");
        while (true){
            Matcher matcher=pattern.matcher(str);
            if(!matcher.find()){
                break;
            }
            String subStr= matcher.group(0);
            long x=Long.parseLong(matcher.group(1));
            long y=Long.parseLong(matcher.group(2));
            str=str.replaceFirst(subStr,4*x+3*y+2+"");

        }

        Pattern pattern2=Pattern.compile("(\\d+)\\$(\\d+)");
        Matcher matcher=pattern2.matcher(str);
        while (matcher.find()){

            String subStr= matcher.group(0);
            long x=Long.parseLong(matcher.group(1));
            long y=Long.parseLong(matcher.group(2));
            str=str.replaceFirst(x+"\\$"+y,2*x+y+3+"");

        }
        System.out.println(str);
    }
}
