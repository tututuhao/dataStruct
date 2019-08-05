package Leetcode;

import array.Array;
import array.ArrayStack;

import javax.swing.tree.TreeNode;
import java.util.*;


class Solution {
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode rotateRight(ListNode head, int k) {
      if(head==null) return null;
      if(head.next==null) return head;
      ListNode old_tail=head;
      int n;
      for(n=1;old_tail.next!=null;n++)
          old_tail=old_tail.next;
      old_tail.next=head;

      ListNode new_tail=head;
      for(int i=1;i<n-k%n;i++)
          new_tail=new_tail.next;
      ListNode new_head=new_tail.next;
      new_tail.next=null;
      return new_head;
    }






}