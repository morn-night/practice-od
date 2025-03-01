package od.内存冷热标记;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int nums[]=new int[n];
        Map<Integer,Integer> map=new HashMap();
        for (int i = 0; i < n; i++) {
            nums[i]=scanner.nextInt();
            if(map.containsKey(nums[i])){
                int count=map.get(nums[i])+1;
                map.put(nums[i],count);
            }else {
                map.put(nums[i],1);
            }
        }

        int m=scanner.nextInt();
        int count=0;
        List<Integer> list=new ArrayList<>();

        for(int key:map.keySet()){
            int i=0;
            if(map.get(key)>=m){
                count++;
                list.add(key);
            }
        }
        System.out.println(count);
        if(list.size()>0){
            Collections.sort(list);
            list.forEach(e->{
                System.out.println(e);
            });
        }

        map.keySet().removeIf(ee->map.get(ee)<m);
        map.entrySet().stream().sorted((a,b)->
                a.getValue()-b.getValue()!=0
                        ? b.getValue()-a.getValue()
                        : a.getKey()-b.getKey()).forEach(a-> System.out.println(a.getKey()));
    }
}
