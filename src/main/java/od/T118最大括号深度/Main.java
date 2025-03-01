package od.T118最大括号深度;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map map=new HashMap<>();

    public static void main(String[] args) {
        String line=new Scanner(System.in).nextLine();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        System.out.println(getResult(line));
    }

    private static int getResult(String line) {
        if(null==line || line.length()==0){
            return 0;
        }
        LinkedList<Character> list=new LinkedList<>();
        int depth=0;
        for (int i = 0; i < line.length(); i++) {
            char c=line.charAt(i);
            if(list.size()>0 && map.get(c)==list.getLast()){
                list.removeLast();
            }else {
                list.add(c);
                depth=Math.max(depth,list.size());
            }
        }
        if(list.size()>0){
            return 0;
        }else {
            return depth;
        }
    }

}
