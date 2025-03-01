package od2024.流浪地球;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 发动机的总个数
        int e = sc.nextInt(); // 计划手动启动的发动机总个数
        int[] launches = new int[n]; // 记录每个发动机的最终启动时刻
        Arrays.fill(launches, 2001); // 初始化为极大值，方便后面取最早启动时刻

        for (int i = 0; i < e; i++) {
            int t = sc.nextInt(); // 发动机的手动启动时刻
            int p = sc.nextInt(); // 发动机的位置编号

            launches[p] = t; // p号发动机在t时刻手动启动
        }
        test(n,e,launches);
        test2(n,e,launches);
    }

    private static void test2(int n, int e, int[] launches) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int innerDis=Math.abs(i-j);
                int outerDis=n-innerDis;
                int minDis=Math.min(innerDis,outerDis);
                launches[j]=Math.min(launches[j],launches[i]+minDis);
            }
        }
        int maxT=0;
        ArrayList<Integer> last = new ArrayList<>(); // 最晚启动的发动机编号集合
        for (int i = 0; i < launches.length; i++) {
            int t=launches[i];
            if(t<maxT) continue;
            if(t>maxT){
                maxT=t;
                last.clear();
            }
            last.add(i);

        }
        StringJoiner stringJoiner=new StringJoiner(" ");
        last.stream().sorted((a,b)->a-b).forEach(v->stringJoiner.add(v+""));
        System.out.println(last.size());
        System.out.println(stringJoiner);
    }

    private static void test(int n, int e, int[] launches) {


        // 从编号 i 的发动机手动启动后, 关联启动到编号 j
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 内关联距离
                int innerDis = Math.abs(i - j);
                // 外关联距离
                int outerDis = n - innerDis;
                // 最短关联距离
                int dis = Math.min(innerDis, outerDis);
                launches[j] = Math.min(launches[j], launches[i] + dis);
            }
        }

        int maxT = 0; // 最晚启动时刻
        ArrayList<Integer> last = new ArrayList<>(); // 最晚启动的发动机编号集合

        for (int p = 0; p < launches.length; p++) {
            int t = launches[p]; // 当前发动机启动时刻

            if (t < maxT) continue; // 不是最晚启动的发动机

            if (t > maxT) { // 更晚启动的时刻
                maxT = t;
                last.clear();
            }

            last.add(p); // 记录该发动机编号
        }

        StringJoiner sj = new StringJoiner(" ");
        last.stream().sorted((a, b) -> a - b).forEach(p -> sj.add(p + ""));

        System.out.println(last.size());
        System.out.println(sj);
    }
}