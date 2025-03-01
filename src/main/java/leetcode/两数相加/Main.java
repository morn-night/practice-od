package leetcode.两数相加;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public ListNode() {

    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Main {
    public static void main(String[] args) {
        int l1[]={2,4,3};
        int l2[]={5,6,4};
//        int l1[]={9,9};
//        int l2[]={9,9,9};
//        addTwoNumbers(initListNode(l1),initListNode(l2));
        addTwoNumbers2(initListNode(l1),initListNode(l2));
    }

    private static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            l1 = (l1 != null) ? l1.next : l1;
            l2 = (l2 != null) ? l2.next : l2;
        }
        return dummy.next;
    }

    private static ListNode initListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int value : arr) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=null;
        ListNode head=null;
        int flag=0;
        while (l1!=null || l2!=null){
            int temp=(l1 != null ? l1.val : 0)+(l2 != null ? l2.val : 0)+flag;
            if(temp>=10){
                temp=temp-10;
                flag=1;
            }else {
                flag=0;
            }
            if(result==null){
                head=new ListNode(temp);
                result=head;
            }else {
                head.next=new ListNode(temp);
                head=head.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        //如果flag最后=1，说明最后两位数字相加大于10,需要再前面再补一位
        if (flag==1 ) {
            head.next = new ListNode(1);
        }

        return result;
    }
}
