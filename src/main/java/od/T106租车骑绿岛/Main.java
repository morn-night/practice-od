package od.T106租车骑绿岛;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        Integer weights[]=new Integer[n];
        for (int i = 0; i < n; i++) {
            weights[i]=scanner.nextInt();
        }
        scanner.close();

        Arrays.sort(weights);

        int count=0;
        int l=0;
        int r=n-1;

        while (l<=r){
            if(weights[l]+weights[r]<=m){
                count++;
                l++;
                r--;
            }else {
                count++;
                r--;
            }
        }

//        LinkedList<Integer> list=new LinkedList<>();
//        list.addAll(Arrays.asList(weights));
//
//        int count=0;
//        while (!list.isEmpty()){
//            Integer cur=list.removeFirst();
//            if(cur<m){
//                for (int i = 0; i <= m - cur; i++) {
//                    if(list.contains(m-cur-i)){
//                        list.removeFirstOccurrence(m-cur-i);
//                        count++;
//                        break;
//                    }else if(m-cur-i==0){
//                        count++;
//                    }
//                }
//
//            }else {
//                count++;
//            }
//        }

        System.out.println(count);

    }
}
