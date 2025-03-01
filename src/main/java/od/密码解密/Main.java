package od.密码解密;

import cn.hutool.core.util.NumberUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static String key;

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String target=scan.nextLine();
        String str=new String(target);
        for(int i=26;i>=1;i--){
            String key= i+(i>9?"\\*":"");
            String val=String.valueOf((char) ('a'+i-1));
            str=str.replaceAll(key,val);
        }
//        System.out.println(str);
        System.out.println(getResult(target));
    }

    private static String getResult(String str) {
        String resut="";
        LinkedList<String> stack=new LinkedList<>();
        int index=str.length()-1;
        while (index>=0){
            if(str.toCharArray()[index]=='*'){
                String s=str.substring(index-2,index);
                stack.push(String.valueOf((char)('a'+Integer.parseInt(s)-1)));
                index=index-3;
            }else {
                String s=str.substring(index,index+1);
                stack.push(String.valueOf((char)('a'+Integer.parseInt(s)-1)));
                index=index-1;
            }
        }

        while (!stack.isEmpty()){
            resut+=stack.pollFirst();
        }
        //1->1   10*->i
        return resut;
    }


}
