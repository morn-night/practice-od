package od2024.考勤信息;

import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String[][] records = new String[n][];
        for (int i = 0; i < n; i++) {
            records[i] = sc.nextLine().split(" ");
        }

//        getResult(n, records);
        getResult2(n, records);
    }

    private static void getResult2(int n, String[][] records) {
        StringJoiner result=new StringJoiner(" ");
        for (int i = 0; i < n; i++) {
            boolean flag=check(records[i]);
            result.add(flag+"");
        }
        System.out.println(result);
    }

    private static boolean check(String[] record) {

        int presentCount=0;
        int absentCount=0;
        String pre="";
        for (int i = 0; i < record.length; i++) {
            if (i >= 7) {
                // 滑窗长度最大为7，如果超过7，则滑窗的左边界需要右移, 滑窗失去的部分record[i - 7]
                // 如果失去部分是present，则更新滑窗内present次数
                if ("present".equals(record[i - 7])) presentCount--;
            }
            String cur=record[i];
            switch (cur){
                case "present":
                    presentCount++;
                    break;
                case "absent":
                    // 缺勤不超过一次
                    if (++absentCount > 1) return false;
                case "late":
                case "leaveearly":
                    // 没有连续的迟到/早退
                    if ("late".equals(pre) || "leaveearly".equals(pre)) return false;
                    break;
            }
            pre=cur;

            // 任意连续7次考勤，缺勤/迟到/早退不超过3次, 相当于判断： 滑窗长度 - present次数 <= 3
            int window_len = Math.min(i + 1, 7); // 滑窗长度
            if (window_len - presentCount > 3) return false;
        }

        return true;

    }

}