package od.分配土地;

import java.util.*;

class Site{
    private List<Integer> x;
    private List<Integer> y;

    public List<Integer> getX() {
        return x;
    }

    public void setX(List<Integer> x) {
        this.x = x;
    }

    public List<Integer> getY() {
        return y;
    }

    public void setY(List<Integer> y) {
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        Map<Integer,Site> map=new HashMap();
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                int num=scanner.nextInt();
                if(map.containsKey(num)){
                    map.get(num).getX().add(i);
                    map.get(num).getY().add(j);
                }else {
                    Site site=new Site();
                    List<Integer> x=new ArrayList<>();
                    List<Integer> y=new ArrayList<>();
                    x.add(i);
                    y.add(j);
                    site.setX(x);
                    site.setY(y);
                    map.put(num,site);
                }
            }
        }

        int result=0;
        for(int num: map.keySet()){
            if(num!=0){
                Site site=map.get(num);
                int xMax=Collections.max(site.getX());
                int xMin=Collections.min(site.getX());
                int yMax=Collections.max(site.getY());
                int yMin=Collections.min(site.getY());
                result=Math.max(result,(xMax-xMin+1)*(yMax-yMin+1));
            }

        }

        System.out.println(result);
    }
}
