package od.计算三叉搜索树的高度;

import java.util.Scanner;

public class Main {
    static  class  TreeNode{
        int val;
        int height;
        TreeNode left;
        TreeNode mid;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static class Tree{
        TreeNode root;
        int height;
        public void add(int val){
            TreeNode node=new TreeNode(val);
            if(this.root==null){
                node.height=1;
                this.root=node;
                this.height=1;
            }else {
                TreeNode cur=this.root;
                while (true){
                    node.height=cur.height+1;
                    this.height=Math.max(node.height,this.height);
                    if(val<cur.val-500){
                        if(cur.left==null){
                            cur.left=node;
                            break;
                        }else {
                            cur=cur.left;
                        }

                    }else if(val>cur.val+500){
                        if(cur.right==null){
                            cur.right=node;
                            break;
                        }else {
                            cur=cur.right;
                        }
                    }else {
                        if (cur.mid == null) {

                            cur.mid=node;
                            break;
                        }else {
                            cur=cur.mid;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        Tree t=new Tree();
        while (true){
            int n=scn.nextInt();
            for (int i = 0; i < n; i++) {
                int num=scn.nextInt();
                t.add(num);
            }
            System.out.println(t.height);
        }

    }
}
