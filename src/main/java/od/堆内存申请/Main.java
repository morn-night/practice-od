package od.堆内存申请;

import com.sun.deploy.util.StringUtils;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    @Data
    static class Case{
        int start;
        int end;
        int size;

        public Case(int start, int size) {
            this.start = start;
            this.end = start+size-1;
            this.size = size;
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=Integer.valueOf(scanner.nextLine());
        int content[]=new int[100];
        List<Case> list=new ArrayList<>();
        list.add(new Case(0,0));
        while ((scanner.hasNextLine())){
            String str=scanner.nextLine();
            if(null==str || str.length()==0){
                break;
            }
            int index=Integer.valueOf(str.split(" ")[0]);
            int size=Integer.valueOf(str.split(" ")[1]);
            list.add(new Case(index,size));

        }
        list.add(new Case(100,1));

        int index=0;
        int result=-1;
        int min_remian=100;
        while (index<=list.size()-2){
            Case pre=list.get(index);
            Case cur=list.get(++index);
            int remain=cur.start-pre.end-1;
            if(remain>=num && remain<min_remian){
                result=pre.end+1;
                min_remian=remain;
            }
        }

        System.out.println(result);


    }
}
