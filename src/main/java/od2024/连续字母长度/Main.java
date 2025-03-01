package od2024.连续字母长度;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        int k=Integer.parseInt(scanner.nextLine());

        System.out.println(getResult(line,k));

    }

    private static int getResult(String line, int k) {
        Map<Character,Integer> map=new HashMap<>();
        LinkedList<Character> cache=new LinkedList<>();
        Character pre=null;
        for (int i = 0; i < line.length(); i++) {
            Character  c=line.toCharArray()[i];
            pre=i-1<0?c:line.toCharArray()[i-1];
            if(cache.contains(c) ||i==0){
                cache.add(c);
            }else {
                map.put(pre,cache.size());
                cache.clear();;
                cache.add(c);
            }
        }
        //最后
        map.put(cache.getLast(),cache.size());

        Integer[] array = map.values().toArray(new Integer[0]);
        if(k>array.length || k<=0){
            return -1;
        }else {
            Arrays.sort(array,(a,b)->b-a);
            return array[k-1];
        }
    }
}
