package od.多段线数据压缩;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] nums= Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringJoiner sj=new StringJoiner(" ");
        int preX=nums[0];
        int preY=nums[1];
        String preK="";
        for (int i = 2; i < nums.length; i+=2) {
            int curX=nums[i];
            int curY=nums[i+1];
            int curDirectX=curX-preX;
            int curDirectY=curY-preY;
            String k="";
            if(curDirectX==0){
                k="y";
            }else if(curDirectY==0){
                k="x";
            }else {
                k=String.valueOf(curDirectY/curDirectX);
            }
            if(!preK.equalsIgnoreCase(k)){
                sj.add(preX+" "+preY);
            }
            preX=curX;
            preY=curY;
            preK=k;
        }
        sj.add(preX+" "+preY);
        System.out.println(sj.toString());
    }
}
