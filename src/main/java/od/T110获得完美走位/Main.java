package od.T110获得完美走位;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        scanner.close();;

        System.out.println(getResult(line));


    }

    private static int getResult(String line) {
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < line.length(); i++) {
            Character c=line.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int avg=line.length()/4;

        int total=0;
        boolean flag=true;

        for (Character c : map.keySet()) {
            if(map.get(c)>avg){
                flag=false;
                map.put(c,map.get(c)-avg);
                total+=map.get(c);
            }else {
                map.put(c,0);
            }
        }

        if(flag) return 0;

        int min=line.length();

        int l=0,r=0;
        while (r<line.length()){
            Character rc=line.charAt(r);
            if(map.get(rc)>0){
                total--;
            }
            map.put(rc,map.get(rc)-1);

            while (total==0){
                min=Math.min(min,r-l+1);

                Character lc=line.charAt(l);
                if(map.get(lc)>=0){
                    total++;
                }
                map.put(lc,map.get(lc)+1);
                l++;
            }
            r++;
        }
        return min;
    }

}
