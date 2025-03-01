package od.相对开音节;

import cn.hutool.core.util.NumberUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Character> f_chars= Arrays.asList('a','e','i','o','u');
    public static void main(String[] args) {
        String line=new Scanner(System.in).nextLine();
        System.out.println(getResult(line));
    }

    private static int getResult(String line) {
        //反转
        String words[]=line.split(" ");
        int count=0;
        for (String word : words) {
            //判断word合法
            if(check(word)){
                int l=0,r=word.length()-1;
                char[] chars=word.toCharArray();
                while (l<r){
                    char tmp=chars[l];
                    chars[l]=chars[r];
                    chars[r]=tmp;
                    l++;
                    r--;
                }
                //判断开音节
                count+=isKYJ(chars);

            }else {
               //判断开音节
                char[] chars=word.toCharArray();
                isKYJ(chars);
            }
        }
        return count;
    }

    private static int isKYJ(char[] chars) {
        int count=0;
        for (int i = 0; i <= chars.length-4; i++) {
            //判断开音节
            if(
               !StringUtils.isAllLowerCase(new String(chars).substring(i,i+4)) ||
               f_chars.contains(chars[i]) ||
               !f_chars.contains(chars[i+1]) ||
               f_chars.contains(Arrays.asList('a','e','i','o','u',"r")) ||
               'e'!=chars[i+3]
            ){
                continue;
            }
            count++;

        }
        return count;
    }

    private static boolean check(String word) {
        if(StringUtils.isAllLowerCase(word)){
            return true;
        }else {
            return false;
        }
    }
}
