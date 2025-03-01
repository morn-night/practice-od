package od.T116比赛的冠亚季军;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long[] strengths = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();

        LinkedList<List<Integer>> link = new LinkedList<>();

        List<Integer> sports = new ArrayList<>();
        for (int i = 0; i < strengths.length; i++) sports.add(i);
        link.add(sports);

        // 冠军组如果不是一个人，那么还需要取出冠军组继续进行晋级赛
        while (link.getFirst().size() > 1) {
            List<Integer> ids = link.removeFirst();

            // 记录获胜组
            List<Integer> win = new ArrayList<>();
            // 记录失败组
            List<Integer> fail = new ArrayList<>();

            for (int i = 1; i < ids.size(); i += 2) {
                // 序号大的运动员
                int majorId = ids.get(i);
                // 序号小的运动员
                int minorId = ids.get(i - 1);

                if (strengths[majorId] > strengths[minorId]) {
                    win.add(majorId);
                    fail.add(minorId);
                } else {
                    // 如果序号大的运动员的实力 <= 序号小的运动员，则序号小的运动员获胜
                    win.add(minorId);
                    fail.add(majorId);
                }
            }

            // 如果晋级赛中运动员个数是奇数个，那么最后一个运动员直接晋级
            if (ids.size() % 2 != 0) {
                win.add(ids.get(ids.size() - 1));
            }

            // 依次头部压入失败组，获胜组，保证头部是获胜组
            link.addFirst(fail);
            link.addFirst(win);
        }

        // 冠军组只有一个人
        int first = link.get(0).get(0);

        // 亚军组只有一个人
        int second = link.get(1).get(0);

        // 季军组可能有一个人，也可能有两个人
        link.get(2).sort((a, b) -> strengths[a] != strengths[b] ? Long.compare(strengths[b], strengths[a]) : a - b);
        int third = link.get(2).get(0);

        System.out.println(first + " " + second + " " + third);
    }
}