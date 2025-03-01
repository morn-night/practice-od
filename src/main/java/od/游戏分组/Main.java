package od.游戏分组;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] nums=new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i]=scanner.nextInt();
        }
        System.out.println(getResult(nums));
    }

    private static int getResult(int[] nums) {
        List<List<List<Integer>>> combinations = generatePartitions(nums);
        int result=Integer.MAX_VALUE;
        for (List<List<Integer>> combination : combinations) {
            List<Integer> list1=combination.get(0);
            List<Integer> list2=combination.get(1);
            result=Math.min(result,Math.abs(list1.stream().mapToInt(Integer::intValue).sum()-list2.stream().mapToInt(Integer::intValue).sum()));

        }
        return result;
    }

    private static List<List<List<Integer>>> generatePartitions(int[] nums) {
        List<List<List<Integer>>> combinations=new ArrayList<>();
        List<List<Integer>> currentCombination=new ArrayList<>();
        List<Integer> group1=new ArrayList<>();
        List<Integer> group2=new ArrayList<>();
        generate(nums,0,group1,group2,currentCombination,combinations);
        return combinations;
    }

    private static void generate(int[] nums, int index, List<Integer> group1, List<Integer> group2, List<List<Integer>> currentCombination, List<List<List<Integer>>> combinations) {
        if(index==nums.length){
            if(group1.size()==5 && group2.size()==5){
                currentCombination.add(new ArrayList<>(group1));
                currentCombination.add(new ArrayList<>(group2));
                combinations.add((new ArrayList<>(currentCombination)));
                currentCombination.remove(currentCombination.size()-1);
                currentCombination.remove(currentCombination.size()-1);
            }
            return;
        }
        group1.add(nums[index]);
        generate(nums,index+1,group1,group2,currentCombination,combinations);
        group1.remove(group1.size()-1);
        group2.add(nums[index]);
        generate(nums,index+1,group1,group2,currentCombination,combinations);
        group2.remove(group2.size()-1);


    }
}
