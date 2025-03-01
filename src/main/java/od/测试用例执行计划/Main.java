package od.测试用例执行计划;

import java.util.*;
import java.util.stream.Collectors;

class Case{
    int id;
    int[] seq;
    int sum;

    public Case(int id, int[] seq, int sum) {
        this.id = id;
        this.seq = seq;
        this.sum = sum;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        Map<Integer,Integer> priority=new HashMap<>();
        List<Case> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {

            priority.put(i+1,scanner.nextInt());
        }
        scanner.nextLine();
        for (int i = 0; i < m; i++) {
            String line=scanner.nextLine();
            int[] seq= Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int sum=0;
            for (int k = 0; k < seq.length; k++) {
                sum+=priority.get(seq[k]);
            }
            list.add(new Case(i+1,seq,sum));
        }

        list=list.stream().sorted((a,b)->a.sum!=b.sum?b.sum-a.sum:a.id-b.id).collect(Collectors.toList());
        list.forEach(e-> System.out.println(e.id));

    }
}
