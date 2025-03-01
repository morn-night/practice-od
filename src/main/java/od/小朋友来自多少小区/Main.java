package od.小朋友来自多少小区;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] nums= Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int ans=0;
        for(int key:map.keySet()){
            int total=key+1;
            ans+=Math.ceil(map.get(key)*1.0/total)*total;
        }
        System.out.println(ans);
    }

}
