package LinkedList;

public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        ListNode res=removeElements(head.next, val);
        return head.val==val?res:head;
    }


    public static void main(String[] args) {
        int[] arr={2,2,6,3,4,5,6};
        ListNode head=new ListNode(arr);
        System.out.println(head);
        System.out.println((new Solution()).removeElements(head,2));;

    }
}
