package LinkedList;


public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public ListNode(int[] arr){
        if(arr==null||arr.length==0)
            throw new IllegalArgumentException("arr can not be empty");
       this.val=arr[0];
       ListNode cur=this;
       for(int i=1;i<arr.length;i++){
        cur.next=new ListNode(arr[i]);
        cur=cur.next;
       }
    }

    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while(cur != null){
            s.append(cur.val + "->");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
  }
