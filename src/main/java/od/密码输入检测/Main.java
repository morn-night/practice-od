package od.密码输入检测;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str1=scanner.nextLine();
        String str="";
        if(str1.length()>0 && str1.replaceAll("<","").length()>0){
            for (int i = 0; i < str1.length(); i++) {
                if(str1.charAt(i)=='<' ){
                    if(i!=0){
                        str=str.substring(0,str.length()-1);
                    }

                }else {
                    str+=str1.charAt(i);
                }
            }
        }
        boolean result=false;
        int dx=0,xx=0,sz=0;
        Pattern pattern=Pattern.compile("[^a-zA-Z0-9\\s]");
        Matcher matcher=pattern.matcher(str);
        if(str.length()>=8){
            for (int i = 0; i < str.length(); i++) {
                if (Character.isUpperCase(str.charAt(i))){
                    dx++;
                }
                if (Character.isLowerCase(str.charAt(i))){
                    xx++;
                }
                if(Character.isDigit(str.charAt(i))){
                    sz++;
                }


            }
            if(dx>0 && xx>0 && sz>0 && matcher.find()){
                result=true;
            }
        }
        System.out.println(str+","+result);

    }
}
