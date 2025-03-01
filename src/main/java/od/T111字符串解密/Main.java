package od.T111字符串解密;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str1=scanner.nextLine()+"1";
        String str2=scanner.nextLine();
        scanner.close();;

        //判断加扰分割
        StringBuffer cache=new StringBuffer();
        LinkedList<String> words=new LinkedList<>();
        for (int i = 0; i < str1.toCharArray().length; i++) {
            char c=str1.charAt(i);
            if(!isJR(c)){
                cache.append(c);
            }else {
                if(cache.length()>0 && countChars(cache.toString())<=countChars(str2)){

                    words.add(cache.toString());
                    cache.setLength(0);
                }

            }

        }
//        System.out.println(words);
        String result="Not Found";
        //统计不同字符大小排序
        if(words.size()>0){
            Collections.sort(words, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int diff=countChars(o2)-countChars(o1);
                    if (diff!=0){
                        return diff;
                    }

                    return o2.compareTo(o1);
                }

            });

            //结果
            result=words.get(0);
        }

        System.out.println(result);

    }

    private static boolean isJR(char c) {
        //如果是数字 0-9
        //如果是字母 a-f
        if(Character.isDigit(c) || ( c>='a' && c<='f')){
            return true;
        }
        return false;
    }

    private static int countChars(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }
        return uniqueChars.size();
    }
}
