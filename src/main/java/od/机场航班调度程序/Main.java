package od.机场航班调度程序;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String[] flights=scan.nextLine().split(",");
        Arrays.sort(flights);
        StringJoiner ans=new StringJoiner(",");
        for (int i = 0; i < flights.length; i++) {
            ans.add(flights[i]);
        }
        System.out.println(ans);
    }
}
