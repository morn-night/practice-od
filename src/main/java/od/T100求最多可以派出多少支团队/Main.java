package od.T100求最多可以派出多少支团队;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
//        LinkedList<Integer> power=new LinkedList<>();
        int power[] =new int[n];
        for (int i = 0; i < n; i++) {
//           power.add(scanner.nextInt());
           power[i]=scanner.nextInt();
        }
        int m=scanner.nextInt();
        scanner.close();

//        Collections.sort(power,(a,b)->b-a);
        Arrays.sort(power);

        int count=0;

        int l=0,r=power.length-1;
        //单人
        while (r>=l && power[r]>=m){
            r--;
            count++;
        }

        while (l<r){
            if(power[l]+power[r]>=m){
                count++;
                l++;
                r--;
            }else {
                l++;
            }
        }



//        while (!power.isEmpty()){
//            int cur=power.getFirst();
//            if(cur>=m){
//                count++;
//                power.removeFirst();
//            }else {
//                int dd=power.getLast();
//                if(dd+cur>=m){
//                    count++;
//                    power.removeFirst();
//                    power.removeLast();
//                }else {
//                    power.removeLast();
//                }
//            }
//        }

        System.out.println(count);
    }
}
