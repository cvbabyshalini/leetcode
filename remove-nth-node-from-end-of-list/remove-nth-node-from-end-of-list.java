/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0 ;
        ListNode temp = head ;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        if(size == 1 && n == 1)
            return null;
        if(size == n)
            return head.next;
        ListNode t1 = head;
        for(int i = 0 ; i < n ; i++){
            t1=t1.next;
        }
        ListNode t2 = head;
        while(t1!=null){
            t1= t1.next;
            t2 = t2.next;
        }
        t1 = head;
        while(t1.next != t2){
            t1 = t1.next;
        }
        t1.next = t2.next;
        return head;
    }
}