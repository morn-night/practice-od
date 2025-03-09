package od.T98ai面板识别;


import java.util.*;
import java.util.stream.Collectors;


class Lamp{
     int id;
     int x1;
     int y1;
     int x2;
     int y2;

    public Lamp(int id, int x1, int y1, int x2, int y2) {
        this.id = id;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
}

public class Main {
    public  static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());


        List<Lamp> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int strs[]=Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.add(new Lamp(strs[0],strs[1],strs[2],strs[3],strs[4]));
        }
        List<Lamp> result=new ArrayList<>();
        List<Lamp> sameLine=new ArrayList<>();
        list.sort((a,b)->a.y1-b.y1);
        sameLine.add(list.get(0));
        Lamp up=list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if(Math.abs(list.get(i).y1-up.y1)<=(list.get(i).y2-list.get(i).y1)/2){
                sameLine.add(list.get(i));
            }else {
                sameLine.sort((a,b)->a.x1-b.x1);
                result.addAll(sameLine);
                sameLine.clear();

                up=list.get(i);
                sameLine.add(list.get(i));
            }
        }

        //最后一行
        if(sameLine.size()>0){
            sameLine.sort((a,b)->a.x1-b.x1);
            result.addAll(sameLine);
        }


        StringJoiner sj=new StringJoiner(" ");

//        list.sort((a,b)->a.y1==b.y1?a.x1-b.x1:a.y1-b.y1);
//
//        list.forEach(e->sj.add(e.getId()+""));
        result.forEach(e->sj.add(e.getId()+""));
        System.out.println(sj);

    }
}
