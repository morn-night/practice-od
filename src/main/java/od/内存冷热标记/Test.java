package od.内存冷热标记;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        Map<Integer,Integer> map=new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            int page=scanner.nextInt();
            map.put(page,map.containsKey(page)?map.get(page)+1:1);
        }
        int high=scanner.nextInt();
        map.entrySet().removeIf(e->e.getValue()<high);
        System.out.println(map.size());
        map.entrySet().stream().sorted(
                (a,b)->b.getValue()-a.getValue()!=0?b.getValue()-a.getValue():a.getKey()-b.getKey()
        ).forEach(e-> System.out.println(e.getKey()));
    }
}
