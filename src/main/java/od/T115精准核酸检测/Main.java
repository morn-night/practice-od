package od.T115精准核酸检测;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=Integer.valueOf(scanner.nextLine());
        int illness[]= Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[][] arr=new int[num][num];
        for (int i = 0; i < num; i++) {
            arr[i]= Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        }

        LinkedList<Integer> stack=new LinkedList<>();
        stack.addAll(Arrays.stream(illness).boxed().collect(Collectors.toList()));

        //缓存区
        List<Integer> cache=new ArrayList<>(stack);
        while (!stack.isEmpty()){
            Integer cur=stack.removeFirst();
            for (int i = 0; i < num; i++) {
                if(arr[cur][i]==1 && !cache.contains(i)){
                    stack.add(i);
                    cache.add(i);
                }
            }
        }

        System.out.println(cache.size()-illness.length);

    }
}
