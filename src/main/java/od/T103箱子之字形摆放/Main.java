package od.T103箱子之字形摆放;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        String boxs=str.split(" ")[0];
        int width=Integer.valueOf(str.split(" ")[1]);

        List<List<String>> result=new ArrayList<>();

        for (int i = 0; i < width; i++) {
            result.add(new ArrayList<>());
        }

        boolean flag=true;
        for (int i = 0; i < boxs.length(); i++) {
            int k=i%width;
            if(k==0){
                flag=!flag;
            }
            if(flag) {
                k=width-1-k;
            }
            result.get(k).add(boxs.charAt(i)+"");

        }

        for (List<String> list : result) {
            System.out.println(String.join("",list));
        }

    }
}
