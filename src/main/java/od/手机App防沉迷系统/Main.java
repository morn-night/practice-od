package od.手机App防沉迷系统;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App{
     String name;
     int priority;
    int start;
    int end;

    public App(String name, int priority, int start, int end) {
        this.name = name;
        this.priority = priority;
        this.start = start;
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<App> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new App(sc.next(),sc.nextInt(),convert(sc.next()),convert(sc.next())));
        }
        String timeStr=sc.next();
        int time=convert(timeStr);
        list.sort((a,b)->b.priority-a.priority);
        List<App> registers=new ArrayList<>();
        List<Integer> idx=new ArrayList<>();
        outer:
        for(App app:list){
            if(app.start>=app.end){
                continue;
            }

            for(App register:registers){
                boolean flag=false;
                if((app.start>=register.start && app.start<register.end) ||
                        (register.start>=app.start && register.start<app.end)){
                    flag=true;
                }
                if(flag){
                    continue outer;
                }
            }
            registers.add(app);

        }
        String ans="NA";
        for(App app :registers){
            if(time>= app.start && time<app.end){
                ans=app.name;
                break;
            }
        }
        System.out.println(ans);
    }

    private static int convert(String next) {
        String[] temp=next.split(":");
        return Integer.parseInt(temp[0])*60+Integer.parseInt(temp[1]);
    }
}
