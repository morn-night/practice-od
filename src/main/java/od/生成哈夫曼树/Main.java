package od.生成哈夫曼树;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {

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
        // 创建一个Scanner对象，用于读取用户输入
        Scanner scan=new Scanner(System.in);
        // 读取用户输入的整数n
        int n=scan.nextInt();
        // 创建一个优先队列，用于存储节点
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->a.weight!=b.weight?a.weight-b.weight:a.height-b.height);

        // 循环n次，读取用户输入的整数w，并创建一个节点，将其添加到优先队列中
        for (int i = 0; i < n; i++) {
            int w=scan.nextInt();
            Node node=new Node(null,null,w,0);
            pq.offer(node);
        }
        // 当优先队列中节点数量大于1时，循环执行
        while (pq.size()>1){
            // 从优先队列中取出两个节点，分别赋值给lc和rc
            Node lc=pq.poll();
            Node rc=pq.poll();
            // 计算父节点的权重和高度
            int fa_w=lc.weight+rc.weight;
            int fa_h=Math.max(lc.height,rc.height)+1;

            // 创建一个父节点，将其添加到优先队列中
            Node fa=new Node(lc,rc,fa_w,fa_h);
            pq.offer(fa);
        }

        // 从优先队列中取出最后一个节点，赋值给root
        Node root=pq.poll();
        // 创建一个StringJoiner对象，用于存储中序遍历的结果
        StringJoiner ans=new StringJoiner(" ");
        // 进行中序遍历，并将结果添加到ans中
        midOrder(root,ans);
        // 输出ans
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
