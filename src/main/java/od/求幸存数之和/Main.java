package od.求幸存数之和;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int[] nums= Arrays.stream(scan.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int jump=scan.nextInt();
        int left=scan.nextInt();
        List<Integer> list=Arrays.stream(nums).boxed().collect(Collectors.toList());
        int start=1;
        while (list.size()>left){
            start+=jump;
            start%=list.size();
            list.remove(start);
        }
        System.out.println(list.stream().reduce(Integer::sum).orElse(0));
    }
}
