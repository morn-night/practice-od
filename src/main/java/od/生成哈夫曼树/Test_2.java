package od.生成哈夫曼树;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringJoiner;

public class Test_2 {
    static class Node{
        Node lchild;
        Node rchild;
        int weight;
        int height;

        public Node(Node lchild, Node rchild, int weight, int height) {
            this.lchild = lchild;
            this.rchild = rchild;
            this.weight = weight;
            this.height = height;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        PriorityQueue<Node> pq=new PriorityQueue<>((a, b)->a.weight!=b.weight?a.weight-b.weight:a.height-b.height);

        for (int i = 0; i < n; i++) {
            int w=sc.nextInt();
            Node node=new Node(null,null,w,0);
            pq.offer(node);
        }
        while (pq.size() > 1) {
            Node lc = pq.poll();
            Node rc = pq.poll();
            int fa_w = lc.weight + rc.weight;
            int fa_h = Math.max(lc.height, rc.height) + 1;

            Node fa = new Node(lc, rc, fa_w, fa_h);
            pq.offer(fa);
        }

        Node root=pq.poll();
        StringJoiner ans=new StringJoiner(" ");
        midOrder(root,ans);
        System.out.println(ans);

    }

    private static void midOrder(Node root, StringJoiner ans) {
        if(root.lchild!=null){
            midOrder(root.lchild,ans);
        }
        ans.add(root.weight+"");
        if(root.rchild!=null){
            midOrder(root.rchild,ans);
        }
    }
}
