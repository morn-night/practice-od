package od.来自异国的客人;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        long k=scanner.nextInt();
        long n=scanner.nextInt();
        long m=scanner.nextInt();

        int ans=0;
        if(n>=m){
            ans=0;
        }
        while (k>0){
            long remain=k%m;
            if(remain==n){
                ans++;
            }
            k=k/m;
        }
        System.out.println(ans);
    }
}
