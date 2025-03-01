package od.掌握的单词个数;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        String words[]=new String[n];
        for (int i = 0; i < n; i++) {
            words[i]=scanner.next();
        }
        String chars=scanner.next();
        int count=0;
        Map<Character, Integer> map1=new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            if(chars.charAt(i)=='?'){
                count++;
            }
            if(map1.containsKey(chars.charAt(i))){
                map1.put(chars.charAt(i),map1.get(chars.charAt(i))+1);
            }else {
                map1.put(chars.charAt(i),1);
            }

        }

        int result=0;
        for (int i = 0; i < words.length; i++) {
            String str=words[i];
            int index=0;
            int length=0;
            Map<Character, Integer> map=new HashMap<>(map1);
            for (int k = 0; k < str.length(); k++) {
                if(map.containsKey(str.charAt(k))){
                    length++;
                    Integer num=map.get(str.charAt(k));
                    map.put(str.charAt(k),--num);
                    if(num==0){
                        map.remove(str.charAt(k));
                    }


                }else {
                    index++;
                }
            }
            if(index<=count){
                result++;
            }

        }
        System.out.println(result);
    }
}
