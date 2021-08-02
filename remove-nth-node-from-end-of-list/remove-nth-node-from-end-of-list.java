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
    public static int size(ListNode head){
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(size(head) == 1 && n ==1){
            head = null;
            return head;
        }
        else if(n == size(head)){
            head = head.next;
            return head;
        }
        ListNode t1 = head;
        ListNode t2 = head;
        for(int i = 0 ; i < n ; i++){
            t1 = t1.next;
        }
        while(t1 != null){
            t1 = t1.next;
            t2 = t2.next;
        }
        removeAtIdx(head,t2);
        
        return head;
        
    }
    public static void removeAtIdx(ListNode head, ListNode t){
        ListNode temp = head;
        while(temp.next != t){
            temp = temp.next;
        }
        temp.next = t.next;
    }
}