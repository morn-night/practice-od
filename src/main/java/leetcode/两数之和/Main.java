package leetcode.两数之和;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        
        int[] nums={2,7,11,15};
        int target=9;
        System.out.println(Arrays.toString(twoSum(nums,target)));

    }

    private static int[] twoSum(int[] nums, int target) {
        int result[]=new int[2];
        List<Integer> numsList= IntStream.of(nums).boxed().collect(Collectors.toList());
        for (int i = 0; i < nums.length; i++) {
            int num1=nums[i];
            Integer num2=target-num1;
            if(numsList.contains(num2)){
                result[0]=i;
                result[1]=numsList.indexOf(num2);
                if(result[0]!=result[1]){
                    return result;
                }
            }
        }
        return result;
    }
}
