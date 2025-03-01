package od2024.英文输入法;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        String str=scanner.nextLine();

        String words[]=line.split("[^a-zA-Z]");
        Arrays.sort(words);
        StringJoiner result=new StringJoiner(" ");
        List<String> list=new ArrayList<>();
        for (String word : words) {
            if(word.startsWith(str) && !list.contains(word)){
                result.add(word);
            }
            list.add(word);
        }
        if(result.length()==0) result.add(str);
        System.out.println(result.toString());

    }
}
