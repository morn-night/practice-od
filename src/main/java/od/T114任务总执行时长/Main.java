package od.T114任务总执行时长;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] strs= Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int a=strs[0];
        int b=strs[1];
        int n=strs[2];

        System.out.println(getResult(a,b,n));

    }

    private static String getResult(int a, int b, int n) {
        if(n==0) return "[]";
        if(a==b) return Arrays.asList(a*n).toString();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(a*i+b*(n-i));
        }
        list.sort((v1,v2)->v1-v2);
        return list.toString();
    }
}
