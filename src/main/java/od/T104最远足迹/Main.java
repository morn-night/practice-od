package od.T104最远足迹;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String line=new Scanner(System.in).nextLine();

        int max_len=0;
        String result="(0,0)";

        int l=0;
        for (int i = 0; i < line.length(); i++) {
            char c=line.charAt(i);
            if(c=='('){
                l=i;
            }else if(c==')'){
                String[] pos=line.substring(l+1,i).split(",");

                if(pos[0].startsWith("0") || pos[1].startsWith("0")){
                    continue;
                }

                int x=Integer.valueOf(pos[0]);
                int y=Integer.valueOf(pos[1]);
                if(x<=0 || x>=1000 || y<=0 || y>=1000){
                    continue;
                }
                int len=x*x+y*y;
                if(len>max_len){
                    max_len=len;
                    result="("+x+","+y+")";
                }
            }
        }

        System.out.println(result);
    }
}
