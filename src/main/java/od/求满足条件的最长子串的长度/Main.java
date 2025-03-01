package od.求满足条件的最长子串的长度;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println(getResult(scanner.nextLine()));
        System.out.println(test(scanner.nextLine()));
    }

    private static String test(String s) {
        String result="";
        int l=0,r=0;
        int maxLen=0;
        boolean hasLe=false;
        LinkedList<Integer> list=new LinkedList<>();
        while (r<s.length()){
            char c=s.charAt(r);
            if(Character.isLetter(c)){
                list.add(r);
                hasLe=true;
            }
            if(list.size()>1){
                l=list.removeFirst()+1;

            }
            if(r==l){
                r++;
                continue;
            }
            maxLen=Math.max(maxLen,r-l+1);
            r++;
            if(r-l+1>maxLen){
                result=s.substring(l,r);
            }
        }
        return result;
    }

    private static String getResult(String str) {
        String ans="";
        boolean hasLetter=false;
        int l=0,r=0;
        int maxlen=0;
        LinkedList<Integer> letterIdx=new LinkedList();
        while (r<str.length()){
            char c=str.charAt(r);
            if(Character.isLetter(c)){
                hasLetter=true;
                letterIdx.add(r);

                if(letterIdx.size()>1){
                    l=letterIdx.removeFirst()+1;
                }
                if(r==l){
                    r++;
                    continue;
                }
            }
            maxlen=Math.max(maxlen,r-l+1);
            r++;
            if(r-l+1>maxlen){
                ans=str.substring(l,r);
            }

        }


        return ans.toString();
    }

}
