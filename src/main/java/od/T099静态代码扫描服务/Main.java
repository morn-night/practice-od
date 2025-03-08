package od.T099静态代码扫描服务;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m=Integer.parseInt(scanner.nextLine());
        int[] files= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] filesSize= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(getResult(m,files,filesSize));
    }

    private static int getResult(int m, int[] files, int[] filesSize) {
        int result= 0;


        Map<Integer,Integer> fileMap=new HashMap<>();
        Map<Integer,Integer> fileSizeMap=new HashMap<>();
        for (int i = 0; i < files.length; i++) {
            fileMap.put(files[i],fileMap.getOrDefault(files[i],0)+1);
            fileSizeMap.put(files[i],filesSize[i]);
        }


        for (Integer file : fileMap.keySet()) {
            int noCache=fileMap.get(file)*fileSizeMap.get(file);
            int cache=m+fileSizeMap.get(file);
            result+=Math.min(noCache,cache);
        }

        return result;

    }
}
