package od.按单词下标区间翻转文章内容;

import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        int s=Integer.valueOf(scanner.nextLine());
        int e=Integer.valueOf(scanner.nextLine());

        System.out.println(reverseWords(str,s,e));
        System.out.println(reverseWords2(str,s,e));

    }

    private static String reverseWords2(String str, int s, int e) {
        //转为数组
        String[] words=str.split(" ");
        if(words.length==0){
            return "";
        }
        //极端情况
        if(s> words.length-1 || e<0){
            return str;
        }
        //正常遍历
        int l=s<0?0:s;
        int r=e> words.length-1? words.length-1:e;
        while (l<r){
            String tmp=words[l];
            words[l]=words[r];
            words[r]=tmp;
            l++;
            r--;

        }

        return String.join(" ",words);
    }

    private static String reverseWords(String str, int s, int e) {
        String result=null;

        //转为数组
        String[] words=str.split(" ");
        if(words.length==0){
            return "";
        }
        //极端情况
        if(s> words.length-1 || e<0){
            return str;
        }
        //正常遍历
        s=s<0?0:s;
        e=e> words.length-1? words.length-1:e;
        StringJoiner sj=new StringJoiner(" ");
        for (int i = 0; i < words.length; i++) {
            if(i>=s && i<=e){
                sj.add(words[words.length-1-i]);
            }else {
                sj.add(words[i]);
            }
        }
        result=sj.toString();

        return result;
    }
}
