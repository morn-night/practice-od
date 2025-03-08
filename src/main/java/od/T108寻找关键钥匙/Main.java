package od.T108寻找关键钥匙;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String key=scanner.nextLine();
        String line=scanner.nextLine();
        scanner.close();
        System.out.println(getResult(key,line));
    }

    private static int getResult(String key, String line) {
        String[] boxs=line.split(" ");
        for (int i = 0; i < boxs.length; i++) {
            String[] words=boxs[i].toLowerCase().split(" ");
            for (int k = 0; k < words.length; k++) {
                LinkedList<Character> cache=new LinkedList<>(key.chars().mapToObj(c->Character.toLowerCase((char) c)).collect(Collectors.toList()));
                char[] chars=words[k].toLowerCase().toCharArray();
                boolean flag=true;
                for (char c : chars) {
                    if(cache.contains(c)){
                        cache.removeFirstOccurrence(c);
                    }else {
                        if(Character.isLetter(c)){
                            flag=false;
                            break;
                        }
                    }
                }
                if(cache.size()==0 && flag){
                    return i+1;
                }else {
                    cache=new LinkedList<>(key.chars().mapToObj(c->(char) c).collect(Collectors.toList()));
                }
            }

        }

        return -1;
    }
}
