package od.T117最多提取子串数目;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String a=scanner.nextLine();
        String b=scanner.nextLine();
        System.out.println(getResult(a,b));
    }

    private static int getResult(String st1, String st2) {
        LinkedList<Character> arrA= stringToLinkedList(st1);
        LinkedList<Character> arrB= stringToLinkedList(st2);
        final LinkedList<Character> f_arrB= stringToLinkedList(st2);
        int index=0;
        int count=0;
        while (index<arrA.size()){
            char a=arrA.get(index);
            char b=arrB.getFirst();
            if(a==b){
                arrA.remove(index);
                arrB.removeFirst();
                if(arrB.isEmpty()){
                    arrB=new LinkedList<>(f_arrB);
                    count++;
                    //遍历完一次 初始化index
                    index=0;
                }
            }else {
                index++;
            }


        }

        return count;
    }

    public static LinkedList<Character> stringToLinkedList(String str) {
        LinkedList<Character> linkedList = new LinkedList<>();

        // 将每个字符添加到 LinkedList 中
        for (int i = 0; i < str.length(); i++) {
            linkedList.add(str.charAt(i));
        }

        return linkedList;
    }
}
