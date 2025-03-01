package od.攀登者1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int[] heights= Arrays.stream(scan.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int count=0;
        for (int i = 0; i < heights.length; i++) {
            int l=i-1>=0?heights[i-1]:0;
            int r=i+1<heights.length?heights[i+1]:0;
            if(heights[i]>l && heights[i]>r){
                count++;
            }
        }
        System.out.println(count);
    }
}
