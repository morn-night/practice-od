package od.T112寻找密码;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String> strs= Arrays.stream(scanner.nextLine().split(" ")).map(String::valueOf).collect(Collectors.toList());
        scanner.close();

        System.out.println(getResult(strs));
    }

    private static String getResult(List<String> strs) {
        String result="";
        for (int i = 0; i < strs.size(); i++) {
            String c=strs.get(i);
            while (c.length()>0){
                c=c.substring(0,c.length()-1);
                if(!strs.contains(c)){
                    break;
                }
            }
            if(c.length()==0){
                result=result.length()==strs.get(i).length()?(result.compareTo(strs.get(i))>=0?result:strs.get(i)):result.length()>strs.get(i).length()?result:strs.get(i);
            }

        }
        return result;
    }
}
