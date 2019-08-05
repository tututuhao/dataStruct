package LinkedList;

public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;

        while(prev.next != null){
            if(prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }

        return dummyHead.next;
    }


    public static void main(String[] args) {
        int[] arr={2,2,6,3,4,5,6};
        ListNode head=new ListNode(arr);
        System.out.println(head);
        System.out.println((new Solution()).removeElements(head,2));;

    }
}
