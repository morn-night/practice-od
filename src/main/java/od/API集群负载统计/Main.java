package od.API集群负载统计;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        Map<Integer, Map<String,Integer>> map=new HashMap<>();
        for (int i = 0; i <n; i++) {
            String line=scan.next();
            String[] lines=line.split("/");
            for (int k = 1; k < lines.length; k++) {
                Map v=map.get(k)!=null?map.get(k):new HashMap();
                if(map.get(k)!=null && map.get(k).containsKey(lines[k])){
                    v.put(lines[k],map.get(k).get(lines[k])+1);
                }else {
                    v.put(lines[k],1);
                }
                map.put(k,v);
            }
        }
        int m=scan.nextInt();
        String string=scan.next();
        int result=map.get(m).get(string)!=null?map.get(m).get(string):0;
        System.out.println(result);
    }
}
