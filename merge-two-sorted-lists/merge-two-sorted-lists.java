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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
    ListNode temp=ans;
    
    //We are traversimg the smallest linklist
    ListNode t1 =l1 , t2=l2;
    while(t1!=null && t2!=null){
        if(t1.val>=t2.val){
            ListNode node = new ListNode();
            temp.next=node;
            node.val=t2.val;
            t2=t2.next;
            temp=temp.next;
        }
        else{
            ListNode node = new ListNode();
            temp.next=node;
            node.val=t1.val;
            t1=t1.next;
            temp=temp.next;
        }
    }
    
    //Filling the rest of 1st linklist
    
    while(t1!=null){
            ListNode node = new ListNode();
            temp.next=node;
            node.val=t1.val;
            t1=t1.next;
         temp=temp.next;
    }
    
     //Filling the rest of 2nd linklist
    
    while(t2!=null){
            ListNode node = new ListNode();
            temp.next=node;
            node.val=t2.val;
            t2=t2.next;
         temp=temp.next;
    }
    return ans.next;
    }
}