package od.T109最长的顺子;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line1=scanner.nextLine();
        String line2=scanner.nextLine();
        scanner.close();

        System.out.println(getResult(line1,line2));
    }

    private static String getResult(String line1, String line2) {
        //全排
        int[] count={0,0,0,4,4,4,4,4,4,4,4,4,4,4,4,0,4,1,1};
        //手中的排
        String[] arr1= line1.split("-");
        for (int i = 0; i < arr1.length; i++) {
            int cur=CardValue.getCardInt(arr1[i]);
            count[cur]=count[cur]-1;
        }
        //已出的排
        String[] arr2= line2.split("-");
        for (int i = 0; i < arr2.length; i++) {
            int cur=CardValue.getCardInt(arr2[i]);
            count[cur]=count[cur]-1;
        }
        //对手的排
        int l=3,r=3;
        int max_len=-1;
        //记录最大长度的起始位置
        int max_index=0;
        while (r<=15){
            if(count[r]>0){
                r++;
            }else {
                if(r-l>=max_len){
                    max_len=r-l;
                    max_index=l;
                }
                l=r+1;
                r=l;
            }
        }

        if(max_len<5){
            return "NO-CHAIN";
        }
        StringJoiner sj=new StringJoiner("-");
        for (int i = 0; i < max_len; i++) {
            sj.add(CardValue.getCardString(max_index+i));
        }
        return sj.toString();

    }

    public enum CardValue {
        J(11),
        Q(12),
        K(13),
        A(14),
        TWO(16),
        B(17),
        C(18);

        private final int value;

        CardValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static int getCardInt(String value) {
            for (CardValue cardValue : CardValue.values()) {
                if (cardValue.name().equals(value)) {
                    return cardValue.getValue();
                }
            }
            return Integer.valueOf(value);
        }

        public static String getCardString(int value) {
            for (CardValue cardValue : CardValue.values()) {
                if (cardValue.getValue() == value) {
                    return cardValue.name();
                }
            }
            return value+"";
        }
    }
}


